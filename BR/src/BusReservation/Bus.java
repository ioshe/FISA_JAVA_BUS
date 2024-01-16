package BusReservation;

import java.util.ArrayList;

public class Bus {
	static ArrayList<Bus> BusInfo = new ArrayList<>(); 
	String time;
	String startLoc;
	String endLoc;
	int[] seat = new int[20];
	int[] prices = new int[4];
	String busName;
	String busType;
	
	Bus(String busName,String startLoc,String endLoc,String time,String busType,int[] prices) {
		this.busName = busName;
	    this.startLoc = startLoc;
	    this.endLoc = endLoc;
	    this.time = time;
	    this.busType = busType;
	    
	    BusInfo.add(this);
	}
	
	static ArrayList busGetNames(){
		ArrayList<String> busNames = new ArrayList<>();
		for (Bus bus : BusInfo) {
			busNames.add(bus.busName);
		}
		return busNames;
	}
	
	static ArrayList<Bus> findLocation(String startLoc,String endLoc) {
		ArrayList<Bus> correctbus = new ArrayList<>();
		for (Bus bus : BusInfo) {
			//System.out.println(bus.busName);
			if (bus.startLoc.toLowerCase().equals(startLoc.toLowerCase()) 
					&& (bus.endLoc.toLowerCase().equals(endLoc.toLowerCase()))) {
				correctbus.add(bus);
			}
		}
		return correctbus; 
	}
}
