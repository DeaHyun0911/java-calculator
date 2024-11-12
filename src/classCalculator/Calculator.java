package classCalculator;

import java.util.Stack;

public class Calculator {

    // 결과 저장 콜렉션
    private Stack<Integer> resultList = new Stack<Integer>();

    // 연산 메서드
    public Stack<Integer> calculate(int num1, int num2, char operator) {
        switch (operator) {
            case '+':
                resultList.add(num1 + num2);
                break;
            case '-':
                resultList.add(num1 - num2);
                break;
            case '*':
                resultList.add(num1 * num2);
                break;
            case '/':
                resultList.add(num1 / num2);
                break;
        }
        return resultList;
    }

    // 결과 출력 메서드
    public void getResult() {
        System.out.println(resultList.peek());
    }




}
