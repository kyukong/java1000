import java.util.Scanner;

class ConsoleEx1 {
    public static void main(String[] args) {
        while(true) {
            String prompt = ">> ";
            System.out.print(prompt);

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            System.out.println(input);

            if (input.equalsIgnoreCase("Q")) {
                break;
            }
        }
    }
}
