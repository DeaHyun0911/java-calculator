package Calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 반복 로직
        while (true) {

            // 첫번째 숫자 입력
            System.out.print("첫번째 숫자: ");
            int num1 = input.nextInt();

            // 두번째 숫자 입력
            System.out.print("두번째 숫자: ");
            int num2 = input.nextInt();

            // 기호 입력
            System.out.println("뭘로 계산할꺼야(+,-,*,/): ");
            char operator = input.next().charAt(0);

            // 결과 변수
            double result = 0;

            // 계산
            if(operator == '+') {
                result = num1 + num2;
            } else if (operator == '-') {
                result = num1 - num2;
            } else if (operator == '*') {
                result = num1 * num2;
            } else if (operator == '/') {
                if (num2 == 0) {
                    System.out.println("나눗셈 연산에서 분모에 0을 입력할 수 없어!");
                } else {
                    result = num1 / num2;
                }
            } else {
                System.out.println("기호를 잘못 적었어.");
            }

            System.out.println(num1 + " " + operator + " " + num2 + " = " + result);

            System.out.print("다시 계산할꺼야? (exit 입력시 종료): ");
            input.nextLine();
            String str = input.nextLine();
            if (str.equals("exit")) {
                break;
            }
        }
    }

}


