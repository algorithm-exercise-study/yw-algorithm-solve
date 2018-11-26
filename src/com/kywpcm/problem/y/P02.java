package com.kywpcm.problem.y;

/**
 * Created by Kwon Youngwoo on 2018.11.25 11:51 AM
 */
public class P02 {

  public int solution(int[] A) {
    int[] terrainInfo = A;

    int beforeHeight;
    int curHeight;
    int nextHeight = 0;
    boolean isflatThanBefore;
    boolean isHigherThanBefore;
    boolean isLowerThanBefore;
    boolean isflatThanAfter;
    boolean isHigherThanAfter;
    boolean isLowerThanAfter;
    boolean isValley;
    boolean isHill;
    boolean isFirst = true;
    for (int i = 0; i < A.length; i++) {
      // 초기화
      if (i > 0)
        beforeHeight = terrainInfo[i - 1];
      curHeight = terrainInfo[i];
      if (i < A.length - 1)
        nextHeight = terrainInfo[i + 1];

      // 최초 작업
      // 달라지는 순간
      if (isFirst) {
        if (curHeight - nextHeight == 0) {
          // nothing
        } else {

        }
      }

      if (curHeight - nextHeight < 0) { // 음수
        isValley = true;
      }

      // 판단
//      if (isValley)

    }

    return -1;
  }
}
