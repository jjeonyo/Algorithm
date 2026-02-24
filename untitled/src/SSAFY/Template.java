package SSAFY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Template {

    static int T;
    static int N, d, k, c;
    static int[] sushi;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int tc=1;tc<=T;tc++) {
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            sushi = new int[N];
            for (int i = 1; i < N; i++) {
                sushi[i] = Integer.parseInt(bf.readLine());
            }
        }
    }

    static void dfs() {

    }
}