import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        String str = "";
        Stack<String> stacks = new Stack<>();
        while (choice != 3) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập câu\n" +
                    "2. Đảo ngược câu\n" +
                    "3. Thoát\n" +
                    "Nhập lựa chọn của bạn :");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.println("Nhập 1 câu bất kỳ :");
                    str = scanner.nextLine();
                    String trim = str.trim();
                    String[] s = trim.split(" ");
                    for (int i = 0; i < s.length; i++) {
                        stacks.add(s[i]);
                    }
                    break;
                case 2:
                    System.out.println("Câu trước khi được đảo ngược là : [ " + str + " ]");
                    System.out.print("Câu đảo ngược là : [ ");
                    scanner.nextLine();
                    while (!stacks.empty()) {

                        System.out.print(stacks.pop() + " ");
                    }
                    System.out.print("]");
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
                    System.out.println("Đang thoát chương trình...");
                    break;
                default:
                    break;
            }
        }
    }
}
