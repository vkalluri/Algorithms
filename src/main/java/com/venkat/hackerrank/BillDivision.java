package com.venkat.hackerrank;


import java.util.List;

/**
 * Two friends Anna and Brian, are deciding how to split the bill at a dinner.
 * Each will only pay for the items they consume. Brian gets the check and calculates
 * Anna's portion. You must determine if his calculation is correct.
 *
 * For example, assume the bill has the following prices: bills = [2,4,6] . Anna declines
 * to eat item k = bill[2] which costs 6. If Brian calculates the bill correctly, Anna will
 * pay (2+4)/2 = 3. If he includes the cost of bill[2], he will calculate (2 + 4 + 6)/2 = 6. In the second case, he should refund 3 to Anna.
 *
 * Function Description
 * Complete the bonAppetit function in the editor below. It should print Bon Appetit
 * if the bill is fairly split. Otherwise, it should print the integer amount of money that Brian owes Anna.
 *
 * bonAppetit has the following parameter(s):
 * bill: an array of integers representing the cost of each item ordered
 * k: an integer representing the zero-based index of the item Anna doesn't eat
 * b: the amount of money that Anna contributed to the bill
 * Input Format
 *
 * The first line contains two space-separated integers n and k, the number of items ordered and the 0-based index of the item that Anna did not eat.
 * The second line contains n space-separated integers bill[i] where 0 <= i <= n.
 * The third line contains an integer, b, the amount of money that Brian charged Anna for her share of the bill.
 *
 * Constraints
 * 2 <= n <= 10^5
 * 0 <= k <= n
 * 0 <= bill[i] <= 10^4
 *
 * The amount of money due Anna will always be an integer
 * Output Format
 *
 * If Brian did not overcharge Anna, print Bon Appetit on a new line; otherwise, print the difference that Brian must refund to Anna. This will always be an integer.
 */
public class BillDivision {

    /**
     * To determine whether Brian's calculation of the bill is correct or not,
     * we can calculate the total bill by summing up all the prices in the bill array, excluding the item Anna didn't eat (bill[k]).
     * Then, we can compare this total with Anna's contribution (b).
     *
     * If the total bill divided by 2 is equal to Anna's contribution, it means Brian's
     * calculation is correct and the bill is fairly split. In this case, we print "Bon Appetit".
     * Otherwise, Brian owes Anna the difference between Anna's contribution and the actual amount she should
     * have paid. We print this difference as the amount Brian owes Anna.
     *
     * @param bill
     * @param k
     * @param b
     */
    public static void bonAppetit(int[] bill, int k, int b) {
        int totalBill = 0;

        // Calculate the total bill excluding the item Anna didn't eat
        for (int i = 0; i < bill.length; i++) {
            if (i != k) {
                totalBill += bill[i];
            }
        }

        int annaShare = totalBill / 2;

        if (annaShare == b) {
            System.out.println("Bon Appetit");
        } else {
            int refundAmount = b - annaShare;
            System.out.println(refundAmount);
        }
    }

    public static void bonAppetit(List<Integer> bill, int k, int b) {
        int totalBill = 0;

        // Calculate the total bill excluding the item Anna didn't eat
        for (int i = 0; i < bill.size(); i++) {
            if (i != k) {
                totalBill += bill.get(i);
            }
        }

        int annaShare = totalBill / 2;

        if (annaShare == b) {
            System.out.println("Bon Appetit");
        } else {
            int refundAmount = b - annaShare;
            System.out.println(refundAmount);
        }
    }

    public static void main(String[] args) {
        int[] bill = {2, 4, 6};
        int k = 2;
        int b = 6;
        bonAppetit(bill, k, b);  // Output: Bon Appetit
    }
}
