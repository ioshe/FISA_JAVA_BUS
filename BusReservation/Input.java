package BusReservation;

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
				
				System.out.println("시간을 선택해주세요 00:00 06:00 12:00 18:00");
				Scanner fc = new Scanner(System.in);
				String time = fc.next();
				R.time=time;
				
				
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
}

