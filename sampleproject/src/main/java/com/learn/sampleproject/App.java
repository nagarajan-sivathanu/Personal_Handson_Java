package com.learn.sampleproject;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App 
{
    public static String validateUsername(String userName) {
    	Pattern p = Pattern.compile("[a-zA-Z]{1}\\w{7,29}");
        Matcher m = p.matcher(userName);
        return m.matches()==true?"VALID":"INVALID";
    }
    
    public static void findFraction(int[] arr) {
    	MathContext m = new MathContext(6); 
    	BigDecimal pCount= BigDecimal.ZERO, 
    			   nCount = BigDecimal.ZERO, 
    			   zCount = BigDecimal.ZERO,
    			   size = BigDecimal.valueOf(arr.length);
        
        for(int i = 0;i<arr.length; i++) {
                  if(arr[i]>0)
                	  pCount = pCount.add(BigDecimal.ONE);
                  else if (arr[i]<0)
                	  nCount = nCount.add(BigDecimal.ONE);
                  else
                	  zCount = zCount.add(BigDecimal.ONE);
        };
       if(arr.length!=0) {
        System.out.println( pCount.divide(size, m).setScale(6,RoundingMode.FLOOR));
        System.out.println( nCount.divide(size, m).setScale(6,RoundingMode.FLOOR));
        System.out.println( zCount.divide(size, m).setScale(6,RoundingMode.FLOOR));
       }

    }
    public static void printStairCase(int n) {
    	int i,j,count=0,iteration = n;
    	for (int k = 1;k<=iteration;k++) {
	    	for(j = n-1;j>0;j--) {
	    		System.out.print(" ");
	    		count++;
	    	}
	    	for(i = 1; i<=k;i++){
	    		System.out.print("#");
	    	}
	    	count = 0;
	    	n=n-1;
	    	System.out.print("\n");
    	}
    	
    }
    
    public static void findMinMax(int[] arr) {
    	Arrays.sort(arr);
    	BigInteger total=BigInteger.ZERO;
    	for(int i=0;i<arr.length;i++) {
    		total = total.add(BigInteger.valueOf(arr[i]));
    	}           
    	System.out.println(total.subtract(BigInteger.valueOf(arr[arr.length-1])) +" "+total.subtract(BigInteger.valueOf(arr[0])));
    }
    
    public static void findCandleNumbers(int[] a) {
    	
    	Integer maxValue = Arrays.stream(a).boxed().max(Comparator.naturalOrder()).get();
    	System.out.println("Max Value : "+maxValue);
    	int cnt = (int) Arrays.stream(a).boxed().filter(s->s.equals(maxValue)).count();						
    	System.out.println("No of Occurences : "+cnt);
    }
    
    public static String convertDateFormat(String dt) {
    	String output = null;
    	DateTimeFormatter inpFormatter = DateTimeFormatter.ofPattern("hh:mm:ssa");
    	DateTimeFormatter opFormatter  = DateTimeFormatter.ofPattern("HH:mm:ss");
    	LocalTime localTime = LocalTime.parse(dt,inpFormatter);
    	output = localTime.format(opFormatter).toString();
    	System.out.println(output);
    	return output;
    }
    
	public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println(App.validateUsername("usertest"));
        int a[] = {-4,3,-9,0,4,1};
        App.findFraction(a);
        App.printStairCase(4);
        int b[] = {793810624,895642170,685903712,623789054,468592370};
        //int b[] = {5,2,3,4,1};
        App.findMinMax(b);
        int c[] = {3,1,2,3};
        App.findCandleNumbers(c);
        //App.convertDateFormat("07:05:45PM");
        App.convertDateFormat("12:00:00AM");
    }
}
