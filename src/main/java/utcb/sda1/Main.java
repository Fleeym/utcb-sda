package utcb.sda1;

import java.util.Stack;

/**
 * APLICAȚIE: Să se evalueze o expresie complet parantezată, știind că:
 * - toți termenii sunt numere întregi
 * - fiecare operator se aplică numai la doi termeni.
 * - De exemplu, expresia complet parantezată:
 * (((23+5)/4)+2)*((38-2)/12) va fi evaluată la 27.
 * - Evaluarea expresiei presupune folosirea a două stive, una de numere si cealalta de operatori
 */

public class Main {
    public static void main(String[] args) {
        String expression = "(((23+5)/4)+2)*((38-2)/12)";

        // Stergem toate spatiile, inclusiv \n, \t
        expression = expression.replaceAll("\\s+","");

        float result = evaluateExpression(expression);
        System.out.printf("Rezultatul pentru expresia %s este: %f\n", expression, result);
    }

    public static float evaluateExpression(String evaluateExpression) {
        char[] characters = evaluateExpression.toCharArray();

        Stack<Character> operators = new Stack<>();
        Stack<Float> numbers = new Stack<>();
        StringBuilder sb = new StringBuilder();

        // Iterăm prin fiecare caracter și adaugăm operatorii și parantezele în stiva de operatori
        // Pentru a adăuga în stiva de numere construim un string pe care îl schimbăm în float după
        for (char character : characters) {
            switch (character) {
                case '+':
                case '-':
                case '/':
                case '*':
                case '(':
                    if (!sb.isEmpty()) {
                        numbers.push(Float.valueOf(sb.toString()));
                        sb.delete(0, sb.length());
                    }
                    operators.push(character);
                    break;
                case ')':
                    if (!sb.isEmpty()) {
                        numbers.push(Float.valueOf(sb.toString()));
                        sb.delete(0, sb.length());
                    }
                    float num2 = numbers.pop();
                    float num1 = numbers.pop();
                    char operator = operators.pop();
                    float calculated = calculatePair(num1, num2, operator);
                    numbers.push(calculated);
                    // Scoatem '(' din stivă
                    operators.pop();
                    break;
                default:
                    sb.append(character);
                    break;
            }
        }

        if (!operators.isEmpty() && numbers.size() == 2) {
            float num2 = numbers.pop();
            float num1 = numbers.pop();
            char operator = operators.pop();
            return calculatePair(num1, num2, operator);
        }

        return numbers.pop();
    }

    public static float calculatePair(float num1, float num2, char operator) {
        return switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            default -> throw new RuntimeException("Invalid Operator");
        };
    }
}