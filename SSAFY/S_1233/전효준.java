package algo_ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {

		for (int test_case = 1; test_case <= 10; test_case++) {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

			int N = Integer.parseInt(st.nextToken());
			int[] num = new int[N];
			int[] ans = new int[N];

			// 기본값을 1(유효함)로 설정해두고 시작
			// N만큼 돌릴 횟수
			for (int i = 0; i < N; i++) {
				// 일단 1로 놓고 된다고 가정
				ans[i] = 1;
				// 반복문 돌 때마다 stringtokenizer 초기화
				st = new StringTokenizer(bf.readLine(), " "); 
				int count = st.countTokens(); // 한 줄에 데이터가 몇 개인지
				
				//테스트 케이스의 횟수
				num[i] = Integer.parseInt(st.nextToken());
				String value = st.nextToken(); // 연산자 혹은 숫자
				char c = value.charAt(0); // 첫 글자 따기

				// 1. 자식이 있는 노드인데 (토큰이 3개 이상)
				if (count > 2) {
					// 숫자라면 (0~9 사이) = X
					if (c >= '0' && c <= '9') {
						ans[i] = 0;
					}
				}
				// 2. 자식이 없는 노드인데 (토큰이 2개뿐)
				else if{
					// 연산자라면 (+, -, *, /) = X
					if (c == '+' || c == '-' || c == '*' || c == '/') {
						ans[i] = 0;
					}
				}
				else ans[i] = 0;
				// 결과값 출력
				System.out.println("#" +num[i] +" " + ans[i]);
			}
		}
	}
}