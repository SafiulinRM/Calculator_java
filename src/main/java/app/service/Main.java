package app.service;

import java.util.Scanner;

import static app.service.NumberService.findResult;
import static app.service.NumberService.validationOperation;
import static app.service.RomeNumberMapper.romeNumbers;
import static app.service.RomeNumberMapper.toArabicOperation;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }

    public static String calc(String input) {
        String[] values = input.split(" ");
        try {
            validationOperation(values);
            return String.valueOf(findResult(values[1]));
        } catch (NumberFormatException e) {
            validationOperation(toArabicOperation(values));
            if (findResult(values[1]) < 1) {
                throw new RuntimeException("Результатом работы калькулятора с римскими числами " +
                        "могут быть только положительные числа");
            }
            return romeNumbers[findResult(values[1])];
        }
    }
}
