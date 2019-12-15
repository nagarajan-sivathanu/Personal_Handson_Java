package com.learn.sampleproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App5 {
	
	public static void bonAppetit(List<Integer> bill, int k, int b) {
		int temp = bill.stream().mapToInt(Integer::intValue).sum();
		System.out.println((temp-bill.get(k))/2==b?"Bon Appetit":b-(temp-bill.get(k))/2);
    }
	public static int sockMerchant(int n, int[] ar) {
		 long count = 0;
		 Map<Integer, Long> result =Arrays.stream(ar).boxed().collect(
                Collectors.groupingBy(Function.identity()
                        , Collectors.counting()
                ));
		 Object[] output;
		 output = result.values().toArray();
		 for(int i = 0; i<output.length;i++) {
			 count =  count + ((long)output[i]/2);
			 //System.out.println(output[i]);
		 }
		return (int)count;
    }
	public static int pageCount(int n, int p) {
		int stFlips = 0,revFlips = 0;
		if(n%2 ==1 && p!=n)
			revFlips=-1;
		 	n=n+1;
		if(p>1) {
			for(int i =2;i<=n;i=i+2) {
				stFlips++;
				if(p==i || p== i+1) {
					break;
				}
			}
		}
		if(p<n) {
			for(int j=n-1;j>0;j=j-2) {
				revFlips++;
				if(p==j || p==j-1) {
					break;
				}
			}
		}
		System.out.println("Straight Flips : "+stFlips+" Reverse Flips : "+revFlips);
		return stFlips>revFlips?revFlips:stFlips;
    }
	static int getMoneySpent(int[] keyboards, int[] drives, int b) {
		int max=-1,flagged=0;    
        Arrays.sort(drives);
        Collections.reverse(Arrays.asList(keyboards));
        for(int i=0;i<keyboards.length;i++) {
            for(int j=0;j<drives.length;j++) {
            	System.out.println("i = "+i+" j = "+j+" key[i] "+keyboards[i]+" drives[j] "+drives[j]);
                if(keyboards[i]+drives[j] >= b){
                     if (keyboards[i]+drives[j] == b){
                       flagged=1;
                       break;
                     }
                }
                if((keyboards[i]+drives[j])<b && (keyboards[i]+drives[j]) > max) {
                    max = keyboards[i]+drives[j];
                }
            }
            if(flagged==1){
                break;
            }
        }
        return max;
    }
	static int getMoneySpent2(int[] keyboards, int[] drives, int b) {
		try{
            return IntStream.range(0,keyboards.length)
                   .flatMap(x -> IntStream
                                 .range(0,drives.length)
                              .map(y -> drives[y] + keyboards[x]))
                .filter(x -> x<=b)
                .map(x -> x*-1)
                .sorted()
                .map(x -> x*-1)
                .toArray()[0];
         } catch (Exception ex){
            return -1;
         }
    }
	static int hurdleRace(int k, int[] height) {
		Arrays.sort(height);
		int max = height[height.length-1];
		return max<k?0:max-k;
    }
	
	 static String angryProfessor(int k, int[] a) {
		 return Arrays.stream(a).filter(i->i<=0).count()>=k?"NO":"YES";
	 }
	 static int findDigits(int n) {
		 return (int) String.valueOf(n)
			   .chars()
			   .mapToObj(i-> (char)i)
			   .filter((ch)->{
				   if(Character.getNumericValue(ch)==0){
			 		   return false;
		 			}
				   else if(n%Character.getNumericValue(ch)==0) {
					   return true;
				   }
				return false;
			   }).count();
				 		
	 }
	public static void main(String[] args) {
		List<Integer> ls = new ArrayList<Integer>();
		ls.add(3);
		ls.add(10);
		ls.add(2);
		ls.add(9);
		bonAppetit(ls,1,12);
		
		int[] ar = {10,20,20,10,10,30,50,10,20};
		System.out.println(sockMerchant(9,ar));
		System.out.println(pageCount(37455,29835));
		
		int[] keyboard = {3,1};
		int[] usbDrives = {5,2,8};
		int budget = 10;
		System.out.println(getMoneySpent(keyboard,usbDrives,budget));
		
		int[] height = {1,6,3,5,2};
		System.out.println(hurdleRace(4,height));
		
		int[] a = {-1,-3,4,2};
		System.out.println(angryProfessor(3,a));
		
		System.out.println(findDigits(11111));
	}
}
