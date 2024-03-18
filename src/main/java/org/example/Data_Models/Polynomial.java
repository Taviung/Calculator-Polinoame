package org.example.Data_Models;

import java.util.HashMap;
import java.util.Map;

public class Polynomial {
    protected Map<Integer, Double> map=new HashMap<>();

    public void addMonomial(Monomial monom){
        map.put(monom.degree,monom.coeficient);

    }

    public void setMap(Map<Integer, Double> map) {
        this.map = map;
    }

    public Map<Integer, Double> getMap() {
        return map;
    }

        public String printer() {
            StringBuilder polynomialString = new StringBuilder();
            for (Map.Entry<Integer, Double> entry : map.entrySet()) {
                int degree = entry.getKey();
                Double coefficient = entry.getValue();

                if (coefficient == 0) {
                    continue;
                }

                if (!polynomialString.isEmpty()) {
                    if(coefficient>0)
                        polynomialString.append("+");
                }

                if (coefficient != 1 || degree == 0) {
                    polynomialString.append(coefficient);
                }

                if (degree > 0) {
                    polynomialString.append("x");
                    if (degree != 1) {
                        polynomialString.append("^").append(degree);
                    }
                }
            }
            if (polynomialString.isEmpty()) {
                polynomialString.append("0");
            }
            return polynomialString.toString();
    }
}
