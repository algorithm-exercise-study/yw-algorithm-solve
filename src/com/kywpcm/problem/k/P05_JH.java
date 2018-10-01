package com.kywpcm.problem.k;

import java.util.Arrays;

public class P05_JH {

    static int num = 0;

    public static void main(String[] args) {

        String a = "14567";
        String b = "45168";
        String[] aArray = a.split("");
        String[] bArray = b.split("");
        String result = "";

        Arrays.sort(aArray);
        Arrays.sort(bArray);

        for (int i = 0; i < aArray.length; i++) {
            if (aArray[i].equals(bArray[i])) {
                result = result + aArray[i];
            }
        }

        String[] ourArray = result.split("");


        permute(ourArray, ourArray.length);
        System.out.println(num);
    }

    private static void swap(String[] ourarray, int right, int left) {
        String temp = ourarray[right];
        ourarray[right] = ourarray[left];
        ourarray[left] = temp;

    }

    public static void permute(String[] ourArray, int currentPosition) {
        if (currentPosition == 1) {
            num++;
        } else {
            for (int i = 0; i < currentPosition; i++) {
                // subtract one from the last position (here is where you are
                // selecting the the next last item
                permute(ourArray, currentPosition - 1);

                // if it's odd position
                if (currentPosition % 2 == 1) {
                    swap(ourArray, 0, currentPosition - 1);
                } else {
                    swap(ourArray, i, currentPosition - 1);
                }
            }
        }
    }

}
