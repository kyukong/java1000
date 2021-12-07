package simplequiz3.View;

public class Output {
	private static final String LEFT_WORD = "[";
	private static final String RIGHT_WORD = "]";
	private static final String SPACE = " ";
	private static final String ANSWER_WAIT = "답";
	private static final String SCORE_PREFIX = "정답개수/전체문항수 : ";
	private static final String SLASH = "/";

	public static void printQuestion(int number, String question) {
		System.out.println(LEFT_WORD + number + RIGHT_WORD + SPACE + question);
	}

	public static void printChoices(String[] choices) {
		for (int i = 0; i < choices.length; i++) {
			System.out.print((i + 1) + "." + choices[i] + SPACE);
		}
		System.out.println();
	}

	public static void printAnswerWait() {
		System.out.print(LEFT_WORD + ANSWER_WAIT + RIGHT_WORD + SPACE);
	}

	public static void printScore(int score, int total) {
		System.out.println(SCORE_PREFIX + score + SLASH + total);
	}
}
