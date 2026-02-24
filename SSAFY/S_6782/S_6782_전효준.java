package S_6782;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S_6782_전효준 {

    static int T;
    static long N;
    static long cnt;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(bf.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Long.parseLong(bf.readLine());
            cnt = Square(0);
            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    public static long Square(long cnt) {
        while (N != 2) {
            long r = (long) Math.sqrt(N);
            if (r * r == N) { // r이 n의 제곱근이면
                N = r; // N을 r의 제곱근으로 만들고
                cnt++; // 카운트 + 1
            } else {
                long nextR = r + 1; // 다음 제곱수의 제곱근
                long nextSquare = nextR * nextR; // 다음 제곱수
                cnt += (nextSquare - N); // 다음 제곱수에 N을 몇번 더할지 계산해서 한번에 더함 N++;
                N = nextR; // N을 다음 완전제곱수의 제곱근으로 대체
                cnt++;
                // N++;
                // cnt++;
            }
        }
        return cnt;
    }
}
