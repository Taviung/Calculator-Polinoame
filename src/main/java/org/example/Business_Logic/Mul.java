package org.example.Business_Logic;

import java.util.HashMap;
import java.util.Map;

public class Mul {
    public static Map<Integer, Double> MulOfMaps(Map<Integer, Double> map1, Map<Integer, Double> map2) {
        Map<Integer, Double> result = new HashMap<>();

        for (Map.Entry<Integer, Double> entry : map1.entrySet()) {
            for (Map.Entry<Integer, Double> entry2 : map2.entrySet()) {

                int newKey = entry.getKey() + entry2.getKey();
                Double newCoef = entry.getValue() * entry2.getValue();

                if(result.containsKey(newKey)){

                    Double existingDouble = result.get(newKey);
                    Double existingCoefficient = existingDouble;
                    existingDouble = existingCoefficient + newCoef;
                    result.put(newKey,existingDouble);

                }else{
                    result.put(newKey,newCoef);
                }
            }
        }
        return result;
    }
}