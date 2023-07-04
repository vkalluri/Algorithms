package com.venkat.coderpad;

public class ReadWriteExecute {
	
	 public static int symbolicToInt(String permString) {
	        //throw new UnsupportedOperationException("Waiting to be implemented.");
	        
	        String[] permArray = permString.split("(?<=\\G.{3})");
	        StringBuffer finalValue = new StringBuffer();
	        int returnValue = 0;
	        for(int i=0; i< permArray.length; i++) {
	        	String val = permArray[i];
	        	System.out.println(val);
	        	val.replace('r', '4');
	        	
	        	val.replace('w', '2');
	        	val.replace('x', '1');
	        	val.replace('-', '0');
	        	
	        	finalValue.append(val);
	        }
	        System.out.println(finalValue);
	        return 0;
	    }

	    public static void main(String[] args) {
	        // Should write 752
	        System.out.println(ReadWriteExecute.symbolicToInt("rwxr-x-w-"));
	    }

}
