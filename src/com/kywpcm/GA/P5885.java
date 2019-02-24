package com.kywpcm.GA;

import java.util.Scanner;

/**
 * <a href="https://www.acmicpc.net/problem/5585">https://www.acmicpc.net/problem/5585</a>
 */
public class P5885 {

    private static final Scanner scanner = new Scanner(System.in);
    private static final int totalM = 1000;

    public static void main(String[] args) {
        String str = scanner.nextLine();

        int payM = Integer.parseInt(str);

        int changeM = totalM - payM;
        int cnt = 0;
        if (changeM / 500 > 0) {
            int a = changeM / 500;
            cnt += a;
            changeM = changeM % 500;
        }
        if (changeM / 100 > 0) {
            int a = changeM / 100;
            cnt += a;
            changeM = changeM % 100;
        }
        if (changeM / 50 > 0) {
            int a = changeM / 50;
            cnt += a;
            changeM = changeM % 50;
        }
        if (changeM / 10 > 0) {
            int a = changeM / 10;
            cnt += a;
            changeM = changeM % 10;
        }
        if (changeM / 5 > 0) {
            int a = changeM / 5;
            cnt += a;
            changeM = changeM % 5;
        }
        if (changeM > 0) {
            cnt += changeM;
        }

        // test
//        System.out.println(changeM);
        System.out.println(cnt);

        scanner.close();
    }

}
