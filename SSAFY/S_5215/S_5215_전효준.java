import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int N;
    static int L;
    static int[] fArr;
    static int[] kArr;

    static int maxScore;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(bf.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            
            fArr = new int[N];
            kArr = new int[N];
            maxScore = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine(), " ");
                fArr[i] = Integer.parseInt(st.nextToken());
                kArr[i] = Integer.parseInt(st.nextToken());
            }

            calculator(0, 0, 0, 0);

            sb.append("#").append(test_case).append(" ").append(maxScore).append("\n"); 
        }
        System.out.println(sb);
    }

    public static void calculator(int cnt, int start, int currentScore, int currentCal) {
        if (currentCal > L) return; 

        if (currentScore > maxScore) {
            maxScore = currentScore;
        }

        for (int i = start; i < N; i++) {
            if (currentCal + kArr[i] <= L) {
                calculator(cnt + 1, i + 1, currentScore + fArr[i], currentCal + kArr[i]);
            }
        }
    }
}