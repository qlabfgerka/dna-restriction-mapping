package inc.premzl.DNA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RestrictionCut {
    public static List<Integer> findIndexes(String haystack, String needle) {
        List<Integer> indexes = new ArrayList<>();
        int index = 0;

        while (true) {
            index = haystack.indexOf(needle, index);

            if (index == -1) break;

            indexes.add(index);
            ++index;
        }

        return indexes;
    }

    public static List<Integer> handleIndexes(String[] args, String file) {
        List<Integer> indexes = new ArrayList<>();

        for (int i = 1; i < args.length; i++) {
            indexes.addAll(findIndexes(file, args[i]));
        }

        indexes.add(0);
        indexes.add(file.length() - 1);
        Collections.sort(indexes);

        return indexes;
    }

    public static List<Integer> findMultiset(List<Integer> indexes) {
        List<Integer> multiset = new ArrayList<>();

        for (int i = 0; i < indexes.size(); i++) {
            for (int j = i + 1; j < indexes.size(); j++) {
                multiset.add(indexes.get(j) - indexes.get(i));
            }
        }

        Collections.sort(multiset);

        return multiset;
    }
}
