package ru.vorobev.lesson_04.patterns.behavioral.strategy;

class Sorter {
	private SortStrategy strategy;
	
	public Sorter(SortStrategy strategy) {
		this.strategy = strategy;
	}
	
	public int[] sort(int[] dataset) {
		return strategy.sort(dataset);
	}
}
