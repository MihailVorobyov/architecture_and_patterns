package ru.vorobev.lesson_04.patterns.behavioral.iterator;

public class Main {
	
	public static void main(String[] args) {
		StationList stationList = new StationList();
		
		stationList.addStation(new RadioStation(89));
		stationList.addStation(new RadioStation(101));
		stationList.addStation(new RadioStation(102));
		stationList.addStation(new RadioStation(100.5F));
		stationList.addStation(new RadioStation(101.7F));
		
		while (stationList.hasNext()) {
			System.out.println(stationList.next());
		}
		
		stationList.removeStation(new RadioStation(89)); // Will remove station 89
		System.out.println(stationList);
		
		stationList.removeStation(new RadioStation(101)); // Will remove station 101
		System.out.println(stationList);
		
		stationList.addStation(new RadioStation(109));
		System.out.println(stationList);
		
		stationList.addStation(new RadioStation(109));
		
		
	}
}
