import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }

    public static String calc (String input) {
        String result;
        String [] arrNum = input.split(" ");
        if (arrNum.length!= 3)
            throw new RuntimeException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        Numb x = getNumber(arrNum[0]);
        String operation = arrNum[1];
        Numb y = getNumber(arrNum[2]);
        if (!x.type.equals(y.type)) {
            throw new RuntimeException("Типы чисел разные");
        }
        if (x.number < 1 || x.number > 10 || y.number < 1 || y.number > 10) {
            throw new RuntimeException("Число меньше 1 или больше 10");
        }
        result = switch (operation) {
            case "+" -> x.add(y);
            case "-" -> x.sub(y);
            case "*" -> x.mul(y);
            case "/" -> x.div(y);
            default -> throw new RuntimeException("Неизвестный оператор");
        };
        return result;
    }

    private static Numb getNumber(String number) {
        Numb num;
        try {
            num = new ArabicNumber(number);
        } catch (NumberFormatException e) {
            num = new RomanNumber(number);
        }
        return num;
    }
}