package classCalculator;

import java.util.InputMismatchException;
import java.util.Stack;

public class Calculator<T extends Number> {

    // 숫자 필드
    private T firstNumber = (T) Double.valueOf(0);
    public T secondNumber;

    // 결과 저장 콜렉션
    private Stack<T> resultStack = new Stack<T>();

    // 연산 메서드
    public Stack<T> calculate(Oper operator) {

        // 최근 계산된 값을 첫번째 숫자로 변경
        firstNumber = getCurrentNumber();

        T result = null;
        switch (operator) {
            case ADD:
                result = (T) Double.valueOf(firstNumber.doubleValue() + secondNumber.doubleValue());
                break;
            case SUBTRACT:
                result = (T) Double.valueOf(firstNumber.doubleValue() - secondNumber.doubleValue());
                break;
            case MULTI:
                result = (T) Double.valueOf(firstNumber.doubleValue() * secondNumber.doubleValue());
                break;
            case DIVIDE:
                if (secondNumber.doubleValue() == 0) {
                    throw new InputMismatchException("0으로 나눌 수 없습니다.");
                } else {
                    result = (T) Double.valueOf(firstNumber.doubleValue() / secondNumber.doubleValue());
                }
                break;
        }

        resultStack.add(result);
        firstNumber = result;
        return resultStack;
    }

    // 첫번째 숫자 정의
    public void setFirstNum(T firstNumber) {
        this.firstNumber = firstNumber;
        resultStack.add(firstNumber);
    }

    // 두번째 숫자 정의
    public void setSecondNum(T secondNumber) {
        this.secondNumber = secondNumber;
    }

    // 최근 값 내보내기
    public T getCurrentNumber() {
        return getListEmpty() ? (T) Double.valueOf(0) : resultStack.peek();
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

    // 첫번재 숫자 제거
    public void firstNumberRemove() {
        resultStack.remove(0);
    }

    interface NumberType<T> {
        Double test(T t);
    }
}
