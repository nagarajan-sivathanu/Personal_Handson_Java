package com.learn.sampleproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

public class App4 {
	static String caesarCipher(String s, int k) {
		StringBuffer result= new StringBuffer(); 	  
        for (int i=0; i<s.length(); i++) 
        { 
            if (Character.isUpperCase(s.charAt(i))) 
            { 
                char ch = (char)(((int)s.charAt(i) + 
                                  k - 65) % 26 + 65); 
                result.append(ch); 
            } 
            else if(Character.isLowerCase(s.charAt(i)))
            { 
                char ch = (char)(((int)s.charAt(i) + 
                                  k - 97) % 26 + 97); 
                result.append(ch); 
            } else {
            	result.append(s.charAt(i));
            }
        } 
        return result.toString(); 
    }
	
	static String hackerrankInString(String s) {
		char[] ref = "hackerrank".toCharArray();
		StringBuilder sb = new StringBuilder();
		
		sb.append(s);
		for(char c:ref){
			if(!(sb.length()>0 && sb.toString().indexOf(c)>-1)) {
				return "NO";
			}
			s=sb.substring(sb.toString().indexOf(c)+1);
			sb.delete(0,sb.length());
			sb.append(s);
		}
		return "YES";
    }
	static int powerSum(int X, int N) {
		Set<Integer> temp =new TreeSet<Integer>();
		List<Integer> op = new ArrayList<Integer>();
		for(int i = 1;Math.pow(i, N)<=X;i++) {
			temp.add((int) Math.pow(i, N));
		}
	
		for(int j = 1;j<=temp.size();j++) {
			Set<Set<Integer>> combinations = Sets.combinations(temp,j);
			combinations.stream().forEach((a) -> {
				op.add(a.stream().mapToInt(Integer::intValue).sum());
			});			
		}
		return (int) op.stream().filter(a -> a==X).count();
		
    }

    static int superDigit(String n, int k) {
    	n = n.chars().mapToLong(Character::getNumericValue).sum() * k
                + "";
            return (n.length() > 1) ? superDigit(n, 1) :
                                    Character.getNumericValue(n.charAt(0));
    }
    static String reduceDuplicates(String ip,int itrCnt) {
    	String regex = "([I][I])";
    	if(ip.matches(regex)) {
    		ip = ip.replaceAll(regex,"I");
    		itrCnt++;
    		reduceDuplicates(ip,itrCnt);
    	}else {
    		long revActiveCount = ip.chars().filter(ch -> ch == 'I').count();
    		if(revActiveCount%2==0) {
    			return "LOSE";
    		}else {
    			return "WIN";
    		}
    	}
		return "";
    	
    	
    }
    
    
    static String isWinning(int n, String config) {
    	String temp = null;
    	long activeCount = config.chars().filter(ch -> ch == 'I').count();
    	long inActiveCount = config.chars().filter(ch -> ch == 'X').count();
    	String regex = "([I][I])";
    	temp = config.replaceAll(regex,"C");
    	long adjActiveCount = temp.chars().filter(ch -> ch == 'C').count();
    	regex = "([C][C])";
    	config = temp.replaceAll(regex,"C");
    	adjActiveCount = config.chars().filter(ch -> ch == 'C').count();
    	//long adjQdrCount = config.chars().filter(ch -> ch == 'C').count();
    	System.out.println(temp);
    	System.out.println("Active Count : "+activeCount);
    	System.out.println("inActiveCount Count : "+inActiveCount);
    	System.out.println("adjActiveCount Count : "+adjActiveCount);
    	if (adjActiveCount%2==0 && activeCount%2 ==0 ) {
    		return "LOSE";
    	} else {
    		return "WIN";
    	}
    }

    
	public static void main(String[] args) {
		
		System.out.println(caesarCipher("middle-Outz",2));
		System.out.println(hackerrankInString("hhaacckkekraraannk"));
		System.out.println(powerSum(100,3));
		Set<Set<Integer>> combinations = Sets.combinations(ImmutableSet.of(0, 1, 2, 3, 4, 5),2);
		combinations.stream().forEach(System.out::println);
		System.out.println(superDigit("9875",4));
		
		System.out.println(reduceDuplicates("IIXXIIIIII",0));
	}

}
