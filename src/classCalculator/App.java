package classCalculator;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Calculator<Double> calculator = new Calculator(); // Calculator 인스턴스 생성

        // 전체 계산기 반복
        while(true) {
                // 첫번째 계산
                if(calculator.getListEmpty()) {
                    while(true) {
                        try {
                            firstInput(input, calculator);
                            break;
                        } catch(Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    while(true) {
                        try {
                            secondInput(input, calculator);
                            break;
                        } catch(Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    calculator.firstNumberRemove();
                } else {

                // 메뉴 보여주기
                System.out.println("[ 메뉴를 선택하세요 (번호 입력) ]");
                System.out.println("1. 계속 계산 2. 리셋하기 3. 리스트 조회 4. 종료하기");
                System.out.print("메뉴 선택: ");
                int menu = input.nextInt();

                if (menu == 1) {
                    while(true) {
                        try {
                            secondInput(input, calculator);
                            break;
                        } catch(Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
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

    private static final String OPERATION_REG = "[+\\-*/]";
    private static final String NUMBER_REG = "^[0-9]*$";

    // 첫번째 숫자 입력
    public static void firstInput(Scanner input, Calculator<Double> calculator) throws Exception {
        System.out.print("첫번째 숫자 입력: ");
        String numInput = input.next();
        if (!Pattern.matches(NUMBER_REG, numInput)) {
            throw new InputMismatchException("숫자가 아니예요.");
        }
        Double num1 = Double.parseDouble(numInput);
        calculator.setFirstNum(num1);
    }

    // 두번째 숫자 입력 및 결과 보여주기 메서드
    public static void secondInput(Scanner input, Calculator<Double> calculator) throws Exception {

        System.out.print("두번째 숫자 입력: ");
        String numInput = input.next();
        if (!Pattern.matches(NUMBER_REG, numInput)) {
            throw new InputMismatchException("숫자가 아니예요.");
        }
        Double num2 = Double.parseDouble(numInput);
        calculator.setSecondNum(num2);

        System.out.print("연산기호: ");
        String operInput = input.next();
        if (!Pattern.matches(OPERATION_REG, operInput)) {
            throw new InputMismatchException("숫자가 아니예요.");
        }
        char operator = operInput.charAt(0);

        Oper oper = charToOper(operator);

        calculator.calculate(oper);
        System.out.println("결과 :" +calculator.getCurrentNumber());
    }

    // Char로 받은 데이터를 Enum 타입으로 변환
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
