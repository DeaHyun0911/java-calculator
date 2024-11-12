package classCalculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while(true) {
            System.out.print("첫번째 숫자 입력: ");
            int num1 = input.nextInt();
            System.out.print("두번째 숫자 입력: ");
            int num2 = input.nextInt();
            System.out.print("연산기호: ");
            char operator = input.next().charAt(0);

            calculator.calculate(num1, num2, operator);

            calculator.getResult();

            // 재시작 체크
            System.out.print("다시 계산할꺼야? (exit 입력시 종료 / 아무거나 입력시 재시작): ");
            input.nextLine();
            String str = input.nextLine();
            if (str.equals("exit")) {
                break;
            }
        }




    }
}
