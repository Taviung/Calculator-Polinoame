package org.example.Business_Logic;

import java.util.HashMap;
import java.util.Map;

public class Sub
{
    public static Map<Integer,Double> SubOfMaps(Map<Integer,Double> map1, Map<Integer,Double> map2) {
        Map<Integer,Double> result = new HashMap<>();

        for (Map.Entry<Integer, Double> entry : map1.entrySet()) {
            int degree = entry.getKey();
            Double coefficient = entry.getValue();
            result.put(degree, coefficient);
        }

        for (Map.Entry<Integer, Double> entry : map2.entrySet()) {
            int degree = entry.getKey();
            Double coefficient = entry.getValue();

            if (result.containsKey(degree)) {
                Double currentCoefficient = result.get(degree);
                //result.monomials.put(degree, currentCoefficient.doubleValue() - coefficient.doubleValue());
                double sub = currentCoefficient.doubleValue() - coefficient.doubleValue();

                if (degree == 0) result.put(0, sub);
                else result.put(degree, sub);
            } else result.put(degree, -coefficient);
        }

        return result;
    }
}