import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    // 1. 큐에 좌표를 넣기 위한 노드 클래스
    static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    // 전역 변수로 기본값 설정
    static int[][] map;
    static boolean[][] visited;
    //static int[][] goal;
    static int N = 100;
    
    // 방향: 좌, 우, 위
    static int[] dr = {0, 0, -1}; 
    static int[] dc = {-1, 1, 0};

  
    public int bfs(int startR, int startC) {
        
        Queue<Node> queue = new ArrayDeque<>();
        
        // 시작점 : 숫자 2가 있던 곳을 큐에 넣음
        queue.offer(new Node(startR, startC));
        visited[startR][startC] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // [종료 조건] 맨 위(0행)에 도착하면 그 열(c)이 정답!
            if (current.r == 0) {
                return current.c;
            }

            // [길 찾기] 좌, 우, 위 3방향 탐색
            for (int d = 0; d < 3; d++) {
                int nr = current.r + dr[d];
                int nc = current.c + dc[d];

                // 맵 범위 안이고, 길이 있고(1), 방문하지 않았다면
                if (nr >= 0 && nr < N && nc >= 0 && nc < N 
                        && map[nr][nc] == 1 && !visited[nr][nc]) {
                    
                	//큐에다 넣고 방문처리를 해줌
                    queue.offer(new Node(nr, nc));
                    visited[nr][nc] = true;
                    
                    // 바로 break를 해줘야 딴길로 안샘
                    break; 
                }
            }
        }
       return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(bf.readLine());
    	//System.out.println("ㅎㅇ");

        // 
        Solution sol = new Solution();

        for (int test_case = 1; test_case <= 10; test_case++) {
        	String skip = bf.readLine(); // 뒤에서부터 찾는 로직이라 얘는 필요가 없음
            map = new int[N][N];
            visited = new boolean[N][N];
          //  goal = new int[X][N+1];
 
           int startR = 0, startC = 0;
           
            // 맵 입력 받기
            for (int i = 0; i < N; i++) {
            	
            	StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    
                    // 도착점(2)을 찾아서 시작점으로 설정 (거꾸로 탐색)
                    if (map[i][j] == 2) {
                        startR = i;
                        startC = j;
                        // 2도 길이니까 1로 바꿔서 이동 가능하게 해야함 - 이거좀 등잔밑이 어두웠다
                        map[i][j] = 1; 
                    }
                }
            }
            
            // 3. BFS 실행 및 결과 출력
            int answer = sol.bfs(startR, startC);
            System.out.println("#" + test_case + " " + answer);
        }
    }
}