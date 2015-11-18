package com.algo.study;

public class Algorithms {
	
	public static void linearSearch(int value, int[] array){
		boolean found = false;
		String foundIndexes = "";
		for(int i = 0 ; i < array.length; i++) {
			if(value == array[i]){
				found = true;
				foundIndexes += i + " ";
			}
		}
		if(found){
			System.out.println("Found at index: " + foundIndexes);
		} else {
			System.out.println(value + " not found.");
		}
	}
	
	//Sorting
	//O(n2)
	public static int[] bubbleSort(int[] inputArray){
		double start = System.currentTimeMillis();
		if(inputArray == null || inputArray.length <= 0) return inputArray;
		int size = inputArray.length;
		for(int j = size - 1 ; j > 1 ; j--){
			for(int i = 0; i < j ; i++){
				if(inputArray[i] > inputArray[i+1]){
					int aux = inputArray[i];
					inputArray[i] = inputArray[i+1];
					inputArray[i+1] = aux;
				}
			}
		}
		double end = System.currentTimeMillis();
		System.out.println("BubbleSort took: " + (end - start));
		return inputArray;
	}
	
	
	//Searching
	public static int binarySearchForValue(int value, int[] input, int lowIndex, int highIndex){
		if(lowIndex > highIndex){
			return -1;
		}
		
		int middle = (lowIndex + highIndex)/2;
		if(input[middle] == value){
			return middle;
		} else if(input[middle] > value){
			return binarySearchForValue(value, input, lowIndex, middle - 1);
		} else {
			return binarySearchForValue(value, input, middle + 1 , highIndex);
		}
	}
	
	
	public static void printArray(int[] input){
		int cont = 0;
		for(int i = 0 ; i < input.length ; i++){
			System.out.print(input[i] + "|");
			cont++;
			if(cont == 20){
				cont = 0;
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
		RandomIntArray a = new RandomIntArray(100000, 1000);
		
		linearSearch(121, a.mArray);
		
		printArray(bubbleSort(a.mArray));
		
		int res = binarySearchForValue(121, bubbleSort(a.mArray)
				, 0, a.mArray.length - 1);
		System.out.println(res == -1 ? "Value not found":"Value found at index " + res);
	}

}
