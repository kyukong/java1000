import java.util.*;

class WordScrambleEx2 {
    public static void main(String[] args) {
        String[] strArr = { "CHANGE", "LOVE", "HOPE", "VIEW"};

        String answer = getAnswer(strArr);
        String question = getScrambledWord(answer);

        while (true) {
            System.out.println("Question :" + question);
            System.out.print("Your answer is :");

            Scanner scanner = new Scanner(System.in);
            String userAnswer = scanner.nextLine();

            if (userAnswer.toUpperCase().equals("Q")) {
                System.out.println("게임을 종료하였습니다.");
                break;
            }

            if (userAnswer.toUpperCase().equals(answer)) {
                System.out.println("정답입니다.");
                break;
            } else {
                System.out.println(userAnswer + "은/는 정답이 아닙니다. 다시 시도해보세요.");
            }

        }

    }

    private static String getAnswer(String[] strArr) {
        int idx = (int)(Math.random()*strArr.length);
        return strArr[idx];
    }

    private static String getScrambledWord(String str) {
        char[] chArr = str.toCharArray();

        for(int i=0;i<str.length();i++) {
            int idx = (int)(Math.random()*str.length());

            char tmp = chArr[i];
            chArr[i] = chArr[idx];
            chArr[idx] = tmp;
        }

        return new String(chArr);
    }
}