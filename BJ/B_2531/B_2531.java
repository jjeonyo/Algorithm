package Algorithm.BJ.B_2531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2531 {

    static int N, d, k, c;
    static int[] sushi;
    static int[] isSelected;
    static int maxSushi = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        sushi = new int[N];
        isSelected = new int[d + 1];
        
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(bf.readLine());
        }

        // 모든 인덱스를 시작점으로 삼아 DFS 탐색 시작
        for (int i = 0; i < N; i++) {
            dfs(i, 0, 0);
        }

        System.out.println(maxSushi);
    }

    static void dfs(int start, int depth, int kind) { 
        if (depth == k) {
            int total = kind;
            if (isSelected[c] == 0) {
                total++;
            }
            maxSushi = Math.max(maxSushi, total);
            return;
        }
        
        int idx = (start + depth) % N; 
        int currentSushi = sushi[idx]; 

        if(isSelected[currentSushi] == 0) { 
            kind++;
        }
        isSelected[currentSushi]++;

        dfs(start, depth + 1, kind);
        
        // 탐색이 끝난 후 방문 기록 되돌리기 (백트래킹)
        isSelected[currentSushi]--; 
    }
}