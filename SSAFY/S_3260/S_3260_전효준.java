package algo_ws;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class add {

	public static void main(String[] args) {
		int T = 0;
		int a = 0;
		int b = 0;


		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		int[] arr = new int[T];
		for (int i=0; i<T; i++) {
	
			int result = 0;
			a = sc.nextInt();
			b = sc.nextInt();
			result = a + b;
			arr[i] = result;
		}
		
		for (int i=0; i<T; i++) {
			System.out.println("#"+ (i+1) + " " + arr[i]);
		}
	}
}
