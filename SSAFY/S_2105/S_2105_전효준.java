package S_2105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S_2105_전효준 {

    static int TC;
    static int N;
    static int[][] dessert;
    static boolean[] isVisited;

    static int nx, ny;
    // 대각선 4방향(시계 방향)
    // 0: 우하, 1: 좌하, 2: 좌상, 3: 우상
    static int[] dx = { 1, 1, -1, -1 };
    static int[] dy = { 1, -1, -1, 1 };
    static int maxDessert;
    static int startX, startY;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        TC = Integer.parseInt(bf.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(bf.readLine());
            dessert = new int[N][N];
            maxDessert = -1;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < N; j++) {
                    dessert[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            /*
             * 모든 가능한 시작점을 순회한다.
             * - i < N - 2:
             * 최소한 아래로 2칸 이상 진행할 여유가 있어야 마름모 경로(4변)를 만들 가능성이 높다.
             * - j는 1 ~ N-2:
             * 시작점이 너무 좌/우 경계에 붙으면 대각선 회전 경로를 만들기 어렵다.
             */
            for (int i = 0; i < N - 2; i++) {
                for (int j = 1; j < N - 1; j++) {
                    startX = i;
                    startY = j;

                    isVisited = new boolean[101];

                    // 시작 카페의 디저트는 이미 먹은 것으로 표시하고 탐색 시작
                    isVisited[dessert[i][j]] = true;
                    // count=1로 시작 카페 포함
                    // dir=0로 첫 진행 방향을 우하부터 시도
                    dessertTour(i, j, 0, 1);

                }
            }
            sb.append("#").append(tc).append(" ").append(maxDessert).append("\n");
        }
        System.out.println(sb);
    }

    public static void dessertTour(int x, int y, int dir, int count) {

        /*
         * - x, y: 현재 위치
         * - dir: "현재까지 선택한 방향 인덱스의 하한"
         * - count: 지금까지 방문한 카페 수(먹은 디저트 수)
         */
        for (int d = dir; d < 4; d++) {
            // 같은 방향으로 직진하거나, 다음 방향으로 1번 꺾는 선택을 포함
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 시작점으로 복귀하면 하나의 투어 완성.
            if (nx == startX && ny == startY && count >= 4) {
                maxDessert = Math.max(maxDessert, count);
                return;
            }

            // 다음 칸이 지도 내부이고 해당 디저트를 아직 먹지 않았다면 방문 후 재귀 탐색
            if (0 <= nx && nx < N && 0 <= ny && ny < N && !isVisited[dessert[nx][ny]]) {
                isVisited[dessert[nx][ny]] = true;

                // d를 넘겨 재귀 호출
                dessertTour(nx, ny, d, count + 1);

                // 백트래킹
                isVisited[dessert[nx][ny]] = false;
            }
        }
    }
}
