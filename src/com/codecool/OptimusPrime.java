package com.codecool;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptimusPrime {

    public List<Integer> getPrimesUpUntil(int n){
        List<Integer> consecutive = Stream
                .iterate(2, x -> x +1)
                .limit(n - 1)
                .collect(Collectors.toList());
        List<Integer> marked = new ArrayList<>();

        int idx = 0;
        int current = consecutive.get(idx);
        while(current < n){
            marked.addAll(getMarked(consecutive, idx, current));
            current = consecutive.get(++idx);
        }
        consecutive.removeAll(marked);

        return consecutive;
    }

    private List<Integer> getMarked(List<Integer> list, int start, int step){
        List<Integer> toRemove = new ArrayList<>();
        for (int i = start + step; i < list.size(); i += step) {
            toRemove.add(list.get(i));
        }
        return toRemove;
    }
}
