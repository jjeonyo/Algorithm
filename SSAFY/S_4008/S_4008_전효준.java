package algo_ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S_4008_전효준 {

	static int T;
	static int test_case;
	static int N;
	static int[] numbers;
	static int[] operators;
	static int result;
	static int maxNum;
	static int minNum;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(bf.readLine());
			numbers = new int[N];
			operators = new int[4];
			maxNum = Integer.MIN_VALUE;
			minNum = Integer.MAX_VALUE;
			
			st = new StringTokenizer(bf.readLine(), " ");
			for (int i = 0; i < 4; i++)
				operators[i] = Integer.parseInt(st.nextToken()); // 연산자 입력받는 부분
			
			st = new StringTokenizer(bf.readLine(), " ");
			for (int i = 0; i < N; i++)
				numbers[i] = Integer.parseInt(st.nextToken()); // 숫자들 입력받는 부분

			Calculator(1, numbers[0]);
			sb.append("#").append(test_case).append(" ").append(maxNum - minNum).append("\n");

		}
		System.out.println(sb);
	}

	static void Calculator(int depth, int currentSum) {  //계산기

		if (N == depth) {
			maxNum = Math.max(maxNum, currentSum); // maxNum을 maxNum과 currentSum중 더 높은 값으로 변경
			minNum = Math.min(minNum, currentSum);// 얘도 마찬가지
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (operators[i] > 0) { // 남은 연산자 수가 0개보다 많으면
				operators[i]--; // 일단 하나 내리고

				int nextSum = 0;
				if (i == 0)
					nextSum = currentSum + numbers[depth];  
				else if (i == 1)
					nextSum = currentSum - numbers[depth];
				else if (i == 2)
					nextSum = currentSum * numbers[depth];
				else if (i == 3)
					nextSum = currentSum / numbers[depth];
				// 사칙연산을 수행
				
				Calculator(depth + 1, nextSum);
				operators[i]++;

			}

		}

	}
}
