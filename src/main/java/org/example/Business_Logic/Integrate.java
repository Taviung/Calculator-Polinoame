package org.example.Business_Logic;

import java.util.HashMap;
import java.util.Map;

public class Integrate {

    public static Map<Integer, Double> IntegrateOfMaps(Map<Integer,Double>map) {
        Map<Integer, Double> result = new HashMap<>();

        for (Map.Entry<Integer, Double> entry : map.entrySet()) {
                int newKey = entry.getKey()+1;
                double newValue = entry.getValue() / (entry.getKey()+1);
                result.put(newKey,newValue);
        }
        return result;
    }
}
