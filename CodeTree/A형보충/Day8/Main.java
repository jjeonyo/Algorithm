package Algorithm.CodeTree.A형보충.Day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int K, N;
    static boolean[] isSelected;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        permutation(0);
        
        System.out.println(sum);
    }


    public static void permutation(int sum) {

        int cnt = 0;
        for (int i = 1; i < K; i++) {
            if (cnt == N) {
                cnt++;
                return;
            }
            if (isSelected[i]) continue;
            permutation(i+1);
            isSelected[i] = false;
            cnt++;
        }
    }

}

