package com.kywpcm.search;

import java.util.ArrayList;

/**
 * Created by Kwon Youngwoo on 2018.11.18 12:42 PM
 */
public class P01_KY {

  static int baseball[][] = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};

  static ArrayList<Integer> list = new ArrayList<Integer>();
  static ArrayList<Integer> list2 = new ArrayList<Integer>();

  static int result;

  public static void main(String[] args) {

    for (int i = 0; i < baseball.length; i++) {
      if (i == 0) {
        strikeBall(baseball[0]);
      } else {
        strikeBall2(list, baseball[i][0], baseball[i][1], baseball[i][2]);
      }
    }
    System.out.println(list);
    System.out.println(list.size());
  }

  //처음 돌릴 때 (111~999까지의 수 중 첫번째 baseball {123,1,1}을 만족하는 수만 list에 담음
  public static void strikeBall(int array[]) {
    int strike = 0;
    int ball = 0;

    for (int i = 1; i <= 9; i++) {
      for (int j = 1; j <= 9; j++) {
        for (int k = 1; k <= 9; k++) {
          if (i == j | j == k | k == i) {
            continue;
          }
          int temp = array[0];

          strike = 0;
          ball = 0;

          String str[] = Integer.toString(temp).split("");
          int ii = Integer.parseInt(str[0]);
          int jj = Integer.parseInt(str[1]);
          int kk = Integer.parseInt(str[2]);

          //strike 수 파악
          if (i == ii) {
            strike++;
          }
          if (j == jj) {
            strike++;
          }
          if (k == kk) {
            strike++;
          }

          if (strike != array[1]) {
            continue;
          }

          //ball 수 파악
          if (i != ii) {
            if (i == jj | i == kk) {
              ball++;
            }
          }
          if (j != jj) {
            if (j == ii | j == kk) {
              ball++;
            }
          }
          if (k != kk) {
            if (k == ii | k == jj) {
              ball++;
            }
          }

          if (ball != array[2]) {
            continue;
          }

          list.add(i * 100 + j * 10 + k);
        }
      }
    }
  }

  //두번째 부터는 list 중 baseball의 strike,ball 수를 만족하는 수만 list2에 담김 -> list2 => list로 대
  public static void strikeBall2(ArrayList<Integer> list, int num, int s, int b) {

    String str[] = Integer.toString(num).split("");

    //System.out.println("n: "+num);	//

    int n1 = Integer.parseInt(str[0]);
    int n2 = Integer.parseInt(str[1]);
    int n3 = Integer.parseInt(str[2]);

    int strike = 0;
    int ball = 0;

    for (int i = 0; i < list.size(); i++) {
      strike = 0;
      ball = 0;

      //System.out.println("list get: "+ list.get(i));	//

      String temp[] = Integer.toString(list.get(i)).split("");
      int t1 = Integer.parseInt(temp[0]);
      int t2 = Integer.parseInt(temp[1]);
      int t3 = Integer.parseInt(temp[2]);

      //strike 수 파악
      if (t1 == n1) {
        strike++;
      }
      if (t2 == n2) {
        strike++;
      }
      if (t3 == n3) {
        strike++;
      }
      if (strike != s) {
        continue;
      }

      //System.out.println("strike: " + strike);	//

      //ball 수 파악
      if (t1 != n1) {
        if (n1 == t2 | n1 == t3) {
          ball++;
        }
      }
      if (t2 != n2) {
        if (n2 == t1 | n2 == t3) {
          ball++;
        }
      }
      if (t3 != n3) {
        if (n3 == t1 | n3 == t2) {
          ball++;
        }
      }
      if (ball != b) {
        continue;
      }

      //System.out.println("ball: " + ball);	//
      //System.out.println("put:"+list.get(i));

      list2.add(list.get(i));
    }

    //list 초기화 -> list2를 list에 복사 -> list2 초기화
    list.clear();
    list.addAll(list2);
    list2.clear();
  }
}
