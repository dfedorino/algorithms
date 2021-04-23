package com.dfedorino.rtasks.second_level;

import lombok.Value;

public class Fractions {
    public Fraction reduce(Fraction fraction) {
//        int gcd = new GreatestCommonDivisor().find(fraction.getNumerator(), fraction.getDenominator());
        int gcd, a = fraction.getNumerator(), b = fraction.getDenominator();
        while (b != 0) {
            int aValue = a;
            a = b;
            b = aValue % b;
        }
        gcd = a;
        return new Fraction(fraction.getNumerator() / gcd, fraction.getDenominator() / gcd);
    }
}

@Value
class Fraction {
    int numerator;
    int denominator;
}
