package algo_ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	// static boolean[] month;
	static int[] months = new int[13];
	static int[] costs = new int[4];
	static int T, test_case;
	static int minCost;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = Integer.parseInt(bf.readLine());
		for (test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int i = 0; i < 4; i++) {
				costs[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(bf.readLine(), " ");
			for (int i=1;i<=12;i++) {
				months[i] = Integer.parseInt(st.nextToken());
			}
			minCost = costs[3]; //mincost 초기값은 1년권으로 설정
			swimCost(1,0);
			sb.append("#").append(test_case).append(" ").append(minCost).append("\n");
		}
		System.out.println(sb);
	}

	public static void swimCost(int month, int currentCost) {
		if (month > 12)
		{minCost = Math.min(minCost, currentCost);
			return; }
		
		// 가지치기: 이미 최소비용을 넘었으면 중단
        if (currentCost >= minCost) return;

        swimCost(month + 1, currentCost + (months[month] * costs[0])); //일일권

        swimCost(month + 1, currentCost + costs[1]); // 한달권

        swimCost(month + 3, currentCost + costs[2]); // 분기권
    }
}
