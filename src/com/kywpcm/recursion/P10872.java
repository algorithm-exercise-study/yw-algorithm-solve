package com.kywpcm.recursion;

import org.junit.Test;

/**
 * <a href="https://www.acmicpc.net/problem/P10872">https://www.acmicpc.net/problem/10872</a>
 */
public class P10872 {

    private long factorial1(long n) {
        if (n == 0)
            return 1;

        return n * factorial1(n - 1);
    }

    private long factorial2(long n) {
        long res = 1;
        for (; n >= 1; n--) {
            res = res * n;
        }
        return res;
    }

    @Test
    public void recursionTest() {
//        long res = factorial1(9000);
        long res = factorial1(100000);
//        long res = factorial1(25);
        System.out.println("result : " + res);
    }

    @Test
    public void forStatementTest() {
//        long res = factorial2(9000);
        long res = factorial2(100000);
//        long res = factorial2(25);
        System.out.println("result : " + res);
    }

}
