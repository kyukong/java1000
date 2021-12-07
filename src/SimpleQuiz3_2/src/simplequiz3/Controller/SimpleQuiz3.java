package simplequiz3.Controller;

import static simplequiz3.View.Output.*;

import java.net.Inet4Address;
import java.util.Scanner;

import simplequiz3.Model.Data;
import simplequiz3.Model.Questions;

public class SimpleQuiz3 {
	private static final String SPLIT = "`";
	private static final int LIMIT = 3;

	private int score = 0;
	private int total = 0;

	public void play() {
		Questions questions = new Questions();
		shuffle(questions.data);
		this.total = questions.data.length;

		for (int i = 0; i < questions.data.length; i++) {
			Data data = new Data();
			setQnA(questions.data[i], data);
			quiz(i + 1, data);
		}
		printScore(score, this.total);
	}

	void shuffle(String[] data) {
		int randomIndex;
		for (int i = 0; i < data.length; i++) {
			randomIndex = (int)(Math.random() * data.length);

			String temp = data[i];
			data[i] = data[randomIndex];
			data[randomIndex] = temp;
		}
	}

	private void setQnA(String str, Data data) {
		String[] temp = str.split(SPLIT, LIMIT);

		data.question = temp[0];
		data.answer = temp[1];
		data.choices = temp[2].split(SPLIT);
		data.answer = data.choices[Integer.parseInt(data.answer) - 1];

		shuffle(data.choices);
	}

	private void quiz(int number, Data data) {
		printQuestion(number, data.question);
		printChoices(data.choices);
		printAnswerWait();

		String input = getInput();
		setSpace();

		scoring(input, data);
	}

	private String getInput() {
		return new Scanner(System.in).nextLine();
	}

	private void setSpace() {
		System.out.println();
		System.out.println();
	}

	private void scoring(String input, Data data) {
		if (data.choices[Integer.parseInt(input) - 1].equals(data.answer)) {
			this.score++;
		}
	}
}

