package com.venkat.hackerrank;

public class PasswordStrength {
	public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter the password length: ");
//        int length = scanner.nextInt();
//
//        scanner.nextLine(); // Clear the input buffer
//
//        System.out.print("Enter the password string: ");
//        String password = scanner.nextLine();

		String password = "#HackerRank";
//		String password = "2bbbb";
//		String password = "Ab1";
        int additionsNeeded = findAdditionsNeeded(11, password);
        System.out.println("Minimum number of characters to add: " + additionsNeeded);
    }
	
	private static int findAdditionsNeeded(int length, String password) {
	    int additionsNeeded = 0;

//	    if (length < 6) {
//	        additionsNeeded = 6 - length;
//	    }

	    boolean hasDigit = false;
	    boolean hasLowercase = false;
	    boolean hasUppercase = false;
	    boolean hasSpecialChar = false;

	    for (int i = 0; i < password.length(); i++) {
	        char c = password.charAt(i);

	        if (Character.isDigit(c)) {
	            hasDigit = true;
	        } else if (Character.isLowerCase(c)) {
	            hasLowercase = true;
	        } else if (Character.isUpperCase(c)) {
	            hasUppercase = true;
	        } else if (isSpecialChar(c)) {
	            hasSpecialChar = true;
	        }
	    }

	    if (!hasDigit) {
	        additionsNeeded++;
	    }

	    if (!hasLowercase) {
	        additionsNeeded++;
	    }

	    if (!hasUppercase) {
	        additionsNeeded++;
	    }

	    if (!hasSpecialChar) {
	        additionsNeeded++;
	    }
	    
	    if(additionsNeeded + length < 6) {
	    	additionsNeeded+= 6 - (additionsNeeded + length);
	    	
	    }

	   return Math.max(additionsNeeded, 6 - length);
	}

//    private static int findAdditionsNeeded(int n, String password) {
//        int additionsNeeded = 0;
//
//        if (n < 6) {
//            additionsNeeded = 6 - n;
//        }
//
//        boolean hasDigit = false;
//        boolean hasLowercase = false;
//        boolean hasUppercase = false;
//        boolean hasSpecialChar = false;
//
//        for (int i = 0; i < password.length(); i++) {
//            char c = password.charAt(i);
//
//            if (Character.isDigit(c)) {
//                hasDigit = true;
//            } else if (Character.isLowerCase(c)) {
//                hasLowercase = true;
//            } else if (Character.isUpperCase(c)) {
//                hasUppercase = true;
//            } else if (isSpecialChar(c)) {
//                hasSpecialChar = true;
//            }
//        }
//
//        if (!hasDigit) {
//            additionsNeeded++;
//        }
//
//        if (!hasLowercase) {
//            additionsNeeded++;
//        }
//
//        if (!hasUppercase) {
//            additionsNeeded++;
//        }
//
//        if (!hasSpecialChar) {
//            additionsNeeded++;
//        }
//
//        return Math.max(additionsNeeded, 6 - n);
//    }

    private static boolean isSpecialChar(char c) {
        return "!@#$%^&*()-+".indexOf(c) != -1;
    }
}
