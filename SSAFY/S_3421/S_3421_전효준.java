package algo_ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S_3421_전효준 {

	static int N, M;
	static boolean[][] bad; // 궁합이 안 맞는 재료 정보를 담을 2차원 배열
	static boolean[] isSelected; // 현재 햄버거에 들어간 재료 체크
	static int totalCnt; // 만들 수 있는 햄버거 종류 수 (정답)

	public static void main(String[] args) throws IOException { 
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 재료 개수
			M = Integer.parseInt(st.nextToken()); // 안 맞는 쌍의 개수

			
			bad = new boolean[N + 1][N + 1]; // 1부터 N개까지
			isSelected = new boolean[N + 1]; // 역시나 1부터 N개까지
			totalCnt = 0;

			// M개의 안 맞는 궁합 정보 입력
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(bf.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				// 서로 안 맞음을 표시 (양방향)
				bad[a][b] = true; // [a][b]와 [b][a] 둘 다 체크해야 오름차순 내림차순 검사할 때 쓸 수 있음
				bad[b][a] = true; // 이거쓸데가없었네;;
			}

			// 1번 재료부터 시작
			subset(1);

			sb.append("#").append(test_case).append(" ").append(totalCnt).append("\n");
		}
		System.out.println(sb);
	}

	// 현재 고려하고 있는 재료 번호
	public static void subset(int cnt) {
		
		// [기저 조건] 모든 재료(N번까지)를 다 살펴봤으면?
		if (cnt == N + 1) {
			totalCnt++; // 햄버거 1개 완성
			return;
		}

		// 1. 현재 재료(cnt)를 햄버거에 "넣는" 경우
		// -> 넣기 전에 조건검사해야함
		boolean isOk = true; //일단 넣을 수 있다고 판단해주고
		for (int i = 1; i < cnt; i++) {
			// 모든 재료 포문돌려서 이미 넣은 재료랑 지금 넣는 재료랑 조합이 나쁘다면
			if (isSelected[i] && bad[cnt][i]) {
				isOk = false;
				break;
			}
		}
		
		// 조합이 나쁘지 않은 경우에만 넣을 수 있음
		if (isOk) {
			isSelected[cnt] = true;
			subset(cnt + 1);
			isSelected[cnt] = false; // 다시 원점 회귀
		}
		
		// 안 넣는 경우는 패스패스
		subset(cnt + 1);
	}
}