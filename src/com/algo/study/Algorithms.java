package com.algo.study;

public class Algorithms {

	public static void linearSearch(int value, int[] array) {
		boolean found = false;
		String foundIndexes = "";
		for (int i = 0; i < array.length; i++) {
			if (value == array[i]) {
				found = true;
				foundIndexes += i + " ";
			}
		}
		if (found) {
			System.out.println("Found at index: " + foundIndexes);
		} else {
			System.out.println(value + " not found.");
		}
	}

	// Searching
	public static int binarySearchForValue(int value, int[] input, int lowIndex, int highIndex) {
		if (lowIndex > highIndex) {
			return -1;
		}

		int middle = (lowIndex + highIndex) / 2;
		if (input[middle] == value) {
			return middle;
		} else if (input[middle] > value) {
			return binarySearchForValue(value, input, lowIndex, middle - 1);
		} else {
			return binarySearchForValue(value, input, middle + 1, highIndex);
		}
	}
	
	//Complexity O(n log n) //Space O(1)
	public static boolean searchMatrix(int value, int[][] matrix) { 
		int possibleElemRow = 0;
		for (int i = 0; i < matrix.length; i++) { // O(n)
			if (value <= matrix[i][matrix[0].length - 1]) {
				possibleElemRow = i;
				if (value == matrix[i][matrix[0].length - 1]) {
					System.out.println(
							"Value " + value + " found at row " + i + " col " + (matrix[0].length -1));
					return true;
				} else {
					break;
				}
			} 
		}

		if (possibleElemRow >= 0) { // O(log n)
			int index = binarySearchForValue(value, matrix[possibleElemRow], 0, matrix[0].length - 1);
			if (index >= 0) {
				System.out.println("Value " + value + " found at row " + possibleElemRow + " col " + index);
				return true;
			}
		}

		System.out.println("Value not found");
		return false;
	}

	public static void printArray(int[] input) {
		int cont = 0;
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + "|");
			cont++;
			if (cont == 20) {
				cont = 0;
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		RandomIntArray a = new RandomIntArray(1000, 1000);

		linearSearch(121, a.mArray);

		printArray(SortingAlgorithms.bubbleSort(a.mArray));

		int res = binarySearchForValue(121, SortingAlgorithms.bubbleSort(a.mArray), 0, a.mArray.length - 1);
		System.out.println(res == -1 ? "Value not found" : "Value found at index " + res);

		SortedNByMMatrix matrix = new SortedNByMMatrix(10, 10, 100);
		matrix.printMatrix();
		searchMatrix(20, matrix.mMatrix);
	}

}
