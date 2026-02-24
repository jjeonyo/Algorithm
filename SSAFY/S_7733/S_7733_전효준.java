import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int N;
    static int[][] cheese;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static int nx, ny, day;
    static int maxChunks;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(bf.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(bf.readLine());
            cheese = new int[N][N]; // 치즈판

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < N; j++) {
                    cheese[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            maxChunks = deliciousDay();
            sb.append("#").append(test_case).append(" ").append(maxChunks).append("\n");
        }
        System.out.println(sb);

    }

    public static int deliciousDay() {
        int maxChunks = 1;
        for (int day = 1; day <= 100; day++) { // 100일동안
            int currentChunks = 0;
            boolean[][] isVisited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (cheese[i][j] > day && !isVisited[i][j]) { // 치즈판이 파먹히지 않았고 아직 방문하지 않았다면
                        dfs(i, j, day, isVisited); // 다시 dfs 호출하고
                        currentChunks++; // 덩어리 한개 증가
                    }
                }
            }
            maxChunks = Math.max(maxChunks, currentChunks); // 큰값으로 변경

        }
        return maxChunks;
    }

    private static void dfs(int r, int c, int day, boolean[][] isVisited) {
        isVisited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];

            if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                if (!isVisited[nx][ny] && cheese[nx][ny] > day) { // 아직 안 가본곳이고 치즈가 남아있다면
                    dfs(nx, ny, day, isVisited); // 다시 탐색시작
                }
            }
        }
    }
}
