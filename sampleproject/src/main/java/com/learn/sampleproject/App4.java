package com.learn.sampleproject;

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
	
	public static void main(String[] args) {
		System.out.println(caesarCipher("middle-Outz",2));
		System.out.println(hackerrankInString("hhaacckkekraraannk"));
		
	}

}
