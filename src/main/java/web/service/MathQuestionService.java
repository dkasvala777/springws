package web.service;

public class MathQuestionService {

    public static Double q1Addition(String number1, String number2) {
        try {
            return Double.valueOf(number1) + Double.valueOf(number2);
        } catch (NumberFormatException e) {
            return null; // Return null for invalid inputs
        }
    }

    public static Double q2Subtraction(String number1, String number2) {
        try {
            return Double.valueOf(number1) - Double.valueOf(number2);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Double q3Division(String number1, String number2) {
        try {
            return Double.valueOf(number1) / Double.valueOf(number2);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
