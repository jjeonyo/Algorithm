package S_1267;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class S_1267_전효준 {

    static int TC = 10;
    static int V, E;

    static StringBuilder sb = new StringBuilder();
    // 인접 리스트: from 정점에서 갈 수 있는 to 정점 목록
    static List<Integer>[] adjList;
    // 각 정점으로 들어오는 간선 수(진입 차수)
    static int[] inDegree;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // SWEA 1267은 테스트케이스가 10개로 고정
        for (int tc = 1; tc <= 10; tc++) {
            String line = bf.readLine();
            if (line == null)
                break;

            st = new StringTokenizer(line);
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            adjList = new ArrayList[V + 1];
            inDegree = new int[V + 1];
            for (int i = 0; i <= V; i++) {
                adjList[i] = new ArrayList<>();
            }

            // 간선 정보를 읽어 그래프와 진입 차수를 구성
            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < E; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                adjList[from].add(to);
                inDegree[to]++;
            }
            sb.append("#").append(tc).append(" ");
            topologySort();
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void topologySort() {

        /*
         * 위상 정렬(Topological Sort):
         * - 방향 그래프에서 "선행 작업 -> 후행 작업" 제약을 만족하도록 정점을 나열하는 알고리즘
         * - 사이클이 없는 DAG(Directed Acyclic Graph)에서만 모든 정점을 순서대로 배치할 수 있다.
         */
        Queue<Integer> queue = new ArrayDeque<>();

        // 초기 상태에서 진입 차수가 0인 정점을 전부 큐에 넣음.
        for (int i = 1; i <= V; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 큐가 빌 때까지 처리 가능한 정점을 하나씩 꺼내 위상 순서를 만듬
        while (!queue.isEmpty()) {
            // 큐에서 꺼낸 정점은 현재 시점에서 선행 조건이 모두 해결된 정점
            int current = queue.poll();

            // 위상 정렬 결과에 현재 정점을 기록
            sb.append(current).append(" ");

            // current -> next 간선을 따라가며 current가 처리되었음을 반영
            for (int next : adjList[current]) {
                // next의 선행 정점 하나가 끝났으므로 진입 차수 1 감소
                inDegree[next]--;

                // 감소 결과 진입 차수가 0이면
                // next도 이제 선행 조건이 모두 충족되었으므로 큐에 추가
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        /*
         * 시간 복잡도:
         * - 각 정점은 큐에 최대 1번 삽입/삭제 -> O(V)
         * - 각 간선은 정확히 1번씩만 확인 -> O(E)
         * => 전체 O(V + E)
         *
         */
    }
}
