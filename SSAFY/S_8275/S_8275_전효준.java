package algo_ws;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S_8275_전효준 {

	/**
	 * I번째 우리에 0마리부터 X마리까지 경우의 수
	 * I+1번째 우리에 0마리부터 X마리까지의 경우의 수
	 * ... R번째 우리에 X마리가 있는 경우의 수
	 * 
	 * -> 모든 기록이 만족하는지 여부 확인해서 다 만족하면 그 만족하는 경우의 수를 N번 우리들에 입력
	 * -> 그 후에 경우의 수 크기비교(사전순으로 가장 앞선거니까 정렬하면 될거같다)
	 */
	
	
	static int N, X, M;
	static int[] cages; // 현재 햄스터 배치를 담을 배열
	static int[] answer; // 정답(최대 햄스터)을 담아둘 배열
	static int maxTotal; // 모든 기록을 만족하는 햄스터 배치 가짓수

	static int[][] conditions = new int[M][3]; // [M][3] -> {시작(l), 끝(r), 합(s)}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 햄스터 우리의 수
			X = Integer.parseInt(st.nextToken()); // 우리당 햄스터 최대 마릿수
			M = Integer.parseInt(st.nextToken()); // 기록의 수

			cages = new int[N + 1]; // 1번 우리부터 쓰기 위해 N+1
			conditions = new int[M][3]; // 만족해야하는 조건들

			// 기록 입력 받기
			for (int i = 0; i < M; i++) { // 기록의 갯수만큼
				st = new StringTokenizer(br.readLine());
				conditions[i][0] = Integer.parseInt(st.nextToken()); // 시작 우리
				conditions[i][1] = Integer.parseInt(st.nextToken()); // 끝 우리
				conditions[i][2] = Integer.parseInt(st.nextToken()); // 햄스터 총 마리수
			}

			// 초기화
			maxTotal = -1; // 모든 기록을 만족하는 햄스터 배치의 수
			answer = null; // 출력할 정답


			dfs(1); // 번 우리부터 채우기 시작

			sb.append("#").append(t).append(" ");
			if (maxTotal == -1) {
				sb.append("-1"); //하나도 만족하는 배치가 없다면 -1 출력
			} else {
				for (int i = 1; i <= N; i++) {
					sb.append(answer[i]).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	// 아까 배운 중복 순열 (dice1, dice3 느낌)
	// cnt: 현재 채우려는 우리 번호
	public static void dfs(int cnt) {
		// 모든 우리(N개)에 햄스터를 다 채웠다면
		if (cnt == N + 1) {
			// M개의 기록을 모두 만족하는지 검사
			if (check()) {
				// 2. 만족한다면 총합 계산
				int currentSum = 0;
				for (int i = 1; i <= N; i++)
					currentSum += cages[i];

				// 3. 최댓값 갱신 -> 사전순 처리
				if (currentSum > maxTotal) {
					maxTotal = currentSum;
					answer = cages.clone(); // 같은 배열을 순회할때는 깊은복사를 해야 함
				}
			}
			return;
		}

		for (int i = 0; i <= X; i++) {
			cages[cnt] = i; // cnt번 우리에 i마리 넣음
			dfs(cnt + 1); // 다음 우리 채우기
		}
	}

	// 기록과 현재 배치가 맞는지 확인하는 함수
	public static boolean check() {
		for (int i = 0; i < M; i++) {
			int l = conditions[i][0];
			int r = conditions[i][1];
			int s = conditions[i][2];

			int sum = 0;
			for (int j = l; j <= r; j++) {
				sum += cages[j];
			}

			if (sum != s)
				return false; // 하나라도 틀리면 실패
		}
		return true; // 다 통과하면 성공
	}
}
