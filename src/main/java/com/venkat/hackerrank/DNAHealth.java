package com.venkat.hackerrank;

/**
 * DNA is a nucleic acid present in the bodies of living things. Each piece of DNA contains a number of genes,
 * some of which are beneficial and increase the DNA's total health. Each gene has a health value,
 * and the total health of a DNA is the sum of the health values of all the beneficial genes that occur
 * as a substring in the DNA. We represent genes and DNA as non-empty strings of lowercase English alphabetic letters,
 * and the same gene may appear multiple times as a susbtring of a DNA.
 *
 * Given the following:
 *
 * An array of beneficial gene strings, genes = [g0, g1,...,gn-1]. Note that these gene sequences are not guaranteed to be distinct.
 * An array of gene health values, health = [h0, h1, ...., hn-1], where each hi is the health value for gene gi.
 * A set of  DNA strands where the definition of each strand has three components, start, end, and d,
 * where string d is a DNA for which genes gstart, ..., gend are healthy.
 * Find and print the respective total healths of the unhealthiest (minimum total health) and
 * healthiest (maximum total health) strands of DNA as two space-separated values on a single line.
 *
 * Input Format
 *
 * The first line contains an integer, n, denoting the total number of genes.
 * The second line contains n space-separated strings describing the respective values of g0, g1, ..., gn-1 (i.e., the elements of genes).
 * The third line contains n space-separated integers describing the respective values of h0, h1, ..., hn-1 (i.e., the elements of health).
 * The fourth line contains an integer, s, denoting the number of strands of DNA to process.
 * Each of the s subsequent lines describes a DNA strand in the form start end d, denoting that the
 * healthy genes for DNA strand d are gstart, ..., gend and their respective correlated health values are hstart, ...,hend.
 *
 * Constraints
 * 1 <= n, s <= 10^5
 * 0 <= hi <10^7
 * 0 <= first <= last < n
 * 1 <= the sum of the lengths of all genes and DNA strands <= 2 * 10^6
 * It is guaranteed that each g consists of lowercase English alphabetic letters only (i.e., a to z).
 */
public class DNAHealth {
    public static long calculateTotalHealth(String[] genes, int[] healthValues, String[] strands, int[] startIndices, int[] endIndices) {
        int n = genes.length;
        long[] prefixSum = new long[n];
        long totalHealth = 0;

        // Calculate the prefix sum array
        for (int i = 0; i < n; i++) {
            prefixSum[i] = i == 0 ? healthValues[i] : prefixSum[i - 1] + healthValues[i];
        }

        // Iterate through each DNA strand
        for (int strandIndex = 0; strandIndex < strands.length; strandIndex++) {
            String strand = strands[strandIndex];
            int startIndex = startIndices[strandIndex];
            int endIndex = endIndices[strandIndex];

            // Iterate through each substring of the DNA strand
            for (int i = 0; i < strand.length(); i++) {
                for (int j = i; j < strand.length(); j++) {
                    String substring = strand.substring(i, j + 1);

                    // Check if the substring matches any of the genes
                    for (int geneIndex = 0; geneIndex < n; geneIndex++) {
                        String gene = genes[geneIndex];

                        if (substring.equals(gene)) {
                            // Add the health value of the matched gene to the total health
                            int healthValue = healthValues[geneIndex];
                            totalHealth += healthValue * getOccurrences(strand, substring, startIndex, endIndex);
                        }
                    }
                }
            }
        }

        return totalHealth;
    }

    // Helper method to count the occurrences of a substring in a given range of indices
    private static int getOccurrences(String strand, String substring, int startIndex, int endIndex) {
        int occurrences = 0;
        int index = strand.indexOf(substring, startIndex);

        while (index >= 0 && index <= endIndex) {
            occurrences++;
            index = strand.indexOf(substring, index + 1);
        }

        return occurrences;
    }

    public static void main(String[] args) {
        String[] genes = {"a", "b", "c", "aa", "d", "b"};
        int[] healthValues = {1, 2, 3, 4, 5, 6};
        String[] strands = {"caaab", "xyz", "bcdybc"};
        int[] startIndices = {1, 2, 1};
        int[] endIndices = {5, 2, 8};

        long totalHealth = calculateTotalHealth(genes, healthValues, strands, startIndices, endIndices);
        System.out.println("Total health: " + totalHealth);
    }
}
