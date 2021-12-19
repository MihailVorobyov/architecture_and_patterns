package ru.vorobev.lesson_04.patterns.structural.adapter;

public class WildDogAdapter implements Lion {
	
	private WildDog wildDog;
	
	
	public WildDogAdapter(WildDog wildDog) {
		this.wildDog = wildDog;
	}
	
	@Override
	public void roar() {
		wildDog.bark();
	}
}
