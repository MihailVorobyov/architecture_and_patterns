package ru.vorobev.lesson_04.patterns.behavioral.iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class StationList implements Iterator<RadioStation> {
	
	private final RadioStation[] stations;
	private int counter;
	private final int NUM_OF_STATIONS = 5;
	
	public StationList() {
		this.counter = 0;
		this.stations = new RadioStation[NUM_OF_STATIONS];
	}
	
	public void addStation(RadioStation station) {
		float stationFrequency = station.getFrequency();
		
		for (RadioStation s : stations) {
			if (s != null && s.getFrequency() == stationFrequency) {
				System.out.println("Station " + stationFrequency + " already exists!");
				return;
			}
		}
		if (counter < stations.length) {
			stations[counter] = station;
			System.out.println(stationFrequency + " added!");
			if (counter != stations.length - 1) {
				counter++;
			}
		} else {
			System.out.println("List of stations fulled!");
		}
	}
	
	public boolean removeStation(RadioStation toRemove) {
		float toRemoveFrequency = toRemove.getFrequency();
		
		for (int i = 0; i < stations.length; i++) {
			if (stations[i] != null && stations[i].getFrequency() == toRemoveFrequency) {
				counter = i;
				remove();
				System.out.println("Station " + toRemoveFrequency + " removed!");
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean hasNext() {
		if (counter < stations.length - 1 && stations[counter + 1] != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public RadioStation next() {
		if (hasNext()) {
			return stations[++counter];
		} else {
			throw new NoSuchElementException("There is no next elements.");
		}
	}
	
	@Override
	public void remove() {
		while (hasNext()) {
			stations[counter] = next();
		}
		stations[counter] = null;
	}

	@Override
	public String toString() {
		return "StationList{" +
			"stations=" + Arrays.toString(stations) +
			'}';
	}
}
