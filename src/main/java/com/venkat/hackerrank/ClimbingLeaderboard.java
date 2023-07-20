package com.venkat.hackerrank;


import java.util.ArrayList;
import java.util.List;

/**
 * An arcade game player wants to climb to the top of the leaderboard and track their ranking.
 * The game uses Dense Ranking, so its leaderboard works like this:
 *
 * The player with the highest score is ranked number 1 on the leaderboard.
 * Players who have equal scores receive the same ranking number, and the next player(s) receive the immediately following ranking number.
 *
 * Example
 * ranked = [100,90,90,80]
 * player = [70,80,105]
 *
 * The ranked players will have ranks 1, 2, 2, and 3, respectively. If the player's scores
 * are 70, 80 and 105, their rankings after each game are 4th, 3rd and 1st. Return [4,3,1].
 *
 * Function Description
 * Complete the climbingLeaderboard function in the editor below.
 * climbingLeaderboard has the following parameter(s):
 * int ranked[n]: the leaderboard scores
 * int player[m]: the player's scores
 *
 * Returns
 * int[m]: the player's rank after each new score
 *
 * Input Format
 * The first line contains an integer n, the number of players on the leaderboard.
 * The next line contains n space-separated integers ranked[i], the leaderboard scores in decreasing order.
 * The next line contains an integer, m, the number games the player plays.
 * The last line contains m space-separated integers players[j], the game scores.
 *
 * Constraints
 * 1 <= n <= 2 * 10^5
 * 1 <= m <= 2 * 10^5
 * 0 <= ranked[i] <= 10^9 for 0 <= i <= n
 * 0 <= player[j] <= 10^9 for 0 <= i <= m
 * The existing leaderboard, ranked, is in descending order.
 * The player's scores, player, are in ascending order.
 *
 * Subtask
 * For 60% of the maximum score:
 * 1 <= n <= 200
 * 1 <= m <= 200
 */
public class ClimbingLeaderboard {

    /**
     * To calculate the player's rank after each new score in the given leaderboard,
     * we can use a two-pointer approach.
     *
     * First, we'll iterate through the leaderboard scores and create a new array uniqueRanked
     * that contains only the unique scores in descending order. This will allow us to ignore duplicate scores while calculating the ranks.
     *
     * Next, we'll iterate through the player's scores and compare them with the scores in uniqueRanked using two pointers:
     *
     * The rankedIndex pointer starts at the beginning of uniqueRanked (highest score) and moves forward.
     * The playerIndex pointer starts at the beginning of the player's scores and moves forward.
     * For each player's score, we'll compare it with the score at rankedIndex:
     *
     * If the player's score is greater than or equal to the score at rankedIndex, it means the player
     * has a higher or equal rank. We'll add the current rank to the result array and move the playerIndex forward.
     * If the player's score is less than the score at rankedIndex, it means the player's score is between
     * two ranks. We'll increase the rank by 1 and move the rankedIndex forward.
     * Finally, if the rankedIndex reaches the end of uniqueRanked, it means all remaining player's scores are
     * lower than the lowest score in the leaderboard. We'll assign the same rank to the remaining player's scores.
     *
     * @param ranked
     * @param player
     * @return
     */
//    public static int[] climbingLeaderboard(int[] ranked, int[] player) {
//        List<Integer> uniqueRanked = new ArrayList<>();
//        int n = ranked.length;
//        int m = player.length;
//        int[] result = new int[m];
//
//        // Create a list of unique scores in descending order
//        uniqueRanked.add(ranked[0]);
//        for (int i = 1; i < n; i++) {
//            if (ranked[i] != ranked[i - 1]) {
//                uniqueRanked.add(ranked[i]);
//            }
//        }
//
//        int rankedIndex = 0;
//        int playerIndex = 0;
//
//        while (playerIndex < m && rankedIndex < uniqueRanked.size()) {
//            if (player[playerIndex] >= uniqueRanked.get(rankedIndex)) {
//                result[playerIndex] = rankedIndex + 1;
//                playerIndex++;
//            } else {
//                rankedIndex++;
//            }
//        }
//
//        // Assign the same rank to the remaining player's scores
//        while (playerIndex < m) {
//            result[playerIndex] = rankedIndex + 1;
//            playerIndex++;
//        }
//
//        return result;
//    }

    public static int[] climbingLeaderboard(int[] ranked, int[] player) {
        int n = ranked.length;
        int m = player.length;
        int[] result = new int[m];

        // Create a list of unique scores in descending order
        List<Integer> uniqueRanked = new ArrayList<>();
        uniqueRanked.add(ranked[0]);
        for (int i = 1; i < n; i++) {
            if (ranked[i] != ranked[i - 1]) {
                uniqueRanked.add(ranked[i]);
            }
        }

        int rankedIndex = uniqueRanked.size() - 1;
        int playerIndex = 0;

        while (playerIndex < m) {
            if (rankedIndex < 0 || player[playerIndex] >= uniqueRanked.get(rankedIndex)) {
                result[playerIndex] = rankedIndex + 2;
                playerIndex++;
            } else {
                rankedIndex--;
            }
        }

        return result;
    }

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> uniqueRanked = new ArrayList<>();
        int n = ranked.size();
        int m = player.size();
        List<Integer> result = new ArrayList<>();

        // Create a list of unique scores in descending order
        uniqueRanked.add(ranked.get(0));
        for (int i = 1; i < n; i++) {
            if (ranked.get(i) != ranked.get(i - 1)) {
                uniqueRanked.add(ranked.get(i));
            }
        }

        int rankedIndex = 0;
        int playerIndex = 0;

        while (playerIndex < m && rankedIndex < uniqueRanked.size()) {
            if (player.get(playerIndex) >= uniqueRanked.get(rankedIndex)) {
                result.add(rankedIndex + 1);
                playerIndex++;
            } else {
                rankedIndex++;
            }
        }

        // Assign the same rank to the remaining player's scores
        while (playerIndex < m) {
            result.add(rankedIndex + 1);
            playerIndex++;
        }

        return result;
    }

    public static void main(String[] args) {
//        int[] ranked = {100, 100, 50, 40, 40, 20, 10};
//        int[] player = {5, 25, 50, 120};
//        int[] result = climbingLeaderboard(ranked, player);
//        for (int rank : result) {
//            System.out.println(rank);
//        }

        List<Integer> rankedList = List.of(100, 90, 90, 80);
        List<Integer> playerList = List.of(70, 80, 105);

        System.out.println(climbingLeaderboard1(rankedList, playerList));
        // Output: 4
        //         3
        //         1
    }

    public static List<Integer> climbingLeaderboard1(List<Integer> ranked, List<Integer> player) {
        List<Integer> result = new ArrayList<>();
        List<Integer> distinctRankedScores = getDistinctScores(ranked);

        int n = distinctRankedScores.size();
        int i = n - 1;

        for (int score : player) {
            while (i >= 0 && score >= distinctRankedScores.get(i)) {
                i--;
            }
            result.add(i + 2); // Add 1 to convert from 0-indexed rank to 1-indexed rank
        }

        return result;
    }

    private static List<Integer> getDistinctScores(List<Integer> ranked) {
        List<Integer> distinctScores = new ArrayList<>();
        for (int score : ranked) {
            if (distinctScores.isEmpty() || score != distinctScores.get(distinctScores.size() - 1)) {
                distinctScores.add(score);
            }
        }
        return distinctScores;
    }
}
