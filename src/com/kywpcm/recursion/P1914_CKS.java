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
			move(from,to, list); //������ n-1���� �� �̵��ϸ� �ϳ��� ���Ǹ� ���� �Ǵϱ� ��͸� �����ϱ� ���� ���� ����
		} else{           
			hanoi(n-1,from,to,by, list); //1. ���1���� n-1���� ������ ���3�� �̿��Ͽ� ���2���� �ű��. 
			move(from,to, list);   //2. ���1���� ����1���� ������ ���3���� �ű��.
			hanoi(n-1,by,from,to, list); //3. ���2���� n-1���� ������ ���1�� �̿��Ͽ� ���3���� �ű��.           
		}       
	}

	static public void move(char a, char b, List<String> list){
		list.add(a + " " + b);
	}
}