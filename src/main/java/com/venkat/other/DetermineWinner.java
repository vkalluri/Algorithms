package com.venkat.other;

public class DetermineWinner {
	public static void main(String[] args) {

		/*
		 * Scanner in = new Scanner(System.in); int t=in.nextInt(); for(int
		 * i=0;i<t;i++){ int a = in.nextInt(); int b = in.nextInt(); int n =
		 * in.nextInt(); int sum = a; for (int j = 0; j<n; j++) { int nextEle =
		 * (int)Math.pow(2, j)*b; sum = sum + nextEle; System.out.printf("%s ",sum); }
		 * if (i < t-1) { System.out.print("\n"); }
		 * 
		 * } in.close();
		 */
	        
//	        int end = 15;
//
//	        IntStream.rangeClosed(1, end)
//	                .mapToObj(
//	                        i -> i % 3 == 0 ? 
//	                                (i % 5 == 0 ? "FizzBuzz" : "Fizz") : 
//	                                (i % 5 == 0 ? "Buzz" : i))
//	                .forEach(System.out::println);
//		 Scanner scan = new Scanner(System.in);
//		
//		Integer[] i = new Integer[100];
//		int j = 0;
//		while(scan.hasNext()) {
//			i[j] = scan.nextInt();
//		}
//		
//		System.out.println(sum(i));
//		scan.close();
		
		int[] a = {10,14,52,-2,10,-22,-40,-3,11};
		int[] b = {-2,1,2,-4,13,23};
		int[] c = {-2,-10,-4};
		System.out.println(run(c));
    }
	
	 public static Integer sum(Integer[] ins){
	        Integer result = 0;
	        
	        for(Integer in: ins){
	            result+= in;
	        }
	        return result;
	    }
	 
	 public static int run(int[] a) {
		 int maximum_sum = 0;
		 int sum = 0;
		 for(int i : a) {
			 sum+= i;
			 if(sum>maximum_sum || maximum_sum==0) {
				 maximum_sum = sum;
			 }
			 
			 if(sum < 0) {
				 sum = 0;
			 }
		 }
		 
		 return maximum_sum;
	 }
}
