package com.enolj.calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int firstNum = inputInt(scanner, "첫 번째 숫자를 입력하세요: ");
            int secondNum = inputInt(scanner, "두 번째 숫자를 입력해주세요: ");
            String operator = inputOperator(scanner, "사칙연산 기호를 입력하세요: ");

            try {
                int result = calculate(firstNum, secondNum, operator);
                System.out.println("결과: " + result);
            }  catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("exit")) {
                break;
            }
        }
    }

    public static int inputInt(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                int num = scanner.nextInt();
                if (num < 0) {
                    throw new InputMismatchException();
                }
                return num;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("올바른 숫자를 입력해 주세요.");
                scanner.nextLine();
            }
        }
    }

    public static String inputOperator(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                String operator = scanner.next();
                if (!(operator.equals("+") || operator.equals("-") || operator.equals("x") || operator.equals("/"))) {
                    throw new InputMismatchException();
                }
                return operator;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("올바른 연산기호를 입력해 주세요.");
            }
        }
    }

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
