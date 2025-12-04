package com.enolj.calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = 0;
        int secondNum = 0;
        try {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            firstNum = scanner.nextInt();
            if (firstNum < 0) {
                throw new InputMismatchException();
            }
            System.out.print("두 번째 숫자를 입력하세요: ");
            secondNum = scanner.nextInt();
            if (secondNum < 0) {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("올바른 숫자를 입력해 주세요.");
            scanner.nextLine();
        }

        String operator = "";
        try {
            System.out.print("사칙연산 기호를 입력하세요: ");
            operator = scanner.next();
            if (!(operator.equals("+") || operator.equals("-") || operator.equals("x") || operator.equals("/"))) {
                throw new InputMismatchException();
            }
        }  catch (InputMismatchException inputMismatchException) {
            System.out.println("올바른 연산기호를 입력해 주세요.");
        }

        int result = 0;
        try {
            result = switch (operator) {
                case "+" -> firstNum + secondNum;
                case "-" -> firstNum - secondNum;
                case "x" -> firstNum * secondNum;
                case "/" -> {
                    if (secondNum == 0) {
                        throw new InputMismatchException();
                    }
                    yield firstNum / secondNum;
                }
                default -> result;
            };
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("분모를 0으로 나눌 수 없습니다.");
        }

        System.out.println("결과: " + result);
    }
}
