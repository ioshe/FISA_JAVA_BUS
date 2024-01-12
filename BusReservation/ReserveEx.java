package BusReservation;

public class ReserveEx {

	public static void main(String[] args) {
		// 시간대별 버스 가격
		int[] intercityPricesAM = {5000, 15000, 25000, 35000}; // AM - 6:00
		int[] intercityPricesPM = {10000, 20000, 30000, 40000}; // PM - 12:00, 18:00
		int[] intercityPricesNight = {7500, 17500, 27500, 37500}; //Night - 24:00
		int[] expressPricesAM = {10000, 20000, 30000, 40000};
		int[] expressPricesPM = {15000, 25000, 35000, 45000};
		int[] expressPricesNight = {12500, 22500, 32500, 42500};
		
		// 서울-부산 버스
		Bus sb600I = new Bus("sb6001", "Seoul", "Busan", "6:00", "Intercity", intercityPricesAM);
		Bus sb600E = new Bus("sb6002", "Seoul", "Busan", "6:00", "Express", expressPricesAM);
		Bus sb1200I = new Bus("sb12001", "Seoul", "Busan", "12:00", "Intercity", intercityPricesPM);
		Bus sb1200E = new Bus("sb12002", "Seoul", "Busan", "12:00", "Express", expressPricesPM);
		Bus sb1800I = new Bus("sb18001", "Seoul", "Busan", "18:00", "Intercity", intercityPricesPM);
		Bus sb1800E = new Bus("sb18002", "Seoul", "Busan", "18:00", "Express", expressPricesPM);
		Bus sb0000I = new Bus("sb00001", "Seoul", "Busan", "00:00", "Intercity", intercityPricesNight);
		Bus sb0000E = new Bus("sb00002", "Seoul", "Busan", "00:00", "Express", expressPricesNight);
		
		// 서울-인천 버스
		Bus si600I = new Bus("si600I", "Seoul", "Incheon", "6:00", "Intercity", intercityPricesAM);
		Bus si600E = new Bus("si600E", "Seoul", "Incheon", "6:00", "Express", expressPricesAM);
		Bus si1200I = new Bus("si1200I", "Seoul", "Incheon", "12:00", "Intercity", intercityPricesPM);
		Bus si1200E = new Bus("si1200E", "Seoul", "Incheon", "12:00", "Express", expressPricesPM);
		Bus si1800I = new Bus("si1800I", "Seoul", "Incheon", "18:00", "Intercity", intercityPricesPM);
		Bus si1800E = new Bus("si1800E", "Seoul", "Incheon", "18:00", "Express", expressPricesPM);
		Bus si0000I = new Bus("si0000I", "Seoul", "Incheon", "00:00", "Intercity", intercityPricesNight);
		Bus si0000E = new Bus("si0000E", "Seoul", "Incheon", "00:00", "Express", expressPricesNight);
		
		// 서울-대구 버스
		Bus sd600I = new Bus("sd600I", "Seoul", "Daegu", "6:00", "Intercity", intercityPricesAM);
		Bus sd600E = new Bus("sd600E", "Seoul", "Daegu", "6:00", "Express", expressPricesAM);
		Bus sd1200I = new Bus("sd1200I", "Seoul", "Daegu", "12:00", "Intercity", intercityPricesPM);
		Bus sd1200E = new Bus("sd1200E", "Seoul", "Daegu", "12:00", "Express", expressPricesPM);
		Bus sd1800I = new Bus("sd1800I", "Seoul", "Daegu", "18:00", "Intercity", intercityPricesPM);
		Bus sd1800E = new Bus("sd1800E", "Seoul", "Daegu", "18:00", "Express", expressPricesPM);
		Bus sd0000I = new Bus("sd0000I", "Seoul", "Daegu", "00:00", "Intercity", intercityPricesNight);
		Bus sd0000E = new Bus("sd0000E", "Seoul", "Daegu", "00:00", "Express", expressPricesNight);
		
		// 부산-서울 버스
		Bus bs600I = new Bus("bs600I", "Busan", "Seoul", "6:00", "Intercity", intercityPricesAM);
		Bus bs600E = new Bus("bs600E", "Busan", "Seoul", "6:00", "Express", expressPricesAM);
		Bus bs1200I = new Bus("bs1200I", "Busan", "Seoul", "12:00", "Intercity", intercityPricesPM);
		Bus bs1200E = new Bus("bs1200E", "Busan", "Seoul", "12:00", "Express", expressPricesPM);
		Bus bs1800I = new Bus("bs1800I", "Busan", "Seoul", "18:00", "Intercity", intercityPricesPM);
		Bus bs1800E = new Bus("bs1800E", "Busan", "Seoul", "18:00", "Express", expressPricesPM);
		Bus bs0000I = new Bus("bs0000I", "Busan", "Seoul", "00:00", "Intercity", intercityPricesNight);
		Bus bs0000E = new Bus("bs0000E", "Busan", "Seoul", "00:00", "Express", expressPricesNight);
		
		// 부산-인천 버스
		Bus bi600I = new Bus("bi600I", "Busan", "Incheon", "6:00", "Intercity", intercityPricesAM);
		Bus bi600E = new Bus("bi600E", "Busan", "Incheon", "6:00", "Express", expressPricesAM);
		Bus bi1200I = new Bus("bi1200I", "Busan", "Incheon", "12:00", "Intercity", intercityPricesPM);
		Bus bi1200E = new Bus("bi1200E", "Busan", "Incheon", "12:00", "Express", expressPricesPM);
		Bus bi1800I = new Bus("bi1800I", "Busan", "Incheon", "18:00", "Intercity", intercityPricesPM);
		Bus bi1800E = new Bus("bi1800E", "Busan", "Incheon", "18:00", "Express", expressPricesPM);
		Bus bi0000I = new Bus("bi0000I", "Busan", "Incheon", "00:00", "Intercity", intercityPricesNight);
		Bus bi0000E = new Bus("bi0000E", "Busan", "Incheon", "00:00", "Express", expressPricesNight);
		
		// 부산-대구 버스
		Bus bd600I = new Bus("bi600I", "Busan", "Daegu", "6:00", "Intercity", intercityPricesAM);
		Bus bd600E = new Bus("bi600E", "Busan", "Daegu", "6:00", "Express", expressPricesAM);
		Bus bd1200I = new Bus("bi1200I", "Busan", "Daegu", "12:00", "Intercity", intercityPricesPM);
		Bus bd1200E = new Bus("bi1200E", "Busan", "Daegu", "12:00", "Express", expressPricesPM);
		Bus bd1800I = new Bus("bi1800I", "Busan", "Daegu", "18:00", "Intercity", intercityPricesPM);
		Bus bd1800E = new Bus("bi1800E", "Busan", "Daegu", "18:00", "Express", expressPricesPM);
		Bus bd0000I = new Bus("bi0000I", "Busan", "Daegu", "00:00", "Intercity", intercityPricesNight);
		Bus bd0000E = new Bus("bi0000E", "Busan", "Daegu", "00:00", "Express", expressPricesNight);
		
		// 인천-서울 버스
		Bus is600I = new Bus("is600I", "Incheon", "Seoul", "6:00", "Intercity", intercityPricesAM);
		Bus is600E = new Bus("is600E", "Incheon", "Seoul", "6:00", "Express", expressPricesAM);
		Bus is1200I = new Bus("is1200I", "Incheon", "Seoul", "12:00", "Intercity", intercityPricesPM);
		Bus is1200E = new Bus("is1200E", "Incheon", "Seoul", "12:00", "Express", expressPricesPM);
		Bus is1800I = new Bus("is1800I", "Incheon", "Seoul", "18:00", "Intercity", intercityPricesPM);
		Bus is1800E = new Bus("is1800E", "Incheon", "Seoul", "18:00", "Express", expressPricesPM);
		Bus is0000I = new Bus("is0000I", "Incheon", "Seoul", "00:00", "Intercity", intercityPricesNight);
		Bus is0000E = new Bus("is0000E", "Incheon", "Seoul", "00:00", "Express", expressPricesNight);
		
		// 인천-부산 버스
		Bus ib600I = new Bus("ib600I", "Incheon", "Busan", "6:00", "Intercity", intercityPricesAM);
		Bus ib600E = new Bus("ib600E", "Incheon", "Busan", "6:00", "Express", expressPricesAM);
		Bus ib1200I = new Bus("ib1200I", "Incheon", "Busan", "12:00", "Intercity", intercityPricesPM);
		Bus ib1200E = new Bus("ib1200E", "Incheon", "Busan", "12:00", "Express", expressPricesPM);
		Bus ib1800I = new Bus("ib1800I", "Incheon", "Busan", "18:00", "Intercity", intercityPricesPM);
		Bus ib1800E = new Bus("ib1800E", "Incheon", "Busan", "18:00", "Express", expressPricesPM);
		Bus ib0000I = new Bus("ib0000I", "Incheon", "Busan", "00:00", "Intercity", intercityPricesNight);
		Bus ib0000E = new Bus("ib0000E", "Incheon", "Busan", "00:00", "Express", expressPricesNight);
		
		// 인천-대구 버스
		Bus id600I = new Bus("id600I", "Incheon", "Daegu", "6:00", "Intercity", intercityPricesAM);
		Bus id600E = new Bus("id600E", "Incheon", "Daegu", "6:00", "Express", expressPricesAM);
		Bus id1200I = new Bus("id1200I", "Incheon", "Daegu", "12:00", "Intercity", intercityPricesPM);
		Bus id1200E = new Bus("id1200E", "Incheon", "Daegu", "12:00", "Express", expressPricesPM);
		Bus id1800I = new Bus("id1800I", "Incheon", "Daegu", "18:00", "Intercity", intercityPricesPM);
		Bus id1800E = new Bus("id1800E", "Incheon", "Daegu", "18:00", "Express", expressPricesPM);
		Bus id0000I = new Bus("id0000I", "Incheon", "Daegu", "00:00", "Intercity", intercityPricesNight);
		Bus id0000E = new Bus("id0000E", "Incheon", "Daegu", "00:00", "Express", expressPricesNight);
		
		// 대구-서울 버스
		Bus ds600I = new Bus("ds600I", "Daegu", "Seoul", "6:00", "Intercity", intercityPricesAM);
		Bus ds600E = new Bus("ds600E", "Daegu", "Seoul", "6:00", "Express", expressPricesAM);
		Bus ds1200I = new Bus("ds1200I", "Daegu", "Seoul", "12:00", "Intercity", intercityPricesPM);
		Bus ds1200E = new Bus("ds1200E", "Daegu", "Seoul", "12:00", "Express", expressPricesPM);
		Bus ds1800I = new Bus("ds1800I", "Daegu", "Seoul", "18:00", "Intercity", intercityPricesPM);
		Bus ds1800E = new Bus("ds1800E", "Daegu", "Seoul", "18:00", "Express", expressPricesPM);
		Bus ds0000I = new Bus("ds0000I", "Daegu", "Seoul", "00:00", "Intercity", intercityPricesNight);
		Bus ds0000E = new Bus("ds0000E", "Daegu", "Seoul", "00:00", "Express", expressPricesNight);
		
		// 대구-부산 버스
		Bus db600I = new Bus("db600I", "Daegu", "Busan", "6:00", "Intercity", intercityPricesAM);
		Bus db600E = new Bus("db600E", "Daegu", "Busan", "6:00", "Express", expressPricesAM);
		Bus db1200I = new Bus("db1200I", "Daegu", "Busan", "12:00", "Intercity", intercityPricesPM);
		Bus db1200E = new Bus("db1200E", "Daegu", "Busan", "12:00", "Express", expressPricesPM);
		Bus db1800I = new Bus("db1800I", "Daegu", "Busan", "18:00", "Intercity", intercityPricesPM);
		Bus db1800E = new Bus("db1800E", "Daegu", "Busan", "18:00", "Express", expressPricesPM);
		Bus db0000I = new Bus("db0000I", "Daegu", "Busan", "00:00", "Intercity", intercityPricesNight);
		Bus db0000E = new Bus("db0000E", "Daegu", "Busan", "00:00", "Express", expressPricesNight);
		
		// 대구-인천 버스
		Bus di600I = new Bus("di600I", "Daegu", "Incheon", "6:00", "Intercity", intercityPricesAM);
		Bus di600E = new Bus("di600E", "Daegu", "Incheon", "6:00", "Express", expressPricesAM);
		Bus di1200I = new Bus("di1200I", "Daegu", "Incheon", "12:00", "Intercity", intercityPricesPM);
		Bus di1200E = new Bus("di1200E", "Daegu", "Incheon", "12:00", "Express", expressPricesPM);
		Bus di1800I = new Bus("di1800I", "Daegu", "Incheon", "18:00", "Intercity", intercityPricesPM);
		Bus di1800E = new Bus("di1800E", "Daegu", "Incheon", "18:00", "Express", expressPricesPM);
		Bus di0000I = new Bus("di0000I", "Daegu", "Incheon", "00:00", "Intercity", intercityPricesNight);
		Bus di0000E = new Bus("di0000E", "Daegu", "Incheon", "00:00", "Express", expressPricesNight);
		
		//System.out.println(Bus.busGetNames());
		
		
		
		Input cus1= new Input();
		cus1.create();
	}

}
