import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static int T;
    static int N, M;
    static int[][] map;
    static boolean[][] isVisited;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int x, y, cx, cy;
    static Queue<Point> sQueue = new ArrayDeque<>();
    static Queue<Point> vQueue = new ArrayDeque<>();

    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int tc=1;tc<=T;tc++) {
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[M][N];
            isVisited = new boolean[N][M];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 3) {
                        x = i;
                        y = j;
                    } 
                }
            }
            

        }
    }

    class Node {
        int to;
        Node next;
    }

    class Point {
        int x, y, time;
        Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    static void solve() {


        int time = 0;
        for (int i = 0; i <= 8; i++) {
            isVisited[x][y] = true;
            while(!sQueue.isEmpty()) {
                time++;
                int vSize = vQueue.size();
            for (int j = 0; j <vSize; j++) {
                Point v =vQueue.poll();
            }

            int sSize = sQueue.size();
            for (int j = 0; j <sSize; j++) {
                Point s = sQueue.poll();
            }


            for (int d = 0; d < 4; d++) {

                cx = x + dx[d];
                cy = y + dy[d];

                if (x < 0 || y < 0 || x > N || y > M) {
                    System.out.println("탈출성공");
                    break;
                }
                if (map[cx][cy] == 0 && !isVisited[cx][cy]) {
                    isVisited[cx][cy] = true;
                    sQueue.add(new Point(cx, cy, time));
                }
                if (sQueue.isEmpty()) {
                    if ()
                }

            }

            }
    }
}
}


    // public static void solve() {
    //     int virus = 2;
    //     //탈출이 불가능하다면 cannot escape 
    //     if () // 지도에 3이 없으면 종료
    //     //if 3이 지도 밖에 있으면 시간 출력 else zombie 출력

    //     for (int i = 0; i <= 8; i++) {
    //         if (map[i][j] != 1) {
    //         map[virus+i][virus+i] = map[virus][virus]; 
    //     }
    //         for (int j = 0; j < 4; j++) {
    //             cx = x + dx[j];
    //             cy = y + dy[j];
    //         }
            
    //     } //
    // }
// }