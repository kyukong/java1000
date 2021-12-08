public class WordScrambleEx1 {

    public static void main(String[] args) {
        String[] strArr = { "CHANGE", "LOVE", "HOPE", "VIEW"};

        String answer = getAnswer(strArr);
        String question = getScrambledWord(answer);

        System.out.println("Question:"+question);
        System.out.println("Answer:"+answer);
    }

    private static String getAnswer(String[] strArr) {
        int randomIndex = getRandomNum(0, strArr.length - 1);
        return strArr[randomIndex];
    }

    private static String getScrambledWord(String str) {
        char[] wordArr = str.toCharArray();
        return new String(shuffle(wordArr));
    }

    private static int getRandomNum(int minNum, int maxNum) {
        return (int)(Math.random() * (maxNum - minNum + 1)) + minNum;
    }

    private static char[] shuffle(char[] arr) {
        int randomIndex;
        char tempChar;

        for (int i = 0; i < arr.length; i++) {
            randomIndex = getRandomNum(0, arr.length - 1);

            tempChar = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex] = tempChar;
        }

        return arr;
    }
}