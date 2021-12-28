package ru.vorobev.lesson_04.patterns.behavioral.strategy;

class QuickSortStrategy implements SortStrategy {
	
	public int[] sort(int[] dataset) {
		System.out.println("Sorting using quick sort");
		
		// Do sorting
		return dataset;
	}
}
