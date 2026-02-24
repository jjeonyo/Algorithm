package S_2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S_4796_전효준 {

    static int[] value = new int[6];
    static int TC;
    static int N;
    static int[][] farm;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        TC = Integer.parseInt(bf.readLine().trim());
        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(bf.readLine());
            farm = new int[N][N];

            for (int i = 0; i < N; i++) {
                String line = bf.readLine();
                for (int j = 0; j < N; j++) {
                    farm[i][j] = line.charAt(j) - '0';
                }
            }
            int ans = farmTest(0, N / 2, N / 2, 0);
            sb.append("#" + tc + " " + ans + "\n");
        }
        System.out.println(sb);
    }

    public static int farmTest(int row, int start, int end, int currentSum) {

        if (row == N)
            return currentSum;

        int rowSum = 0;
        for (int j = start; j <= end; j++) {
            rowSum += farm[row][j];
        }
        int nextStart, nextEnd;
        int center = N / 2;

        if (row < center) {
            nextStart = start - 1;
            nextEnd = end + 1;
        } else {
            nextStart = start + 1;
            nextEnd = end - 1;
        }

        return farmTest(row + 1, nextStart, nextEnd, currentSum + rowSum);
    }
}