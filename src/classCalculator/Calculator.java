package classCalculator;

import java.util.Stack;

public class Calculator {

    // 결과 저장 콜렉션
    private Stack<Integer> resultStack = new Stack<Integer>();

    // 연산 메서드
    public Stack<Integer> calculate(int num1, int num2, char operator) {
        switch (operator) {
            case '+':
                resultStack.add(num1 + num2);
                break;
            case '-':
                resultStack.add(num1 - num2);
                break;
            case '*':
                resultStack.add(num1 * num2);
                break;
            case '/':
                resultStack.add(num1 / num2);
                break;
        }
        return resultStack;
    }

    // 결과 출력 메서드
    public void getResult() {
        System.out.println(resultStack.peek());
    }

    // 최근 값 내보내기
    public int getCurrentNumber() {
        return resultStack.peek();
    }

    // 리스트 리셋
    public void setResetList() {
        resultStack.clear();
        System.out.println("리셋되었습니다.");
    }

    // 리스트가 비었는지 확인
    public boolean getListEmpty() {
        return resultStack.isEmpty();
    }

    // 리스트 조회
    public String getList() {
        return resultStack.toString();
    }
}
