package classCalculator;

import java.util.Stack;

public class Calculator<T extends Number> {

    // 결과 저장 콜렉션
    private Stack<T> resultStack = new Stack<T>();

    // 연산 메서드
    public Stack<T> calculate(T num1, T num2, Oper operator) {
        T result = null;
        switch (operator) {
            case ADD:
                result = (T) Double.valueOf(num1.doubleValue() + num2.doubleValue());
                break;
            case SUBTRACT:
                result = (T) Double.valueOf(num1.doubleValue() - num2.doubleValue());
                break;
            case MULTI:
                result = (T) Double.valueOf(num1.doubleValue() * num2.doubleValue());
                break;
            case DIVIDE:
                result = (T) Double.valueOf(num1.doubleValue() / num2.doubleValue());
                break;
        }
        resultStack.add(result);
        return resultStack;
    }

    // 최근 값 내보내기
    public T getCurrentNumber() {
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
