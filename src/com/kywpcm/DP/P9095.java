package com.kywpcm.DP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <a href="https://www.acmicpc.net/problem/9095">https://www.acmicpc.net/problem/9095</a>
 */
public class P9095 {

    private static int[] dp = new int[11];
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int line = s.nextInt();
        while (line > 0) {
            int n = s.nextInt();
            list.add(sol(n));
            line--;
        }

        for (Integer n : list)
            System.out.println(n);

        s.close();
    }

    private static int sol(int n) {
        if (dp[n] != 0)
            return dp[n];

        if (n == 3)
            return dp[n] = 4;
        else if (n == 2)
            return dp[n] = 2;
        else if (n == 1)
            return dp[n] = 1;

        dp[n] = sol(n - 1) + sol(n - 2) + sol(n - 3);

        return dp[n];
    }

}
