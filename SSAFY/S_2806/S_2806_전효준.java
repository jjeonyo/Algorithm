package live_0210;

import java.util.Scanner;

public class NQueenTest {

	static int N, totalCnt;
	static boolean[] col, slash, bSlash;
	static int T;

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case=1;test_case<=T; test_case++) {
		N = sc.nextInt();
		totalCnt = 0;

		col = new boolean[N + 1]; // 열의 위치
		slash = new boolean[2 * N + 1]; // /방향의 대각선 파악
		bSlash = new boolean[2 * N]; // \방향의 대각선 파악

		setQueen(1);
		// System.out.println("#"+test_case+" "+totalCnt);
		sb.append("#").append(test_case).append(" ").append(totalCnt).append("\n");
	}
		System.out.println(sb);
	}

	static void setQueen(int row) {

		if (row > N) { // 행이 전체 판보다 커지면 (더이상 볼 것이 없으면)
			totalCnt++; //전체 카운트 증가
			return;
		}

		for (int c = 1; c <= N; c++) {
			// 유망성 체크 : Row행의 c열에 두는것이 가능한지
			if (col[c] || slash[row + c] || bSlash[(row - c) + N]) // 열이 중복되었거나 | /에 닿거나 | \에 닿거나 하는 경우엔
				continue; // 가지치기

			col[c] = slash[row + c] = bSlash[(row - c) + N] = true; // 
			setQueen(row + 1);
			col[c] = slash[row + c] = bSlash[(row - c) + N] = false; // 다른 선택지 시도를 위해 상태 원복
		}
	}
}
