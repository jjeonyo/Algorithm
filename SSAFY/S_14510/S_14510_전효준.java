package S_14510;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S_14510_전효준 {

    static int T;
    static int N;
    static int[] trees;
    static int days;
    static int maxHeight;
    static int minHeight;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(bf.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(bf.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            trees = new int[N];
            st = new StringTokenizer(bf.readLine(), " ");

            for (int i = 0; i < N; i++) {
                trees[i] = Integer.parseInt(st.nextToken());

            }
            Arrays.sort(trees);
            daycount();
            sb.append("#").append(tc).append(" ").append(days).append("\n");

        }
        System.out.println(sb);
    }

    public static int daycount() {
        // if (minHeight == maxHeight)
        // return;
        days = 0;
        maxHeight = trees[N - 1];

        while (true) {
            boolean allGrowth = true;
            // 모든 나무가 maxHeight가 되기 전까진 붙들고있음
            for (int i = 0; i < N; i++) {
                if (trees[i] < maxHeight) {
                    allGrowth = false;
                    break;
                }
            }

            if (allGrowth)
                break;

            int water = (days % 2 == 0) ? 1 : 2; // 홀수날 : 짝수날

            boolean watered = false; // 오늘 물 줬는지 체크
            // 다음 날을 미리 내다봐서 오늘 물을 주지 않고 내일 물을 줬을 때 키가 딱 맞게 되는 조건이 있다면 continue

            // 오늘 물의 양이랑 딱 맞아떨어지는 나무 찾기
            for (int i = 0; i < N; i++) {
                if (trees[i] >= maxHeight)
                    continue; // 이미 다 큰 나무는 패스

                int diff = maxHeight - trees[i]; // 더 자라야 할 높이
                // 다음 날을 미리 내다봐서 오늘 물을 주지 않고 내일 물을 줬을 때 키가 딱 맞게 되는 조건이 있다면 continue

                if (water == 1 && diff == 2) {
                    continue;
                }
                if (diff == water) { // 더 자라야 할 높이랑 물 양이랑 똑같으면
                    trees[i] += water; // 물 주기
                    watered = true;
                    days++;

                    break; // 하루에 한 그루만 주니까 break
                }
            }

            // 물을 줘도 넘치지 않는 나무에 주기
            if (!watered) {
                for (int i = 0; i < N; i++) {
                    if (trees[i] >= maxHeight)
                        continue;
                    // 다음 날을 미리 내다봐서 오늘 물을 주지 않고 내일 물을 줬을 때 키가 딱 맞게 되는 조건이 있다면 continue

                    int diff = maxHeight - trees[i];
                    // 다음 날을 미리 내다봐서 오늘 물을 주지 않고 내일 물을 줬을 때 키가 딱 맞게 되는 조건이 있다면 continue

                    if (water == 1 && diff == 2) {
                        continue;
                    }
                    // 오늘 물보다 더 많이 자라야 하는 나무면 줌
                    if (diff > water) {
                        trees[i] += water;
                        watered = true;
                        days++;

                        break; // 하루에 한 그루만 주니까 탈출
                    }
                }
            }

            // 물을 주지 못한 경우에도 날짜를 진행해야됨 샤갈
            // 물을 주지 못한 날은 날짜를 진행하면 안됨 왜 ? 물을 준 날만 계산하는거니까 샤갈
            if (!watered) {
                days++;
            }

        }
        return days;
    }
}