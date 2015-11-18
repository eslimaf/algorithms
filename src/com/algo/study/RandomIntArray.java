package com.algo.study;

import java.util.Random;

public class RandomIntArray {
	public int[] mArray;
	
	public RandomIntArray(int size, int maxInt){
		if(size <= 0 || maxInt <= 0) throw new IllegalArgumentException();
		Random rand = new Random();
		mArray = new int[size];
		for(int i = 0 ; i < size ; i++){
			mArray[i] = rand.nextInt(maxInt);
		}
	}
}
