package algo_ws;

import java.util.*;
import java.io.*;
 
public class ans {
	
	/**
	 *  8개의 데이터를 입력받아서 큐에 저장
	 *  큐에서 첫번째 숫자를 빼고 1을 뺀 후 맨 뒤로 보낸다.
	 *  ~쭉 돌고 5번째 원소에서 5을 뺀 후 다음 뺄셈은 -6이 아닌
	 *  -1로 돌아간다
	 *  맨 뒤 원소의 값이 0과 같거나 작으면 0으로 만들고
	 *  해당 숫자 배열을 암호로 취급한다
	 *  리턴
	 */
	
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for (int tc = 1; tc <= 10; tc++) { // 테스트케이스 10개 
            int n = Integer.parseInt(br.readLine());
            sb.append("#").append(n).append(" ");
            Queue<Integer> q = new LinkedList<>(); // 큐 선언
 
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 8; i++) {
                q.add(Integer.parseInt(st.nextToken())); //int 8개 큐에 삽입
            }
            run(q);
 
            for (int num : q) {
                sb.append(num).append(" ");
            }
        }
        System.out.println(sb);
    }
 
    static void run(Queue<Integer> q) {
        int count = 1;
        while (true) {
            int temp = q.poll() - count;
            if (temp > 0) {
                q.add(temp);
            } else {
                q.add(0);
                break;
            }
 
            count = count % 5 + 1;
        }
    }
 
}