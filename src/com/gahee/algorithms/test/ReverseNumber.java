package com.gahee.algorithms.test;
import java.io.*;
class ReverseNumber {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		boolean isNegative = false; 
		if(input.startsWith("-")){
			isNegative = true; 
			input = input.substring(1, input.length());
		}
		StringBuilder sb = new StringBuilder(input); 
		String reversed = sb.reverse().toString(); 
		if(isNegative){
			reversed = "-" + reversed; 
		}
		int answer = Integer.parseInt(reversed); 
		System.out.println(answer); 
	}
}