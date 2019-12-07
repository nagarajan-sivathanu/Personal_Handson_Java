package com.learn.sampleproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App2 {
	public static List<Integer> gradingStudents(List<Integer> grades) {
		List<Integer> op = new ArrayList<Integer>();
		grades
			.stream()
			.map(a->{
					if((5-(a%5)<3) && a>=38) {
					    op.add(a+5-(a%5));
						return true;
					}else {
						op.add(a);
						return true;
					}
				})
			.collect(Collectors.toList());
		return op;
	 }
	public static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
		System.out.println(Arrays.stream(apples).map(e->e+a).filter(e-> e>=s && e<=t).count());
		System.out.println(Arrays.stream(oranges).map(f->f+b).filter(f-> f>=s && f<=t).count());

    }
	
	public static String kangaroo(int x1, int v1, int x2, int v2) {
		int k1 = x1+v1, k2 = x2+v2; 
		
		if((x1>x2 && v1>v2)||(x2>x1 && v2>v1)) {
			System.out.println("x1 = "+x1+" v1 = "+v1+" = x2 "+x2 +" v2 "+v2);
			 return "NO";
		 }
		if(k1==k2) {
			return "YES";
		}
		else if(k1<k2) {
		System.out.println("Inside k1<k2");
		 while (true) {
			 System.out.println("K1 == "+k1+"  K2 == "+k2);
			 if(k1==k2) {
				 System.out.println("k1==k2");
				 return "YES";
			 }else if (k1>k2) {	 
				 System.out.println("k1>k2");
				 return "NO";
			 }
			 k1=k1+v1;
			 k2=k2+v2;
		 }
		}else if (k1>k2){
			System.out.println("Inside k1>k2");	
			 while (true) {
				 System.out.println("K1 == "+k1+"  K2 == "+k2);
				 if(k1==k2) {
					 System.out.println("k1==k2");
					 return "YES";
				 }else if (k2>k1) {	 
					 System.out.println("k2>k1");
				 	 return "NO";
				 }
				 k1=k1+v1;
				 k2=k2+v2;
			 }
		}
		return "NO";
    }
	public static void breakingRecords(int[] scores) {
		int minm =0,maxm = 0,minCount = 0, maxCount = 0;

		
		if (scores.length>0) {
			minm = scores[0];
			maxm = scores[0];
		}
		for (int a:scores){
			if(a>maxm) {
	    		  maxm = a;
	    		  maxCount++;
	    	  }else if (a<minm) {
	    		  minm = a;
	    		  minCount++;
	    	  }
		}
		System.out.println("Min : "+minCount+" Max : "+maxCount);
		/*Arrays.stream(scores)
		      .map((a)->{
		    	  if(a>maxm) {
		    		  maxm = a;
		    		  maxCount++;
		    	  }else if (a<minm) {
		    		  minm = a;
		    		  minCount++;
		    	  }
		      });
		 */
    }
	public static void main(String[] args) {
		System.out.println( "Hello World!" );
		List<Integer> ls = new ArrayList<Integer>();
		List<Integer> op = new ArrayList<Integer>();
		ls.add(73);
		ls.add(67);
		ls.add(38);
		ls.add(33);
		op=gradingStudents(ls);
		op.forEach(System.out::println);
		int s=7, t = 10, a=4, b=12;
		int apples[] = {2,3,-4};
		int oranges[] = {3,-2,-4};
		
		countApplesAndOranges(s,t,a,b,apples,oranges);
		
		System.out.println(kangaroo(0,3,4,2));
		//System.out.println(kangaroo(0,2,5,3));
		//System.out.println(kangaroo(2564,5393,5121,2836));
		int gameScores[] = {10,5,20,20,4,5,2,25,1};
		breakingRecords(gameScores);
	}

}
