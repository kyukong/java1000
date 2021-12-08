import java.util.*;

class WordScrambleEx4 {

	public static void main(String[] args) {
		String[] strArr = { "CHANGE", "LOVE", "HOPE", "VIEW"};
		Scanner s = new Scanner(System.in);  // 한번 생성해 놓고 재사용하면 되므로 반복문 밖으로 이동


		while(true) {
			String answer = getAnswer(strArr);
			String question = getScrambledWord(answer);
			char[] hint = new char[answer.length()];


			// hint를 '_'로 초기화 한다. 정답이 LOVE라면 hint는 "____"이 된다.
			for(int i=0;i < hint.length;i++) {
				hint[i] = '_';
			}

			while(true) {
				System.out.println("Question :" + question);
				System.out.print("Your answer is :");

				String input = s.nextLine();

				if(input.equalsIgnoreCase("q"))
					System.exit(0);

				if(input.equalsIgnoreCase(answer)) {
					System.out.println("정답입니다.");
					System.out.println();
					break;
				} else {
					System.out.println(input+"은/는 정답이 아닙니다. 다시 시도해보세요.");
					System.out.println("Hint:"+getHint(answer,hint));
				}
			} // while
		} // outer while

	} // main

	public static String getAnswer(String[] strArr) {
		int idx = (int)(Math.random()*strArr.length);
		return strArr[idx];
	}

	// 섞은 결과가 정답과 같은경우도 있을 수 있음. 복잡하지 않게... 그냥 간단히
	public static String getScrambledWord(String str) {
		char[] chArr = str.toCharArray();

		for(int i=0;i<chArr.length; i++) {

			int idx = (int)(Math.random()*str.length());

			char tmp = chArr[i];
			chArr[i] = chArr[idx];
			chArr[idx] = tmp;
		}

		return new String(chArr);
	} // scramble(String str)

	public static String getHint(String answer, char[] hint) {
		int count = getRemainingWordCount(hint);
		if (count > 2) {
			setHint(answer, hint);
		}

		return String.valueOf(hint);
	} // getHint()

	public static int getRemainingWordCount(char[] str) {
		int count = 0;

		for (char word: str) {
			if (word == '_') {
				count++;
			}
		}

		return count;
	}

	public static void setHint(String answer, char[] hint) {
		int idx = getRemainingWordIndex(hint);

		hint[idx] = answer.charAt(idx);
	}

	public static int getRemainingWordIndex(char[] str) {
		int randomIndex = (int)(Math.random()* str.length);

		while (str[randomIndex] != '_') {
			randomIndex = (int)(Math.random()* str.length);
		}

		return randomIndex;
	}
}