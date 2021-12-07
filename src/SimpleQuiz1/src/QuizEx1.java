class QuizEx1 {
    public static void main(String[] args) {
        final String SPLIT = "`";
        final int LIMIT = 3;

        String[] data = {
            "다음 중 키워드가 아닌 것은?`2`final`True`if`public",
            "다음 중 자바의 연산자가 아닌 것은?`5`&`|`++`!=`/`^",
            "다음 중 메서드의 반환값이 없음을 의미하는 키워드는?`1`void`null`false",
        };

        String question = "";
        String correctAnswer = "";
        String answer = "";

        for (int i = 0; i < data.length; i++) {
            String[] temp = data[i].split(SPLIT, LIMIT);
            question = temp[0];
            correctAnswer = temp[1];
            answer = temp[2];

            System.out.println(question);

            String[] answers = answer.split(SPLIT);

            for (int j = 0; j < answers.length; j++) {
                int number = j + 1;
                System.out.print(number + "." + answers[j] + " ");
            }
            System.out.println();
            System.out.println();
        }
    }
}