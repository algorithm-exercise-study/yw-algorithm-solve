package com.kywpcm.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <a href="https://www.acmicpc.net/problem/1914">https://www.acmicpc.net/problem/1914</a>
 */
public class P1914_CKS {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		List<String> list = new ArrayList<String>();
		hanoi(n, '1', '2', '3', list);

		System.out.println(list.size());
		if(n > 20){
			return;
		}

		for(String str : list){
			System.out.println(str);
		}
	}

	static public void hanoi(int n, char from, char by, char to, List<String> list){
		if(n == 1){
			move(from,to, list); //원판이 n-1개가 다 이동하면 하나의 원판만 남게 되니까 재귀를 종료하기 위한 종료 조건
		} else{           
			hanoi(n-1,from,to,by, list); //1. 기둥1에서 n-1개의 원판을 기둥3를 이용하여 기둥2으로 옮긴다. 
			move(from,to, list);   //2. 기둥1에서 남은1개의 원판을 기둥3으로 옮긴다.
			hanoi(n-1,by,from,to, list); //3. 기둥2에서 n-1개의 원판을 기둥1을 이용하여 기둥3으로 옮긴다.           
		}       
	}

	static public void move(char a, char b, List<String> list){
		list.add(a + " " + b);
	}
}