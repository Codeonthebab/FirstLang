package com.list;

import java.util.*;

public class QueueEx01 {
	static Queue q = new LinkedList();
	static final int MAX_SIZE = 5;

	public static void main(String[] args) {
		System.out.println("help를 입력하면 도움말을 볼 수 있습니다.");

		while (true) {
			System.out.print(" >> ");

			try {
				Scanner sc = new Scanner(System.in);
				String input = sc.nextLine().trim();
				if ("".equals(input))
					continue;
				if (input.equalsIgnoreCase("q")) {
					System.out.print("프로그램을 종료합니다.");
					System.exit(0);
				} else if (input.equalsIgnoreCase("help")) {
					System.out.println("help - 도움말을 보여줍니다.");
					System.out.println("q 또는 Q - 프로그램을 종료합니다.");
					System.out.println("history - 최근 입력한 명령어를 " + MAX_SIZE + "개 보여줍니다.");
				} else if (input.equalsIgnoreCase("history")) {
					int i = 0;
					save(input);
					LinkedList temp = (LinkedList) q;
					ListIterator it = temp.listIterator();
					while (it.hasNext()) {
						System.out.print(++i + ". " + it.next());
					}
				} else {
					System.out.print(input);
				}
			} catch (Exception e) {
				System.out.println("입력 오류입니다.");
			}
		} // while 문 끝

	} // main 문 끝

	public static void save(String input) {
		// 명령어가 있으면 큐에 저장
		if (!"".equals(input)) {
			q.offer(input);
		}
		// 큐에 최대크기를 넘으면 처음 입력한 것을 삭제시킨다
		if (q.size() > MAX_SIZE) {
			q.remove();

		}
	}
}
