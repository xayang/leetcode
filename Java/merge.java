package com.test;

import java.util.ArrayList;
import java.util.List;


public class Merge {

	public static void main(String[] args) {
		List<Integer[]> arrays = new ArrayList<Integer[]>();
		arrays.add(new Integer[]{10, 15, 17, 2000});
		arrays.add(new Integer[]{-5, 7, 11, 19, 22});
		arrays.add(new Integer[]{1, 8, 10, 12, 120});
		
		Integer[] p = mergeArrays(arrays);
		for (int i = 0; i < p.length; i++) {
			System.out.print(p[i] + ", ");
		}
	}
	
	
	public static Integer[] mergeArrays(List<Integer[]> arrays){
		if(arrays == null || arrays.size() == 0)
			return null;
		Integer[] p, q;
		if(arrays.size() >= 2){
			p = arrays.get(0);
			for (int i = 1; i < arrays.size(); i++) {
				p = merge(p, arrays.get(i));
			}
		} else {
			return arrays.get(0);
		}
		return p;
	}
	
	public static Integer[] merge(Integer[] a, Integer[] b){
		Integer[] c = new Integer[a.length+b.length];
		int i=0, j=0, k=0;
		
		while(i < a.length && j < b.length){
			if(a[i] <= b[j])
				c[k++] = a[i++];
			else
				c[k++] = b[j++];
		}
		
		while(i < a.length)
			c[k++] = a[i++];
		
		while(j < b.length)
			c[k++] = b[j++];
		
		
		return c;
	}
	
}
