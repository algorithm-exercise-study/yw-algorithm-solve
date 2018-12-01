package com.kywpcm.problem.y;

import java.util.Arrays;
import org.junit.Test;

/**
 * Created by Kwon Youngwoo on 2018.12.02 5:27 AM
 */
public class P02_JK {

  public int findTower(int[] arr) {

    System.out.println("> len:" + arr.length);

    //1, 0
    int[] result = new int[arr.length];
    result[0] = 0;

    // pos = 1;
    int pos = 0;
    for(int i=1;i<arr.length;i++) {

      if( arr[i] - arr[i-1] > 0 ) {

        result[pos++] = 1;
      }else if( arr[i] - arr[i-1] < 0 ) {

        result[pos++] = -1;
      }else {
        //result[pos++] = 0;
      }

    }

    System.out.println(Arrays.toString(result));
    //System.out.println("result len:" + result.length);
    if(pos==0) {
      return 1;
    }

    int findCount = 0;
    for(int i=1;i<pos;i++) {

      if(result[i] != result[i-1] ) {
        ++findCount;
      }
    }

    return findCount + 2;
    //System.out.println(">>" + (findCount + 2));
  }

  @Test
  public void searFindCheck() {

    int[] arr = {2,2,3,4,3,3,2,2,1,1,2,5};
//    int[] arr = {4,-3,-3,-3,4};
//    int[] arr = {-3,-3,-3,-3,-3};  // 1
//    int[] arr = {-3,2,2,2,-3};  // 3
//    int[] arr = {-3,2,1,2,-3};  // 5

    int count = findTower(arr);

    System.out.println("@ count:" + count);
  }
}
