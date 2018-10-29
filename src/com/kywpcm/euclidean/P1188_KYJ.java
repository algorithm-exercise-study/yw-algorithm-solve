package com.kywpcm.euclidean;

import java.util.Scanner;

/**
 * <a href="https://www.acmicpc.net/problem/1188">https://www.acmicpc.net/problem/1188</a>
 */
public class P1188_KYJ {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(m - gcd(n,m));
    }

    public static int gcd(int a, int b){
        if(b == 0)
            return a;
        return gcd(b, a%b);
    }

}
