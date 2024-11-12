package Calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;
        char operator = ' ';
        ArrayList<Character> operatorList = new ArrayList<>();
        Collections.addAll(operatorList,'+', '-', '*', '/');

        // 반복 로직
        while (true) {

            // 첫번째 숫자 입력
            try {
                System.out.print("첫번째 숫자: ");
                num1 = input.nextInt();
            } catch(InputMismatchException e) {
                System.out.println("숫자만 적어.");
                input.next();
                continue;
            }



            // 두번째 숫자 입력
            try {
                System.out.print("두번째 숫자: ");
                num2 = input.nextInt();
            } catch(InputMismatchException e) {
                System.out.println("숫자만 적어.");
                input.next();
                continue;
            }

            // 기호 입력
            System.out.println("뭘로 계산할꺼야(+,-,*,/): ");
            String operatorCheck = input.next();
            if (operatorList.contains(operatorCheck.charAt(0))) {
                operator = operatorCheck.charAt(0);
            } else {
                System.out.println("연산기호만 입력해(+,-,*,/)");
                continue;
            }

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
                    result = (double) num1 / num2;
                }
            } else {
                System.out.println("기호를 잘못 적었어.");
            }

            // 결과 출력
            System.out.println(num1 + " " + operator + " " + num2 + " = " + result);

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


