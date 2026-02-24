import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt();
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				list.add(sc.nextInt());
			}

			// 2. 명령어 개수 입력
			int commandCount = sc.nextInt();

			// 3. 명령어를 처리
			for (int i = 0; i < commandCount; i++) {
				String type = sc.next();

				if (type.equals("I")) { // 커맨드 I가 들어온다면
					int x = sc.nextInt(); // 삽입할 위치
					int y = sc.nextInt(); // 삽입할 개수

					for (int j = 0; j < y; j++) {
						list.add(x + j, sc.nextInt()); // list에 삽입
					}
				} else if (type.equals("D")) { // 커맨드 D가 들어온다면
					int x = sc.nextInt(); // 삭제할 위치
					int y = sc.nextInt(); // 삭제할 개수
					for (int j = 0; j < y; j++) {
						// x 위치의 요소를 y번 삭제
						// 하나 삭제하면 뒤의 요소들이 앞으로 당겨지므로 계속 x 인덱스를 삭제
						list.remove(x);
					}
				}
			}

			// 4. 결과 출력 (앞 10개만)
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}
	}
}
