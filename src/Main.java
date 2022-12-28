import java.util.Scanner;

public class Main {

    public static void main(String[] arguments) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String exp = scn.nextLine();
        String newExp = exp.replaceAll(" ", "");
        System.out.println(calc(newExp));
    }

    public static String calc(String input) {


        char[] chars = new char[10];


        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};
        int actionIndex = -1;
        int count = 0;

        for (int i = 0; i < input.length(); i++) {

            chars[i] = input.charAt(i);
            if (chars[i] == '+' || chars[i] == '-' || chars[i] == '*' || chars[i] == '/') {
                count += 1;
            }
            if (count >= 2) {
                return "Слишком много операторов, выбери только одну операцию";
            }
        }
        for (int i = 0; i < actions.length; i++) {
            if (input.contains(actions[i])) {
                actionIndex = i;
                break;
            }
        }

        if (actionIndex == -1) {
            return "Некорректное выражение, можно использовать только + - / *";

        }


        String[] data = input.split(regexActions[actionIndex]);

        int a, b;

        if (data[0].matches("(?i)1|2|3|4|5|6|7|8|9|10") && data[1].matches("(?i)1|2|3|4|5|6|7|8|9|10")) {

            a = Integer.parseInt(data[0]);
            b = Integer.parseInt(data[1]);
        } else {
            return "Значения должны быть в диапазоне 1..10";
        }

        int result = switch (actions[actionIndex]) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> a / b;
        };
        System.out.println(result);
        return "завершение операции";
    }
}



