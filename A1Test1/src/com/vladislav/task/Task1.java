package com.vladislav.task;

public class Task1 {
	
//	-----------------------------------------------------------------
//	Working with long
//	-----------------------------------------------------------------
	
	public long convertToLong(String IpV4) {
		String[] octetsArray = IpV4.split("\\.");
		String result = new String();
		for(String octet : octetsArray) {
			String octetConvert = Integer.toBinaryString(Integer.parseInt(octet));
			while(octetConvert.length()<8) {
				octetConvert="0"+octetConvert.substring(0, octetConvert.length());
			}
			result+=octetConvert;
		}
//		System.out.println(result);
		return Long.parseLong(result,2);
	}
	
	public String convertToIpV4(Long number) {
		String binaryStr = Long.toBinaryString(number);
		String result = new String();
		while(binaryStr.length()<32) {
			binaryStr="0"+binaryStr.substring(0,binaryStr.length());
		}
		for(int i = 0; i < 32; i+=8) {
			result+=Long.parseLong(binaryStr.substring(i,i+8),2);
			if(i!=24) {
				result+=".";
			}
		}
		return result;
	}
	
//	-----------------------------------------------------------------
//	Working with bits and exclusively with int
//	-----------------------------------------------------------------
	
	public int convertToInt(String IpV4) {
		String[] octetsArray = IpV4.split("\\.");
	    int result = 0;
	    for (int i = octetsArray.length; i > 0; i--) {
	    	result |= Integer.parseInt(octetsArray[octetsArray.length - i]) << (8 * (i-1));
	    }
	    return result;
	}
	
	public String convertToIp(int number) {
	    String result = new String();
	    for (int i = 4; i > 0; i--) {
	        int octet = number & (255 << (i-1) * 8);
	        result += String.valueOf(octet >>> (i-1) * 8);
	        if(i!=1) result+=".";
	    }
	    return result;
	}
}
