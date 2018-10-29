package com.kywpcm.DaQ;

import java.util.Scanner;

public class P1074_DY {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int sum=0;

        such(n, r, c, sum);

    }

    private static void such(int n, int r, int c, int sum) {

        if(n == 0)
            System.out.println(sum);
        else {
            if(r>=Math.pow(2,n)/2 && c>=Math.pow(2, n)/2){
                sum += 3*Math.pow(Math.pow(2,n-1), 2);
                r = (int) (r - (Math.pow(2,n)/2));
                c = (int) (c - (Math.pow(2,n)/2));
            }
            else if(r>=Math.pow(2,n)/2) {
                sum += 2*Math.pow(Math.pow(2,n-1), 2);
                r = (int) (r - (Math.pow(2,n)/2));
            }
            else if(c>=Math.pow(2, n)/2) {
                sum += Math.pow(Math.pow(2,n-1), 2);
                c = (int) (c - (Math.pow(2,n)/2));
            }
            such(n-1, r, c, sum);
        }
    }

}
