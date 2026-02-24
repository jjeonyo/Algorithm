package algo_ws;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 전체 테스트 케이스 개수

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(); // 전체
            int M = sc.nextInt(); // 파리채 크기
            int[][] map = new int[N][N];

            // 파리들 입력
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int paris = 0;

            // 파리채를 휘두르는 지점 탐색
            for (int i = 0; i <= N - M; i++) {
                for (int j = 0; j <= N - M; j++) {
                    
                    int currentParis = 0;
                    // (i, j) 지점을 왼쪽 상단 꼭짓점으로 하여 M x M 영역 합산
                    for (int r = i; r < i + M; r++) {
                        for (int c = j; c < j + M; c++) {
                            currentParis += map[r][c];
                        }
                    }

                    // 최대파리 갱신해주기
                    if (currentParis > paris) {
                        paris = currentParis;
                    }
                }
            }

            // 결과 출력
            System.out.println("#" + tc + " " + paris);
        }
        sc.close();
    }
}
		
		
		
	
//		int test_case = sc.nextInt(); // 테스트 케이스
//		
//		int dy[] = {-1, -1, 1, 1}; //사방탐색 써야하나?
//		int dx[] = {-1, 1, -1, 1};
//		
//		map[][] = sc.nextInt();
//		
//		for(int i=0; i<test_case;i++) {
//			for(int j=0; j<N;j++) {
//				for (int k=0; k<N; k++) {
//					int nx = i+dx[k];
//					int ny = j+dx[k];
//				}
//			}
//			
//			
//			N = sc.nextInt();
//			M = sc.nextInt();
//			int[][] arr = new int[N][N]; //영역의 크기
//			int[][] paristick = new int[M][M]; // 파리채의 크기
//			
//			
//			
//			if (dy[M-1]dx[M-1] && dy[M-1]dx[M+1] && dy[M+1]dx[M-1] && dy[M+1]dx[M+1]) // 현재 파리채로 죽인 파리의 수가 제일 많이 죽인 파리의 수보다 많으면
//			{
//				
//			}
//			if (current > max) max = current; // 제일 많이 죽인 파리의 수 갱신
//			
//			
	
	
	
//	System.out.print("#" + test_case);
//	System.out.println(max);
//	System.out.println();
//		}
