class ArabicNumber extends Numb{
    public ArabicNumber (String number) {
        this.number = Integer.parseInt(number);
        this.type = "arabic";
    }

    public String toString(int nuber) {
        return Integer.toString(nuber);
    }
}
