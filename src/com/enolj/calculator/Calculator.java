package com.enolj.calculator;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Calculator {

    private List<Integer> history = new ArrayList<>();

    public int calculate(int firstNum, int secondNum, OperatorType operatorType) {
        int result = 0;
        result = switch (operatorType) {
            case PLUS -> firstNum + secondNum;
            case MINUS -> firstNum - secondNum;
            case MULTIPLY -> firstNum * secondNum;
            case DIVIDE -> {
                if (secondNum == 0) {
                    throw new InputMismatchException("분모를 0으로 나눌 수 없습니다.");
                }
                yield firstNum / secondNum;
            }
            default -> result;
        };
        return result;
    }

    public void addHistory(Integer history) {
        this.history.add(history);
    }

    public List<Integer> getHistory() {
        return history;
    }

    public void removeHistory(int i) {
        this.history.remove(i);
    }
}
