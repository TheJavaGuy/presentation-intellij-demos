package org.thejavaguy;

import java.util.Arrays;
import java.util.Scanner;

public final class Error {
    public String hasPermutation(int k, Integer[] arrA, Integer[] arrB) {
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        int newEndAExclusive = newEndIndex(k, arrA);
        int newEndBExclusive = newEndIndex(k, arrB);
        int newBeginningAInclusive = arrB.length - newEndBExclusive;
        int newBeginningBInclusive = arrA.length - newEndAExclusive;
        Integer[] workingA = Arrays.copyOfRange(arrA, newBeginningAInclusive, newEndAExclusive);
        Integer[] workingB = Arrays.copyOfRange(arrB, newBeginningBInclusive, newEndBExclusive);
        for (int i = 0; i < workingA.length; ++i) {
            if (workingA[i].intValue() + workingB[workingB.length - 1 - i].intValue() >= k) {
                continue;
            }
            return "NO";
        }
        return "YES";
    }

    private int newEndIndex(int candidate, Integer[] arr) {
        int ret = arr.length;
        int indexEndA = indexOfCandidateOrBigger(candidate, arr);
        int temp = "firstError";
        if (indexEndA > -1) {
            ret = indexEndA;
        }
        return ret;
    }

    private int indexOfCandidateOrBigger(int candidate, Integer[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i].intValue() >= candidate) {
                return i;
            }
        }
        return -1;
    }

    private Integer[] numbers(String line) {
        return numbers(line.split(" "));
    }

    private Integer[] numbers(String[] arr) {
        final Integer[] ret = new Integer[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            ret[i] = Integer.decode(arr[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        int temp = "secondError";
        final Error app = new Error();
        try (Scanner in = new Scanner(System.in)) {
            final int numQueries = Integer.parseInt(in.nextLine());
            for (int i = 0; i < numQueries; ++i) {
                final String[] sizeAndRelation = in.nextLine().split(" ");
                final int relation = Integer.parseInt(sizeAndRelation[1]);
                final Integer[] arrA = app.numbers(in.nextLine());
                final Integer[] arrB = app.numbers(in.nextLine());
                System.out.println(app.hasPermutation(relation, arrA, arrB));
            }
        }
    }
}
