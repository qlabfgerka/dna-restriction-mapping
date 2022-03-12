package inc.premzl.Lists;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ListOperations {
    public static boolean listEquals(List<Integer> first, List<Integer> second) {
        if (first.size() != second.size()) return false;
        Collections.sort(first);
        Collections.sort(second);
        for (int i = 0; i < first.size(); i++) {
            if (!Objects.equals(first.get(i), second.get(i))) return false;
        }
        return true;
    }

    public static boolean listContains(List<Integer> first, List<Integer> second) {
        for (Integer num : second) {
            if (!first.contains(num)) return false;
        }
        return true;
    }

    public static void removeFromList(List<Integer> first, List<Integer> second) {
        for (Integer item : second) first.remove(item);
    }

    public static void printListOfLists(List<List<Integer>> list) {
        System.out.printf("%s", listOfListsToString(list));
    }

    public static String listToString(List<Integer> list) {
        return list.stream().
                map(Object::toString).
                collect(Collectors.joining(", "));
    }

    public static String listOfListsToString(List<List<Integer>> list) {
        StringBuilder result = new StringBuilder();
        for (List<Integer> sublist : list) result.append(listToString(sublist)).append("\n");
        return result.toString();
    }
}
