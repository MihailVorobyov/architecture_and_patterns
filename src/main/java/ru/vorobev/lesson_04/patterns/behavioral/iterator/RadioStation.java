package ru.vorobev.lesson_04.patterns.behavioral.iterator;

public class RadioStation implements Comparable {
	
	private float frequency;
	
	public RadioStation(float frequency) {
		this.frequency = frequency;
	}
	
	public float getFrequency()	{
		return frequency;
	}
	
	@Override
	public int compareTo(Object o) {
		if (o == null) {
			return -1;
		}
		
		RadioStation station = (RadioStation) o;
		
		return Float.compare(this.getFrequency(), station.getFrequency());
	}
	
	@Override
	public String toString() {
		return "RadioStation{" +
			"frequency=" + frequency +
			'}';
	}
}
