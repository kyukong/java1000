import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import java.io.*;

class ConsoleEx4 {
    static String[] argArr;                         // 입력한 매개변수를 담기위한 문자열배열
    static LinkedList<String> q = new LinkedList<String>(); // 사용자가 입력한 내용을 저장할 큐(Queue)
    static final int MAX_SIZE = 5;              // Queue에 최대 5개까지만 저장되도록 한다.

    static File curDir;                         // 현재 디렉토리

    static {
        curDir = new File(System.getProperty("user.dir"));
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in); // 한번만 생성해서 재사용하면 되므로 반복문 밖으로 이동

        while(true) {
            try {
                String prompt = curDir.getCanonicalPath() + ">> ";
                System.out.print(prompt);

                String input = s.nextLine();

                save(input);

                input = input.trim();          // 입력받은 값에서 불필요한 앞뒤 공백을 제거한다.
                argArr = input.split("\\s+");


                String command = argArr[0].trim();

                if("".equals(command)) continue;

                command = command.toLowerCase(); // 명령어를 소문자로 바꾼다.

                if(command.equals("q")) { // q 또는 Q를 입력하면 실행종료한다.
                    System.exit(0);
                } else if(command.equals("history")) {
                    history();
                } else {
                    for(int i=0; i < argArr.length;i++) {
                        System.out.println(argArr[i]);
                    }
                }
            } catch(Exception e) {
                System.out.println("입력오류입니다.");
            }
        }
    }


    public static void save(String input) {
        if(input==null || "".equals(input)) return;

        q.add(input);
        if (q.size() > MAX_SIZE) {
            q.remove();
        }
    }

    public static void history() {
        int i=0;

        ListIterator it = q.listIterator();

        while (it.hasNext()) {
            System.out.println(++i + "." + it.next());
        }
    }
}