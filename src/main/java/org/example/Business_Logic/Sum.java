package org.example.Business_Logic;

import java.util.*;

public class Sum {
    @SafeVarargs
    public static Map<Integer, Double> SumOfMaps(Map<Integer, Double>... maps) {
        final Map<Integer, Double> resultMap = new HashMap<>();
        for (final Map<Integer, Double> map : maps) {
            for (final Integer key : map.keySet()) {
                final double value;
                if (resultMap.containsKey(key)) {
                    final double existingValue = resultMap.get(key);
                    value = map.get(key) + existingValue;
                }
                else {
                    value = map.get(key);
                }
                resultMap.put(key, value);
            }
        }
        return resultMap;
    }
}