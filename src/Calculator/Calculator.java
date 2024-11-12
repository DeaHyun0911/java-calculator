package Calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("첫번째 숫자: ");
        int num1 = input.nextInt();

        System.out.print("두번째 숫자: ");
        int num2 = input.nextInt();

        System.out.println("뭘로 계산할꺼야(+,-,*,/): ");
        char operator = input.next().charAt(0);

        double result = 0;

        if(operator == '+') {
            result = num1 + num2;
        } else if (operator == '-') {
            result = num1 - num2;
        } else if (operator == '*') {
            result = num1 * num2;
        } else if (operator == '/') {
            result = num1 / num2;
        } else {
            System.out.println("잘못 입력하였습니다.");
        }

        System.out.print(num1 + " " + operator + " " + num2 + " = " + result);


    }

}
