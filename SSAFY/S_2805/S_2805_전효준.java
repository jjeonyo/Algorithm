package S_2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Scanner;

public class S_2805_전효준 {

    static int T, N;
    static int[] mounts;
    static int cnt;

    public static void main(String[] args) throws IOException {
        // BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        // StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // T = Integer.parseInt(bf.readLine());
        T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            // N = Integer.parseInt(bf.readLine());
            N = sc.nextInt();
            mounts = new int[N];
            // st = new StringTokenizer(bf.readLine(), " ");
            cnt = 0;
            for (int i = 0; i < N; i++) {
                // mounts[i] = Integer.parseInt(st.nextToken());
                mounts[i] = sc.nextInt();
            }
            mountCount();
            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
        sc.close();
    }

    public static void mountCount() {

        /**
         * 지금 산이 다음 산보다 크지 않거나 다다음 산이 다음 산보다 작으면
         * continue
         * 
         */

        int i = 0;
        while (i < N - 1) {
            int up = 0;
            int down = 0;

            while (i < N - 1 && mounts[i] < mounts[i + 1]) {
                up++;
                i++;
            }
            while (i < N - 1 && mounts[i] > mounts[i + 1]) {
                down++;
                i++;
            }

            if (up > 0 && down > 0) {
                cnt += (up * down);
            }
            if (up == 0 && down == 0) {
                i++;
            }
        }

        // for (int i = 0; i < N - 2; i++) {
        // if (!(mounts[i] < mounts[i + 1] && mounts[i + 1] > mounts[i + 2]))
        // continue;
        // else {
        // cnt++;
        // }
        // // mountCount(i + 1, cnt);
        // }
    }
}
