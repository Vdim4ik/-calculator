abstract class Numb {
    int number;
    String type;

    public String add(Numb other) { return toString(number + other.number); }
    public String sub(Numb other) { return toString(number - other.number); }
    public String mul(Numb other) { return toString(number * other.number); }
    public String div(Numb other) { return toString(number / other.number); }

    public abstract String toString(int number);
}
