import java.lang.Math;
import java.util.Scanner;

public class WordScrambleEx4_2 {

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}

class Game {
    static final String[] QUESTIONS = {"CHANGE", "LOVE", "HOPE", "VIEW"};
    static final char HIDDEN_HINT = '_';
    static final int HINT_LIMIT = 2;
    static final String QUIT_GAME = "q";

    static final String QUESTION_MESSAGE = "Question: ";
    static final String ANSWER_MESSAGE = "Your Answer is: ";
    static final String FAIL_MESSAGE = "은/는 정답이 아닙니다. 다시 시도해보세요.";
    static final String HINT_MESSAGE = "Hint: ";
    static final String CORRECT_MESSAGE = "정답입니다.";

    String answer;
    String question;
    char[] hint;
    Scanner scanner = new Scanner(System.in);

    Game() {
        this.answer = getAnswer();
        this.question = getScrambledWord(this.answer);
        hint = setHintInit();
    }

    public String toString() {
        return "Now Game Instance: " + this.answer + ", " + this.question + ", " + String.valueOf(this.hint);
    }

    String getAnswer() {
        int randomIndex = getRandomNumber(0, QUESTIONS.length);
        return QUESTIONS[randomIndex];
    }

    int getRandomNumber(int min, int max) {
        return (int)(Math.random() * (max - min)) + min;
    }

    String getScrambledWord(String answer) {
        char[] charArr = answer.toCharArray();
        int randomIndex;
        char temp;

        for (int i = 0; i < answer.length(); i++) {
            randomIndex = getRandomNumber(0, charArr.length);

            temp = charArr[i];
            charArr[i] = charArr[randomIndex];
            charArr[randomIndex] = temp;
        }

        return String.valueOf(charArr);
    }

    char[] setHintInit() {
        int wordLength = this.answer.length();
        char[] hint = new char[wordLength];
        for (int i = 0; i < wordLength; i++) {
            hint[i] = HIDDEN_HINT;
        }
        return hint;
    }

    void play() {
        showQuestion();
        String userAnswer = getUserAnswer();

        if (userAnswer.equalsIgnoreCase(QUIT_GAME)) {
            return;
        }

        boolean isCorrect = compareAnswer(this.answer, userAnswer);

        if (isCorrect) {
            System.out.println(CORRECT_MESSAGE);
            Game game = new Game();
            game.play();
            return;
        }

        System.out.println(userAnswer + FAIL_MESSAGE);
        setHint();
        showHint();
        this.play();
    }

    void showQuestion() {
        System.out.println(QUESTION_MESSAGE + this.question);
    }

    String getUserAnswer() {
        System.out.print(ANSWER_MESSAGE);
        return scanner.nextLine();
    }

    boolean compareAnswer(String answer, String userAnswer) {
        return answer.equalsIgnoreCase(userAnswer);
    }

    void setHint() {
        int hiddenHintCount = getHiddenHintCount();
        if (hiddenHintCount <= HINT_LIMIT) {
            return;
        }

        int randomIndex = getRandomNumber(0, this.hint.length - 1);
        while (this.hint[randomIndex] != HIDDEN_HINT) {
            randomIndex = getRandomNumber(0, this.hint.length - 1);
        }

        this.hint[randomIndex] = this.answer.charAt(randomIndex);
    }

    int getHiddenHintCount() {
        int count = 0;

        for (int i = 0; i < this.hint.length; i++) {
            if (this.hint[i] == HIDDEN_HINT) {
                count++;
            }
        }

        return count;
    }

    void showHint() {
        System.out.println(HINT_MESSAGE + String.valueOf(this.hint));
    }
}