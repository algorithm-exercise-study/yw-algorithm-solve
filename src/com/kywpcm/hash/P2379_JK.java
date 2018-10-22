package com.kywpcm.hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * <a href="https://www.acmicpc.net/problem/2379">https://www.acmicpc.net/problem/2379</a>
 */
public class P2379_JK {


    boolean bLog = false;

    public static void main(String[] args) {

        P2379_JK h = new P2379_JK();
        //h.compare();
        h.inputDatas();

    }

    public void inputDatas() {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine();

        String[] comp1 = new String[size];
        String[] comp2 = new String[size];

        for (int i = 0; i < size; i++) {
            comp1[i] = sc.nextLine();
            comp2[i] = sc.nextLine();
        }
        sc.close();

        String r1 = "";
        String r2 = "";
        for (int i = 0; i < size; i++) {
            System.out.println(compare(comp1[i], comp2[i]));
        }

    }

    public String compare(String r1, String r2) {

        String h1 = search(r1, 0);
        String h2 = search(r2, 0);
        if (h1.equals(h2)) {
            return "1";
        }
        return "0";
    }


    public void compare() {
        // TODO Auto-generated method stub
        String data1 = "0010011101001011";
        String r1 = search(data1, 0);

        Log(r1 + " " + r1.length() + "<=" + data1 + " " + data1.length());
    }


    //
    public String search(String data, int inRoop) {

        int lev = 0;
        boolean bAdd = false;

        char[] tmp = data.toCharArray();
        StringBuffer sb = new StringBuffer();

        List<String> aList = new ArrayList<String>();

        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] == '0') {
                lev++;
            } else {
                lev--;
            }
            sb.append(tmp[i]);

            if (lev >= 3) {
                bAdd = true;
            }

            //
            if (lev == 0) {

                if (bAdd) {
                    bAdd = false;
                    String tmp2 = sb.substring(1, sb.length() - 1);
                    sb.setLength(0);

                    sb.append("0");
                    sb.append(search(tmp2, inRoop + 1));
                    sb.append("1");

                }

                Log(sb.toString() + " [" + inRoop + "]");
                aList.add(sb.toString());
                sb.setLength(0);

            }

        }

        Collections.sort(aList);
        String r = "";
        for (int i = 0; i < aList.size(); i++) {
            r += aList.get(i);
        }
        return r;

    }

    //
    public void Log(String msg) {
        if (bLog) {
            System.out.println(msg);
        }
    }

}
