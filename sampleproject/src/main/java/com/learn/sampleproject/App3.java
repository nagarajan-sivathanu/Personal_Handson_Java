package com.learn.sampleproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App3 {
	public static void getTotalX(List<Integer> a, List<Integer> b) {
		List<Integer> output = new ArrayList<Integer>();
		int flag =0;
		Collections.sort(a);
		Collections.sort(b);
		if(a.get(a.size()-1)>b.get(0)) {
			return;
		}
		for(int i = a.get(a.size()-1);i<=b.get(0);i++) {
			flag=0;
			for(int j : a) {
				if(i%j!=0) {
					break;
				}else {
					flag++;
				}
			}
			for(int k:b) {
				if(k%i!=0) {
					break;
				}else {
					flag++;
				}
			}
			if(flag==(a.size()+b.size())) {
			System.out.println("Applicable Number : "+i);
			output.add(i);
			}
		}
	}
	
    public static void divisibleSumPairs(int n, int k, int[] ar) {
    	int count = 0;
    	for (int i =0;i<n-1;i++) {
    		for (int j = i+1;j<n;j++) {
    			if((ar[i]+ar[j])%k==0) {
    				count++;
    			}
    		}
    	
    	}
    	System.out.println("Divisible Sum Pairs : "+count);
    }
    public static void superReducedString(String s) {
    	char[] ch = s.toCharArray();
    	char[] op = new char[s.length()-1];
    	StringBuffer sb = new StringBuffer();
    	int i=0,j=0;
    	while (i<ch.length) {
    		if(i==ch.length-1) {
    			op[j]= ch[i];
    			j++;
    			i++;
    		}
    		else if(ch[i]==ch[i+1]) {
    			i=i+2;
    		}else {
    			op[j]= ch[i];
    			sb.append(ch[i]);
    			j++;
    			i++;
    		}
    	}
    	//String output = String.valueOf(op);
    	String output = sb!=null?sb.toString():""; 
    	System.out.println(output);
    }

    public static int camelcase(String s) {
    	int count = 1;
    	char[] ar = s.toCharArray();
    	for (char a:ar) {
    		if(Character.isUpperCase(a)) {
    			count++;
    		}
    	}
    	System.out.println(count);
    	return count;
    }
    public static int validatePassword(int n, String password) {
    	System.out.println("Validate Password");
    	int output = 0,required =0;
    	Pattern pattern1 = Pattern.compile("\\d+");
    	Pattern pattern2 = Pattern.compile("[a-z]+");
    	Pattern pattern3 = Pattern.compile("[A-Z]+");
    	Pattern pattern4 = Pattern.compile("[!@#$%^&*()\\-\\+]+");

        if (n<6)
            output = 6-n;
        if(!pattern1.matcher(password).find()) {
            required++;
        }
        if(!pattern2.matcher(password).find())
            required++;
        if(!pattern3.matcher(password).find()) 
            required++;      
        if(!pattern4.matcher(password).find()) {
            System.out.println("Special Character Missing");
        	required++;
        }
        if((required>output)||output==0)
            return required;
        else
            return output;
    }

    public static int marsExploration(String s) {
    	System.out.println("Mars Exploration");
    	if(s.length()%3>0) {
    		return -1;
    	}
    	char[] mtch = s.substring(0,3).toCharArray();
    	int count=0;
    	for(int i=0;i<s.length();i=i+3) {
    		if(i%3==0) {
	    		for(int j=0;j<3;j++) {
	    			if(mtch[j]!= s.substring(i, i+3).toCharArray()[j])
	    				count++;
	    		}
    		}
    	}   	
    	return count;
    }
	public static void main(String[] args) {
		List<Integer> a = new ArrayList<Integer>();
		List<Integer> b = new ArrayList<Integer>();
		a.add(2);a.add(4);
		b.add(16);b.add(32);b.add(96);
		getTotalX(a,b);
		int ar[] = {1,3,2,6,1,2};
		int n = 6, k = 3;
		divisibleSumPairs(n,k,ar);
		superReducedString("aaabccddd");
		camelcase("oneTwoThree");
		System.out.println(validatePassword(11,"#HackerRank"));
		System.out.println(marsExploration("PPPQQQGGGGGGGGGGGGGGGMMMMMMMMMFFFFFFDDDERT"));
	}

}
