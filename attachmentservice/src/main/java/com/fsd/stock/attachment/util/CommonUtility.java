package com.fsd.stock.attachment.util;

import java.util.Arrays;


public class CommonUtility {

	/**
	 * 
	 * @param array
	 * @param targetValue
	 * @return
	 */
	public static int getIndexInArray(String[] array, String targetValue) {
		return Arrays.asList(array).indexOf(targetValue);
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
    public static String firstLetterUpper(String name) {
        char[] cs=name.toCharArray();
        cs[0]-=32;
        return String.valueOf(cs);       
    }
  
}
