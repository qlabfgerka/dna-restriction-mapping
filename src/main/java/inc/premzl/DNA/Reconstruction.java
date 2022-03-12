package inc.premzl.DNA;

import org.paukov.combinatorics3.Generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static inc.premzl.DNA.RestrictionCut.findMultiset;
import static inc.premzl.Lists.ListOperations.*;

public class Reconstruction {
    private static final List<List<Integer>> results = new ArrayList<>();

    public static List<List<Integer>> bruteForce(List<Integer> multiset, int n) {
        int M = multiset.get(multiset.size() - 1);

        return Generator
                .combination(IntStream.range(1, M).filter(multiset::contains).boxed().collect(Collectors.toList()))
                .simple(n - 2).stream()
                .filter(integers -> {
                    integers.add(0, 0);
                    integers.add(M);
                    return listEquals(findMultiset(integers), multiset);
                }).toList();
    }

    public static List<List<Integer>> partialDigest(List<Integer> multiset) {
        List<Integer> newSet = new ArrayList<>();
        int width = multiset.get(multiset.size() - 1);
        multiset.remove(Integer.valueOf(width));
        newSet.add(0);
        newSet.add(width);
        place(multiset, newSet, width);
        return results;
    }

    private static void place(List<Integer> multiset, List<Integer> newSet, int width) {
        Collections.sort(multiset);
        Collections.sort(newSet);

        if (multiset.isEmpty()) {
            results.add(List.copyOf(newSet));
            return;
        }

        int y = multiset.get(multiset.size() - 1);

        handlePlace(multiset, findMultiset(y, newSet), newSet, y, width);
        handlePlace(multiset, findMultiset(width - y, newSet), newSet, width - y, width);
    }

    private static void handlePlace(List<Integer> multiset, List<Integer> set, List<Integer> newSet, int y, int width) {
        if (listContains(multiset, set)) {
            newSet.add(y);
            removeFromList(multiset, set);
            place(multiset, newSet, width);
            newSet.remove(Integer.valueOf(y));
            multiset.addAll(set);
        }
    }
}
