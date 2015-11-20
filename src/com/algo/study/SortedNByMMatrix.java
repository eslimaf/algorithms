package com.algo.study;

public class SortedNByMMatrix {
	
	int[][] mMatrix;
	int mRow;
	int mCol;
	
	public SortedNByMMatrix(int row, int col, int maxInt){
		int[] sortedArray = SortingAlgorithms.bubbleSort(
				new RandomIntArray(row*col,maxInt).mArray);
		mMatrix = new int[row][col];
		int counter = 0;
		for(int i = 0; i < row ; i++){
			for(int j = 0 ; j < col ; j++){
				mMatrix[i][j] = sortedArray[counter];
				counter++;
			}
		}
	}
	
	public void printMatrix(){
		System.out.println("-- Sorted Matrix --");
		for (int i = 0; i < mMatrix.length; i++) {
			for (int j = 0; j < mMatrix[0].length; j++) {
				System.out.print("|" + mMatrix[i][j] + "|");
			}
			System.out.println();
		}
	}

}
