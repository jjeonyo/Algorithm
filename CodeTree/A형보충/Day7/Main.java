import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, T;
    static int[][] map;
    static int[][] rc;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int r, c;

    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(null);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        st = new StringTokenizer(null);
        rc[r][c] = Integer.parseInt(st.nextToken());

        for (int i = 0; i<T; i++) {
            goosul();
        }
    }

    static void goosul() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

            }
        }
    }
}