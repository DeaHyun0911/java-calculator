package classCalculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Calculator<Double> calculator = new Calculator();


        while(true) {

                // 첫번째 계산
                if(calculator.getListEmpty()) {
                    System.out.print("첫번째 숫자 입력: ");
                    Double num1 = input.nextDouble();
                    System.out.print("두번째 숫자 입력: ");
                    Double num2 = input.nextDouble();
                    System.out.print("연산기호: ");
                    char operator = input.next().charAt(0);

                    Oper oper = charToOper(operator);

                    calculator.calculate(num1, num2, oper);
                    System.out.println("결과 :" +calculator.getCurrentNumber());
                } else {

                // 재시작 체크
                System.out.println("[ 메뉴를 선택하세요 (번호 입력) ]");
                System.out.println("1. 계속 계산 2. 리셋하기 3. 리스트 조회 4. 종료하기");
                System.out.print("메뉴 선택: ");
                int menu = input.nextInt();

                if (menu == 1) {
                    System.out.print("숫자 입력: ");
                    Double num = input.nextDouble();

                    System.out.print("연산기호: ");
                    char operator = input.next().charAt(0);

                    Oper oper = charToOper(operator);

                    calculator.calculate(calculator.getCurrentNumber(), num, oper);
                    System.out.println("결과 :" +calculator.getCurrentNumber());
                } else if (menu == 2) {
                    calculator.setResetList();
                } else if (menu == 3) {
                    String list = calculator.getList();
                    System.out.println(list);
                } else if (menu == 4) {
                    break;
                }
            }

        }

    }

    public static Oper charToOper(char operator) {
        switch (operator) {
            case '+':
                return Oper.ADD;
            case '-':
                return Oper.SUBTRACT;
            case '*':
                return Oper.MULTI;
            case '/':
                return Oper.DIVIDE;
            default:
                throw new InputMismatchException("잘못된 연산 기호입니다");
        }
    }
}
