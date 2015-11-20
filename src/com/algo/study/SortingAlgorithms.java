package com.algo.study;

public class SortingAlgorithms {
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
}
