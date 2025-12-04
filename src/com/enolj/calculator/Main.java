package com.enolj.calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int firstNum = scanner.nextInt();
            if (firstNum < 0) {
                throw new InputMismatchException();
            }
            System.out.print("두 번째 숫자를 입력하세요: ");
            int secondNum = scanner.nextInt();
            if (secondNum < 0) {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("올바른 숫자를 입력해 주세요.");
            scanner.nextLine();
        }
    }
}
