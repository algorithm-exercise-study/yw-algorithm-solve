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

        int tabSize = Integer.parseInt(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            String code = list.get(i);

            String replacedCode = replaceTabToSpace(tabSize, code);
            System.out.println(replacedCode);
        }
    }

    public static String replaceTabToSpace(int tabSize, String code) {

        StringBuilder replaceCode = new StringBuilder();

        int spaceCnt = 0;
        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            if (c == 32) { // space
                spaceCnt++;
                replaceCode.append(c);
            } else if (c == 9) { // tab
                int diff = tabSize - spaceCnt;
                if (diff > 0) {
                    StringBuilder space = new StringBuilder();
                    for (int j = 1; j <= diff; j++)
                        space.append(" ");

                    replaceCode.append(space);

                    spaceCnt = 0;
                } else {
                    // nothing...
                }
            } else
                replaceCode.append(c);

        }

        return replaceCode.toString();
    }

}
