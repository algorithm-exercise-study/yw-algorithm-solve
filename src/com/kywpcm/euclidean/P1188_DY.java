package com.kywpcm.euclidean;

import java.util.Scanner;

/**
 * <a href="https://www.acmicpc.net/problem/1188">https://www.acmicpc.net/problem/1188</a>
 */
public class P1188_DY {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int sum = 0;

        division(N, M, sum);

    }

    private static void division(int n, int m, int sum) {

        if ((n == m) || (m == 1))
            System.out.println(sum);
        else if (n > m)
            if (n % m == 0)
                System.out.println(sum);
            else
                division(n % m, m, sum);
        else {
            if (m % n == 0) {
                sum += (m / n - 1) * n;
                System.out.println(sum);
            } else {
                sum += n;
                division(n, m - n, sum);
            }

        }
    }

}
