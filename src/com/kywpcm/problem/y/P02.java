package com.kywpcm.problem.y;

import org.junit.Test;

/**
 * Created by Kwon Youngwoo on 2018.11.25 11:51 AM
 */
public class P02 {

  @SuppressWarnings("Duplicates")
  public int solution(int[] A) {
    int[] terrainInfo = A;

    int beforeHeight;
    int curHeight;
    int nextHeight;
    boolean isLowerThanBefore = false;
    boolean isHigherThanBefore = false;
    boolean isLowerThanAfter = false;
    boolean isHigherThanAfter = false;
    boolean isFlat = false;
    int totalCastleCnt = 0;

    int firstHeight = terrainInfo[0];
    int edgeCastleCnt = 0;
    boolean isNotAllFlat = false;
    for (int aTerrainInfo : terrainInfo) {
      if (firstHeight != aTerrainInfo) {
        edgeCastleCnt = 2;
        isNotAllFlat = true;
        break;
      }
    }
    if (!isNotAllFlat) // 전부 다 평평
      return 1;

    for (int i = 1; i < terrainInfo.length - 1; i++) {
      // 초기화
      beforeHeight = terrainInfo[i - 1];
      curHeight = terrainInfo[i];
      nextHeight = terrainInfo[i + 1];

      if (curHeight - beforeHeight > 0) { // 기울기 양수 => 현재가 높음
        isHigherThanBefore = true;
      } else if (curHeight - beforeHeight == 0) { // 기울이 0 => 평평
        isFlat = true;
      } else if (curHeight - beforeHeight < 0) { // 기울기 음수 => 현재가 낮음
        isLowerThanBefore = true;
      }

      if (nextHeight - curHeight > 0) { // 기울기 양수 => 현재가 낮음
        isLowerThanAfter = true;
      } else if (nextHeight - curHeight == 0) { // 기울이 0 => 평평
        isFlat = true;
      } else if (nextHeight - curHeight < 0) { // 기울기 음수 => 현재가 높음
        isHigherThanAfter = true;
      }

      // 판단
      if (isHigherThanBefore && isHigherThanAfter
        || isHigherThanBefore && isFlat && isHigherThanAfter) { // hill
        totalCastleCnt++;
        isHigherThanBefore = false; isFlat = false; isHigherThanAfter = false;
        isLowerThanAfter = false;
      } else if (isLowerThanBefore && isLowerThanAfter
        || isLowerThanBefore && isFlat && isLowerThanAfter) { // valley
        totalCastleCnt++;
        isLowerThanBefore = false; isFlat = false; isLowerThanAfter = false;
        isHigherThanAfter = false;
      }
    }

    totalCastleCnt += edgeCastleCnt;
    return totalCastleCnt;
  }

  @Test
  public void testSolution() {
    int[] A = {2, 2, 3, 4, 3, 3, 2, 2, 1, 1, 2, 5}; // 4
//    int[] A = {-3, -3, -3, -3, -3}; // 1
//    int[] A = {-3, 2, 2, 2, -3}; // 3
//    int[] A = {-3, 2, 1, 2, -3}; // 5
    int result = solution(A);
    System.out.println(result);
  }
}
