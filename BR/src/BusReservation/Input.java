package BusReservation;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import model.domain.*;
import DBUtil.Util;
import controller.DataController;


public class Input extends Reservation{
	Reservation R=new Reservation();
	public void create() {
		while(true) {
			System.out.println("버스를 예약 하시겠습니까 1.예 2.아니오");
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
				System.out.println(R.customerNum+"명 예약하셨습니다.***");
				System.out.println("승객 이름을입력해주세요");
				Scanner bc = new Scanner(System.in);
				String cusname = bc.next();
				System.out.println("승객 나이를입력해주세요");
				Scanner cc = new Scanner(System.in);
				String age = cc.next();
				int age1 = Integer.parseInt(age);
				R.customerInfo.put(cusname,age1);
		
				System.out.println("승차지를 선택해주세요 Seoul Busan Incheon Daegu");
				Scanner dc = new Scanner(System.in);
				String start = dc.next();
				R.startLoc=start;

				System.out.println("하차지 선택해주세요 Seoul Busan Incheon Daegu");
				Scanner ec = new Scanner(System.in);
				String end = dc.next();
				R.endLoc=end;
				
				ArrayList<bus_serial> busTables = null;
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
				R.time=busTables.get(time-1).getBus_time();
				showReservation(R); //=========== 예약 정보 =========== 출력
				
			}
			else if(a.equals("2")) {
				System.out.println("시스템종료");
				break;
			} 
			else {
				System.out.println("제대로 입력");
			}
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

	


	private void busTimes(ArrayList<bus_serial> busTables) {
		
		// 현재 busTables의 개수보다 작거나 큰 값을 입력하면 팅기게 해줘야하는데
		
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

