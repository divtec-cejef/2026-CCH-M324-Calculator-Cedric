package ch.divtec;

import java.util.Scanner;

public class Calculator {

    static int add(double a, double b) {
        throw new UnsupportedOperationException("Method not yet implemented.");
    }

    static int subtract(double a, double b) {
        throw new UnsupportedOperationException("Method not yet implemented.");
    }

    static int multiply(double a, double b) {
        throw new UnsupportedOperationException("Method not yet implemented.");
    }

    static double divide(double a, double b) {
        throw new UnsupportedOperationException("Method not yet implemented.");
    }

    static int factorial(double n) {
        throw new UnsupportedOperationException("Method not yet implemented.");
    }

    public static void main(String[] args) {
        double num1, num2 = 0.;
        Scanner sc = new Scanner(System.in);

        System.out.println("Allowed operators: + - * / !");
        System.out.println("Enter the operation to compute :");

        num1 = sc.nextDouble();
        char operator = sc.next().charAt(0);
        if (operator != '!') {
            num2 = sc.nextDouble();
        }

        double result;
        switch (operator) {
            case '+':
                result = add(num1, num2);
                break;
            case '-':
                result = subtract(num1, num2);
                break;
            case '*':
                result = multiply(num1, num2);
                break;
            case '/':
                result = divide(num1, num2);
                break;
            case '!':
                result = factorial(num1);
                break;
            default:
                System.out.println("Invalid operator.");
                return;
        }
        System.out.println("The final result: " + num1 + " " + operator + " " + num2 + " = " + result);
    }
}
