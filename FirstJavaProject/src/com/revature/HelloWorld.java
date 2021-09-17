package com.revature;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class HelloWorld {

	public static void main(String[] args) {
		/**
		 * this 
		 * is a 
		 * multi-line comment
		 */
		// syso + control+space === System.out.println();
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.CHINA);
		System.out.println(nf.format(12324.134));
		int n = 5;
		 ArrayList<ArrayList<Integer>> intList = new ArrayList<>(n);
		 for(int i = 0; i < n; i++) {
			 intList.add(new ArrayList());
		 }
		 intList.get(0).add(1);
		 intList.get(0).add(2);
		 intList.get(1).add(1);
		 System.out.println(intList.get(1));
		 System.out.println(intList);
//	        for(int i = 0; i < n; i++) {
//	            int d = 5;
//	            for(int x = 0; x < d; x++) {
//	                int y = 41;
//	                intList.get(i).add(y);
//	            }
//	        }
//	        System.out.println(intList);
	    }
	}
	