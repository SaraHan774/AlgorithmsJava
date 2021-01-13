package com.gahee.algorithms.test;

import java.io.*;

class MaxProfit {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		int [] arr = new int [input.length()]; 
		String [] sArr = input.split(" "); 
		int idx = 0; 
		for(String s : sArr){
			arr[idx++] = Integer.parseInt(s); 
		}
		
		int max = Integer.MIN_VALUE; 
		for(int i = 0; i < arr.length; i++){
			int cur = arr[i]; 
			for(int j = i+1; j < arr.length; j++){
				int m = arr[j] - cur;
				if(m > max){
					max = m; 
				}
			}
		}
		
		System.out.println(max); 
	}
}