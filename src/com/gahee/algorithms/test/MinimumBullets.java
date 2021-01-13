package com.gahee.algorithms.test;
import java.io.*;
import java.util.*; 

class MinimumBullets {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		int total = Integer.parseInt(input); 
		String [] arr = br.readLine().split(" "); 
		
		int [] bal = new int [arr.length]; 
		int idx = 0; 
		for(String s : arr){
			bal[idx++] = Integer.parseInt(s); 
		}
		
		int answer = 0; 
		HashSet<Integer> set = new HashSet<>(); 
		
		for(int i = 0; i < bal.length; i++){
				if(i == 0){
					answer += 1; 
					set.add(bal[i] - 1); 
				}else{
					if(set.contains(bal[i])){
						set.remove(bal[i]);
						set.add(bal[i] - 1); 
					}else{
						answer += 1;
						set.add(bal[i] - 1); 
					}
				}
		}
		
		System.out.println(answer); 
	}
}