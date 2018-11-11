package com.kywpcm.problem.bm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P04 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        List<String> list = new ArrayList<>();
        try {
            while (true) {
                input = br.readLine();
                if (input.equals("END")) break;
                list.add(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> reList = new ArrayList<>();

        int tabSize = Integer.parseInt(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            String code = list.get(i);
            // test
//            System.out.println(code);

            reList.add(replaceTabToSpace(tabSize, code));
        }
    }

    public static String replaceTabToSpace(int tabSize, String code) {

        String re = code.replaceAll("^\\s*\\t", "    ");
        // test
        System.out.println(re);

        return re;
    }

}
