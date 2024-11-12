package classCalculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Calculator calculator = new Calculator();
        char operator;

        while(true) {

                // 첫번째 계산
                if(calculator.getListEmpty()) {
                    System.out.print("첫번째 숫자 입력: ");
                    int num1 = input.nextInt();
                    System.out.print("두번째 숫자 입력: ");
                    int num2 = input.nextInt();
                    System.out.print("연산기호: ");
                    operator = input.next().charAt(0);

                    calculator.calculate(num1, num2, operator);
                    calculator.getResult();
                } else {

                // 재시작 체크
                System.out.println("[ 메뉴를 선택하세요 (번호 입력) ]");
                System.out.println("1. 계속 계산 2. 리셋하기 3. 리스트 조회 4. 종료하기");
                System.out.print("메뉴 선택: ");
                int menu = input.nextInt();

                if (menu == 1) {
                    System.out.print("숫자 입력: ");
                    int num = input.nextInt();

                    System.out.print("연산기호: ");
                    operator = input.next().charAt(0);

                    calculator.calculate(calculator.getCurrentNumber(), num, operator);
                    calculator.getResult();
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
}
