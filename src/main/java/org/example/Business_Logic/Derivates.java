package org.example.Business_Logic;
import java.util.HashMap;
import java.util.Map;

public class Derivates {
    public static Map<Integer, Double> DerivateOfMaps(Map<Integer,Double> map) {
        Map<Integer, Double> result = new HashMap<>();

        for (Map.Entry<Integer, Double> entry : map.entrySet()) {

            if(entry.getKey()!=0)
            {
                int newKey = entry.getKey()-1;
                double newValue = entry.getValue() * entry.getKey();
                result.put(newKey,newValue);
            }
        }
        return result;
    }
}
