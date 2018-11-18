package com.kywpcm.sort;

import java.util.Arrays;
import java.util.Comparator;
import org.junit.Test;

/**
 * Created by Kwon Youngwoo on 2018.11.18 12:10 PM
 */
public class P01_CKS {

  public String solution(int[] numbers) {
    String answer = "";
    String[] num = new String[numbers.length];

    for (int i = 0; i < num.length; ++i) {
      num[i] = String.valueOf(numbers[i]);
    }

    Arrays.sort(num, new Mycomp());
    if (num[0].equals("0")) {
      answer += "0";
    } else {
      for (int j = 0; j < num.length; j++) {
        answer += num[j];
      }
    }

    return answer;
  }
}

class Mycomp implements Comparator<String> {

  public int compare(String o1, String o2) {
    return (o2 + o1).compareTo(o1 + o2);
  }
}
