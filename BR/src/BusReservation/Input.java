package BusReservation;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import model.domain.*;
import DBUtil.Util;
import controller.DataController;


public class Input extends Reservation{
	Reservation R=new Reservation();
	static int child=1000,student=500,elder=800;// 7세미만 유아 , 20세미만 student , 65세이상 노인 할인율
	static int AM=10, PM=5; // 오전 오후 할인율
	ArrayList<bus_serial> busTables = new ArrayList<>();
	
	public void create() {
		while(true) {
			
			System.out.println("버스를 예약 하시겠습니까 1.예 2.아니오, 3.예약번호 확인");
			R.customerInfo.clear();//R객체의 이름., 나이 비워줌
			busTables.clear();//버스 테이블 비워줌
			Scanner ac = new Scanner(System.in);
			String a = ac.next();
			if(a.equals("1")) {
				System.out.println("승객이 몇명인가요?");
				Scanner sc = new Scanner(System.in);
				String b = ac.next();
				int cusnum = Integer.parseInt(b);
				try {
					userInputNum(cusnum);
				} catch (reserveException e) {
					e.printStackTrace();
					continue;
				}
				R.customerNum=cusnum;
				for(int i=0; i<cusnum; i++) {
					System.out.println(R.customerNum+"명 예약하셨습니다.***");
					System.out.println("승객 이름을입력해주세요");
					Scanner bc = new Scanner(System.in);
					String cusname = bc.next();
					System.out.println("승객 나이를입력해주세요");
					Scanner cc = new Scanner(System.in);
					String age = cc.next();
					int age1 = Integer.parseInt(age);
					checkOut(age1);
					R.customerInfo.put(cusname,age1);
				}
				System.out.println("승차지를 선택해주세요 Seoul Busan Incheon Daegu");
				Scanner dc = new Scanner(System.in);
				String start = dc.next();
				R.startLoc=start;

				System.out.println("하차지 선택해주세요 Seoul Busan Incheon Daegu");
				Scanner ec = new Scanner(System.in);
				String end = dc.next();
				R.endLoc=end;
				
				
				try {
					busTables = DataController.bus_select(start, end);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//start와 end의 매개변수를 가지고 조건에 맞는 bus를 담아서 가져옴
				// 만약 busTable이 비어 있다면(일치x) 예외발생 그 이유는 start와 end 중에 하나가 잘못 입력되었다는 뜻 그러면 start와 end를 다시 받아야 함.
				if (busTables.size()==0) {
					System.out.println("승하차지를 잘못 입력하셨습니다.");
					continue;
				}
				busTable(busTables); //버스에 대한 테이블 출력 ex) "번호: %d, 버스타입: %s, 시간: %s, 버스이름: %s, 출발지: %s, 도착지: %s"
				
				System.out.println("\n 몇번째 버스를 고르시겠습니까");
				Scanner fc = new Scanner(System.in);
				int time = fc.nextInt();
				if (time >= busTables.size() && time < 1) {
					System.out.println("유효한 범위를 입력하세요");
					continue;
				}
				bus_serial correct_bus = busTables.get(time-1); 
				R.time=correct_bus.getBus_time();
				int bus_serial_num = 0;
				try {
					DataController.rev_insert(correct_bus.getBus_serial_num());
					bus_serial_num = DataController.rev_select(correct_bus.getBus_serial_num());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				priceCal(R,bus_serial_num);
				showReservation(R); //=========== 예약 정보 =========== 출력
				System.out.println("예약을 완료했습니다.");
				try {
					System.out.println();
					System.out.println(String.format("고객님의 rev 번호는 %d 고객님의 버스 번호는 %s 입니다.",bus_serial_num,correct_bus.getBus_serial_num()));
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(a.equals("2")) {
				System.out.println("시스템종료");
				break;
			} 
			else if(a.equals("3")) {
				System.out.println("예약번호를 입력하세요 : ");
				Scanner asdf = new Scanner(System.in);
				ArrayList<customer> cusList = new ArrayList<>(); 
				int rev_nu = asdf.nextInt();
				try {
					cusList = DataController.cus_select(rev_nu);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for (int i = 0; i < cusList.size(); i++) {
				    customer cus = cusList.get(i);
				    System.out.println("번호: " + (i+1) +
				            ", 이름 : " + cus.getName() +
				            ", 나이 : " + cus.getAge() +
				            ", 가격 : " + cus.getPrice() +
				            ", 예약번호 : " + cus.getReservation_ID() +
				            " ");
				}
			}
			else {
				System.out.println("제대로 입력");
			}
		}
	}

	private void priceCal(Reservation r,int bus_serial_num){
		for (Entry<String, Integer> entry : r.customerInfo.entrySet()) {
            String key = entry.getKey();//이름
            Integer value = entry.getValue();//나이
            //int hour=Integer.parseInt(R.time.split(":")[0]);//string인 time을 int로
            int Price=10000;
//            if() { 		//고속버스이면
//            	Price=12000;
//            }
//            else {		//시외버스이면
//            	Price=20000;
//            }
            Price=checkAge(Price,value);
            Price =checkTime(Price,R.time);
            System.out.println("이름: " + key + ", 나이: " + value+ ", 가격"+ Price);
            try {
				DataController.cus_insert(key,value,Price,bus_serial_num);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		
	}
	private int checkTime(int Price,String time) {
		int hour=Integer.parseInt(R.time.split(":")[0]);//string인 time을 int로
		if(hour>0 && hour<12) {
			//Price=(Price)*((100-AM)/100);
			Price=(Price*(100-AM))/100;
			//Price=Price-AM;
			System.out.println("오전가격은 "+AM+"% 만큼 할인됩니다.");
		}
		else {
			Price=(Price*(100-PM))/100;
			//Price=Price-PM;
			System.out.println("오후가격은 "+PM+"% 만큼 할인됩니다.");
		}
		return Price;
	}
	private int checkAge(int Price, int value) {
		
		if(value<7) {//일곱살 아래면 
        	Price=Price-child;
        	//System.out.println(Price);
        }
        else if (value<18) {//청소년이면
        	Price=Price-student;
        	//System.out.println(Price);
        }
        else if (value>65) {//노인이면
        	Price=Price-elder;
        	//System.out.println(Price);
        }
		return Price;
	}
	private void checkOut(int age) {
		if(age<7) {//일곱살 아래면 
        	System.out.println("어린이 가격으로 적용됩니다**");
        }
        else if (age<18) {//청소년이면
        	System.out.println("청소년 가격으로 적용됩니다**");
        }
        else if (age>65) {//노인이면
        	System.out.println("노인 가격으로 적용됩니다.**");;
        }
        else {
        	System.out.println("성인 가격으로 적용됩니다.**");
        }
		
	}

	private void showReservation(Reservation r) {
	    System.out.println("=========== 예약 정보 ===========");
	    System.out.println("예약한 승객 수: " + r.customerNum);
	    
	    System.out.println("---승객 정보---");
	    for (Map.Entry<String, Integer> entry : r.customerInfo.entrySet()) {
	        System.out.println("이름: " + entry.getKey() + ", 나이: " + entry.getValue());
	    }

	    System.out.println("출발지: " + r.startLoc);
	    System.out.println("도착지: " + r.endLoc);
	    System.out.println("예약한 버스 시간: " + r.time);
	    System.out.println("=================================");
	}

	




	private void busTable(ArrayList<bus_serial> busTables) {
	    for (int i = 0; i < busTables.size(); i++) {
	        bus_serial bus = busTables.get(i);
	        System.out.println(String.format(
	            "번호: %d, 시간: %s, 버스번호: %s, 출발지: %s, 도착지: %s, 버스타입: %s", 
	            i + 1, bus.getBus_time(), bus.getBus_serial_num(), bus.getStart_loc(), bus.getEnd_loc(), bus.getBus_type()));
	    }
	}
	public static void userInputNum(int userInput) throws reserveException {
		if (userInput > 10) {
			throw new reserveException("인원이 10명이 넘게 예약할 수 없습니다.");
		} 

			System.out.println(userInput);
	}
}