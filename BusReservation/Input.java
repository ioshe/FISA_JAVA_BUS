package BusReservation;

import java.util.ArrayList;
import java.util.Scanner;



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
				if(cusnum<1) {
					System.out.println("올바른 인원이 아니라 종료합니다");
					break;
				}
//				for (int i=0; i< cusnum; i++) {
//					
//				}
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
				ArrayList<Bus> busTimes = Bus.findLocation(start, end);
				busTable(busTimes);
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
	private void busTable(ArrayList<Bus> busTimes) {
		for (Bus bus : busTimes) {
			System.out.println(String.format(
					"버스타입 : %s,\t 시간 : %s,\t 버스이름 : %s,\t 출발지 : (%s),\t 도착지 (%s)", 
					bus.busType,bus.time,bus.busName,bus.startLoc,bus.endLoc));
			
		}
		
		Scanner fc = new Scanner(System.in);
		String time = fc.next();
		R.time=time;
	}
}

