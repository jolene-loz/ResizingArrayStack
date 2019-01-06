public class RationalC{

    private int numerator, denominator;

    private int gcd(int m, int n) {
        if (n == 0)
            return m;
        else
            return gcd(n, m % n);
    }

    public RationalC(int numerator, int denominator) {
        int g = gcd(numerator, denominator);
        this.numerator = numerator / g;
        this.denominator = denominator / g;
    }

    public int getNumerator() { return this.numerator; }
    public int getDenominator() { return this.denominator; }
    
    public String toString() {
        int
            num = this.getNumerator(),
            den = this.getDenominator();
        
        return String.format("%d/%d", num, den);
    }

    public boolean equal(RationalC other) {
        return this.getNumerator() == other.getNumerator() &&
               this.getDenominator() == other.getDenominator();
    }
    
    public RationalC plus(RationalC other) {

        int thisN = this.getNumerator(),
            thisD = this.getDenominator(),
            otherN = other.getNumerator(),
            otherD = other.getDenominator(),

            numerator   = thisN * otherD + otherN * thisD,
            denominator = thisD * otherD;
        
        return new RationalC(numerator, denominator);
    }
    
    public RationalC subtract(RationalC other) { return this; }
    public RationalC multiply(RationalC other) { return this; }
    public RationalC divide(RationalC other) { return this; }
    public int compareTo(RationalC other) { return 0; }

    public static void main(String[] args) {

        RationalC
            r1 = new RationalC(3, 9),
            r2 = new RationalC(2, 10),
            r3 = r1.subtract(r2);
        
        System.out.format("%s + %s = %s\n", r1, r2, r3);
    }
}