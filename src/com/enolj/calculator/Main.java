package com.enolj.calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("1. 계산하기");
            System.out.println("2. 연산 결과 이력 보기");
            System.out.println("3. 첫 번째 연산 결과 삭제");
            System.out.println("4. 종료");
            int num = inputInt(scanner, "입력: ");

            switch (num) {
                case 1:
                    int firstNum = inputInt(scanner, "첫 번째 숫자를 입력하세요: ");
                    int secondNum = inputInt(scanner, "두 번째 숫자를 입력해주세요: ");
                    OperatorType operator = inputOperator(scanner, "사칙연산 기호를 입력하세요: ");
                    try {
                        int result = calculator.calculate(firstNum, secondNum, operator);
                        calculator.addHistory(result);
                        System.out.println("결과: " + result);
                    }  catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println(calculator.getHistory());
                    break;
                case 3:
                    calculator.removeHistory(0);
                    System.out.println("첫 번째 연산 결과를 삭제했습니다.");
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("메뉴를 다시 선택해 주세요");
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

    public static OperatorType inputOperator(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                String operator = scanner.next();
                return OperatorType.from(operator);
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println("올바른 연산기호를 입력해 주세요.");
            }
        }
    }
}
