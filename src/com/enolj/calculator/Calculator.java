package com.enolj.calculator;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator<T extends Number> {

    private List<T> history = new ArrayList<>();

    public double calculate(T firstNum, T secondNum, OperatorType operatorType) {
        double result = 0;
        double x = firstNum.doubleValue();
        double y = secondNum.doubleValue();

        result = switch (operatorType) {
            case PLUS -> x + y;
            case MINUS -> x - y;
            case MULTIPLY -> x * y;
            case DIVIDE -> {
                if (y == 0) {
                    throw new InputMismatchException("분모를 0으로 나눌 수 없습니다.");
                }
                yield x / y;
            }
        };
        return result;
    }

    public void addHistory(T history) {
        this.history.add(history);
    }

    public List<T> getHistory() {
        return history;
    }

    public void removeHistory(int i) {
        this.history.remove(i);
    }

    public List<Double> findGreaterThan(Double number) {
        return history.stream()
                .map(Number::doubleValue)
                .filter(x -> x > number)
                .collect(Collectors.toList());
    }
}
