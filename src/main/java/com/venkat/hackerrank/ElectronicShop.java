package com.venkat.hackerrank;


/**
 * A person wants to determinne the most expensive computer keyboard and USB drive that can be purchased with a give budget. Given price lists for keyboards and USB drives and a budget, find the cost to buy them. If it is not possible to buy both items, return -1.
 *
 * Example
 * b = 60
 * keyboards = [40,50,60]
 * drives = [5,8,12]
 *
 *
 * The person can buy a 40 keyboard + 12 USB drive = 52, or a 50 keyboard + 8 USB drive = 58.
 * Choose the latter as the more expensive option and return 58.
 *
 * Function Description
 *
 * Complete the getMoneySpent function in the editor below.
 *
 * getMoneySpent has the following parameter(s):
 *
 * int keyboards[n]: the keyboard prices
 * int drives[m]: the drive prices
 * int b: the budget
 *
 * Returns
 * int: the maximum that can be spent, or -1 if it is not possible to buy both items
 *
 * Input Format
 * The first line contains three space-separated integers b, n, and m, the budget,
 * the number of keyboard models and the number of USB drive models.
 * The second line contains n space-separated integers keyboad[i], the prices of each keyboard model.
 * The third line contains m space-separated integers drives, the prices of the USB drives.
 *
 * Constraints
 * 1 <= n, m <= 1000
 * 1 <= b <= 10^6
 * The price of each item is in the inclusive range .
 */
public class ElectronicShop {

    /**
     *  To find the most expensive keyboard and USB drive combination within
     *      the given budget, we can iterate through all possible pairs of
     *      keyboards and USB drives and keep track of the maximum affordable combination.
     *
     *      We initialize maxCost as -1, which represents that it is not possible to buy both items within the budget.
     *
     *      We use nested loops to iterate through each pair of keyboard and drive.
     *      For each combination, we calculate the cost and check if it is affordable
     *      (i.e., less than or equal to the budget) and greater than the current maxCost.
     *      If both conditions are met, we update maxCost with the new maximum affordable cost.
     *
     *      After iterating through all possible combinations, if maxCost remains -1,
     *      it means it is not possible to buy both items within the budget, so we return -1.
     *      Otherwise, we return the maximum affordable cost.
     *
     *      In the main method, we call getMoneySpent with the given inputs and print the maximum affordable cost.
     *
     *      Note: This solution assumes that the input arrays keyboards and drives will
     *      always contain integers within the given constraints. Make sure to handle potential exceptions and edge cases in a production-level implementation.
     * @param keyboards
     * @param drives
     * @param b
     * @return
     */
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int maxCost = -1;

        for (int keyboard : keyboards) {
            for (int drive : drives) {
                int cost = keyboard + drive;
                if (cost <= b && cost > maxCost) {
                    maxCost = cost;
                }
            }
        }

        return maxCost;
    }

    public static void main(String[] args) {
        int b = 60;
        int[] keyboards = {40, 50, 60};
        int[] drives = {5, 8, 12};

        int maxCost = getMoneySpent(keyboards, drives, b);
        System.out.println("Maximum Affordable Cost: " + maxCost);
    }
}
