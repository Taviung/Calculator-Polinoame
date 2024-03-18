package org.example.Business_Logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Div {

    public static ArrayList<Map<Integer,Double>> DivOfMaps(Map<Integer, Double> map1, Map<Integer, Double> map2) {
        if (map2.isEmpty()) {
            throw new IllegalArgumentException("map2 cannot be empty.");
        }
        Map<Integer, Double> q = new HashMap<>();
        Map<Integer, Double> r = new HashMap<>();
        Map<Integer, Double> d = new HashMap<>();
        Map<Integer, Double> t = new HashMap<>();
        Map<Integer, Double> aux = new HashMap<>();

        r.putAll(map1);
        d.putAll(map2);

        Integer mapr;
        mapr=maxkey(r);

        Integer mapd;
        mapd=maxkey(d);

       while (mapr >= mapd && !r.isEmpty())
        {
            int degree = mapr-mapd;
            double coefficient = r.getOrDefault(mapr,0.0)/d.get(mapd);

            t.put(degree, coefficient);
            q = Sum.SumOfMaps(q, t);
            mapr=maxkey(r);
            aux=Mul.MulOfMaps(t, d);
            r = Sub.SubOfMaps(r,aux);
            r.values().removeIf(f -> f == 0f);

        }
        ArrayList<Map<Integer,Double>> out=new ArrayList<>();
        out.add(q);
        out.add(r);
        return out;
    }
    public static<K, V extends Comparable<K>> Integer maxkey(Map<Integer, Double> map) {
        Map.Entry<Integer, Double> maxEntry = null;
        for (Map.Entry<Integer, Double> entry : map.entrySet()) {
            if (maxEntry == null || entry.getKey()
                    .compareTo((Integer) maxEntry.getKey()) > 0) {
                maxEntry = entry;
            }
        }
        return maxEntry.getKey();
    }
}
