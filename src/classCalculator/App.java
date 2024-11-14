package classCalculator;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        boolean isRun = true; // 실행여부
        long runCount = 0;
        Scanner input = new Scanner(System.in);
        Calculator<Double> calculator = new Calculator(); // Calculator 인스턴스 생성


        // 전체 계산기 반복
        while(isRun && runCount < 10000) {
            // 첫번째 계산
            if(calculator.getListEmpty()) {

                NumberInput(input,"첫번째 숫자 입력: ", calculator::setFirstNum);
                NumberInput(input,"두번째 숫자 입력: ", calculator::setSecondNum);
                operationInput(input, calculator);
                calculator.firstNumberRemove();

            } else {

                // 메뉴 보여주기
                System.out.println("--------------------------------------------");
                System.out.println("메뉴를 선택하세요(번호 입력)");
                System.out.println("1. 계속 계산 2. 리셋하기 3. 리스트 조회 4.첫번째 기록 제거 5. 종료하기");
                System.out.println("--------------------------------------------");

                System.out.print("메뉴 선택: ");
                String menu = input.next();

                Menu selectMenu = null;

                switch (menu) {
                    case "1": selectMenu = Menu.CONTINUE; break;
                    case "2": selectMenu = Menu.RESET; break;
                    case "3": selectMenu = Menu.LIST; break;
                    case "4": selectMenu = Menu.REMOVE; break;
                    case "5": selectMenu = Menu.EXIT; break;
                    default:
                    System.out.println("숫자 1~5 중에 입력하세요.");
                    continue;
                }

                switch (selectMenu) {
                    case Menu.CONTINUE:
                        NumberInput(input,"두번째 숫자 입력: ", calculator::setSecondNum);
                        operationInput(input, calculator);
                        break;
                    case Menu.RESET:
                        calculator.setResetList();
                        System.out.println("리셋되었습니다.");
                        break;
                    case Menu.LIST:
                        String list = calculator.getList();
                        System.out.println("저장된 기록: " + list);
                        break;
                    case Menu.REMOVE:
                        calculator.firstNumberRemove();
                        System.out.println("기록이 없습니다. 처음부터 계산합니다.");
                        break;
                    case Menu.EXIT:
                        System.out.println("계산기를 종료합니다.");
                        isRun = false;
                }
            }
            runCount++;
        }

    }

    private static final String OPERATION_REG = "[+\\-*/]";
    private static final String NUMBER_REG = "^[0-9]*$";



    // 함수형 인터페이스를 활용한 메서드 병합
    public static void NumberInput(Scanner input, String text, Interface numMethod) {
        try {
            System.out.print(text);
            String numInput = input.next();
            if (!Pattern.matches(NUMBER_REG, numInput)) {
                throw new InputMismatchException("숫자가 아니예요.");
            }
            Double num = Double.parseDouble(numInput);
            numMethod.setInput(num);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            NumberInput(input, text, numMethod);
        }
    }

    // 연산 기호 입력 및 결과 출력
    public static void operationInput(Scanner input, Calculator<Double> calculator) {
        try {
            System.out.print("연산기호: ");
            String operInput = input.next();
            if (!Pattern.matches(OPERATION_REG, operInput)) {
                throw new InputMismatchException("숫자가 아니예요.");
            }
            char operator = operInput.charAt(0);

            Oper oper = charToOper(operator);

            calculator.calculate(oper);
            System.out.println("--------------------------------------------");
            System.out.println("결과 : " +calculator.getCurrentNumber());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            operationInput(input, calculator);
        }
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

    interface Interface {
        void setInput(Double number);
    }


}
