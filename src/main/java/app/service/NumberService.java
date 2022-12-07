package app.service;

class NumberService {
    private static int firstNumber;
    private static int secondNumber;

    protected static void validationOperation(String[] values) {
        if (values.length < 3) {
            throw new RuntimeException("Строка не является математической операцией");
        }
        if (values.length > 3) {
            throw new RuntimeException("формат математической операции не удовлетворяет заданию" +
                    " - два операнда и один оператор (+, -, /, *)");
        }
        firstNumber = Integer.parseInt(values[0]);
        secondNumber = Integer.parseInt(values[2]);
        if (firstNumber < 0 || firstNumber > 11 || secondNumber > 11 || secondNumber < 0) {
            throw new RuntimeException("Калькулятор принимает на вход числа от 1 до 10 включительно");
        }
    }

    protected static int findResult(String operator) {
        int result;
        switch (operator) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                result = firstNumber / secondNumber;
                break;
            default:
                throw new RuntimeException("Неправильный математический оператор");
        }
        return result;
    }
}
