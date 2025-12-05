package com.enolj.calculator;

public enum OperatorType {
    PLUS,
    MINUS,
    MULTIPLY,
    DIVIDE;

    public static OperatorType from(String operator) {
        return switch (operator) {
            case "+" -> PLUS;
            case "-" -> MINUS;
            case "x" -> MULTIPLY;
            case "/" -> DIVIDE;
            default -> throw new IllegalArgumentException();
        };
    }
}
