package org.example.GUI;

import org.example.Data_Models.Monomial;
import org.example.Data_Models.Polynomial;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parsing {
    public static Polynomial parsing(String input) {

        int countX = 0;
        int countdegree = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'x') {
                countX++;
            } else if (input.charAt(i) == '^') {
                countdegree++;
            }
        }
        if (input.matches("[x^0-9+\\-.]+") && countX == countdegree) {
            Polynomial Polynom = new Polynomial();

            Pattern pattern1 = Pattern.compile("([+\\-])?(\\d+)(x(\\^\\d+)?)?");
            Matcher matcher1 = pattern1.matcher(input);

            while (matcher1.find()) {
                String semn = matcher1.group(1);
                String coefficientStr = matcher1.group(2);
                String powerStr = matcher1.group(4);

                int coefficient = 1;
                if (coefficientStr != null && !coefficientStr.isEmpty()) coefficient = Integer.parseInt(coefficientStr);

                if (semn != null && semn.equals("-")) coefficient *= -1;

                int power = 0;
                if (powerStr != null && !powerStr.isEmpty()) {
                    power = Integer.parseInt(powerStr.substring(1));
                }

                Monomial monom = new Monomial(power, coefficient);
                Polynom.addMonomial(monom);
            }

            return Polynom;
        }
        return null;
    }
}
