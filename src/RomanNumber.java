import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RomanNumber extends Numb {

    public RomanNumber (String number) {
        this.number = toArabic(number);
        this.type = "roman";
    }

    private int toArabic(String number) {

        if (!number.matches("^(X|IX|IV|V?I{0,3})?$")) {
            throw new RuntimeException("Неизвестное число или больше 10");
        }

        List<String> list = new ArrayList<>();
        Roman [] roman = Roman.values();
        Matcher matcher = Pattern.compile("(X|IX|IV|V|I)").matcher(number);
        while (matcher.find()) {
            list.add(number.substring(matcher.start(), matcher.end()));
        }
        int sum = 0;
        for (String s : list) {
            for (Roman val : roman) {
                if (s.equals(val.name())) {
                    sum += val.value;
                }
            }
        }
        return sum;
    }

    private String toRoman(int number) {
        if (number < 1) {
            throw new RuntimeException("Римские числа не могут быть отрицательными или 0");
        }
        Roman [] roman = Roman.values();
        String result = "";
        int i = 0;
        while (number != 0) {
            if (number - roman[i].value < 0) {
                i++;
            } else {
                number = number - roman[i].value;
                result += roman[i].name();
            }
        }
        return result;
    }

    @Override
    public String toString(int number) {
        return toRoman(number);
    }
}
