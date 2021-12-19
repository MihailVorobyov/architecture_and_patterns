package ru.vorobev.lesson_04.patterns.behavioral.strategy;

public class Main
{
	public static void main(String[] args) {
		int[] dataset = {1, 5, 4, 3, 2, 8};
		
		Sorter sorter = new Sorter(new BubbleSortStrategy());
		sorter.sort(dataset); // Output : Sorting using bubble sort
		
		sorter = new Sorter(new QuickSortStrategy());
		sorter.sort(dataset); // Output : Sorting using quick sort
	}
}

