import java.util.ArrayList;
import java.util.Scanner;

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

			for (int i = 0; i < commandCount; i++) {
				String command = sc.next();
				if (command.equals("I")) { // 커맨드 "I"가 들어오면
					int x = sc.nextInt(); // 삽입할 위치
					int y = sc.nextInt(); // 삽입할 숫자의 개수를 인풋으로 입력받음

					// 삽입할 숫자의 갯수만큼 반복
					for (int j = 0; j < y; j++) {
						// x 위치에 숫자를 넣으면 기존 데이터는 뒤로 밀려남
						list.add(x + j, sc.nextInt());
					}
				}
			}

			// 결과 출력
			System.out.print("#" + test_case);
			// 수정된 결과의 처음 10개 출력
			for (int i = 0; i < 10; i++) {
				System.out.print(" " + list.get(i));
			}
			System.out.println();
		}
		sc.close();
	}
}