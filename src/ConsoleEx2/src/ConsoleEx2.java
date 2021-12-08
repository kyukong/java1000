import java.util.*;

class ConsoleEx2 {
    static String[] argArr;
    static final String ALL_SPACE = "\\s+";

    public static void main(String[] args) {
        while(true) {
            String prompt = ">> ";
            System.out.print(prompt);

            Scanner s = new Scanner(System.in);
            String input = s.nextLine().trim();

            argArr = input.split(ALL_SPACE);

            if(input.equalsIgnoreCase("Q")) {
                System.exit(0);
            } else {
                for(int i=0; i < argArr.length;i++) {
                    System.out.println(argArr[i]);
                }
            }
        }
    }
}