package com.enolj.calculator;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Calculator {

    private List<String> history = new ArrayList<>();

    public static int calculate(int firstNum, int secondNum, String operator) {
        int result = 0;
        result = switch (operator) {
            case "+" -> firstNum + secondNum;
            case "-" -> firstNum - secondNum;
            case "x" -> firstNum * secondNum;
            case "/" -> {
                if (secondNum == 0) {
                    throw new InputMismatchException("분모를 0으로 나눌 수 없습니다.");
                }
                yield firstNum / secondNum;
            }
            default -> result;
        };
        return result;
    }
}
