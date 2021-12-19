package ru.vorobev.lesson_04.patterns.behavioral.strategy;

class BubbleSortStrategy implements SortStrategy {
	
	public int[] sort(int[] dataset) {
		System.out.println("Sorting using bubble sort");
		
		// Do sorting
		return dataset;
	}
}
