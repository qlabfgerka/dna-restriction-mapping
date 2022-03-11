package inc.premzl;

import java.io.IOException;
import java.util.List;

import static inc.premzl.DNA.RestrictionCut.*;
import static inc.premzl.Files.FileOperations.readFile;

public class DNARestrictionMapping {
    public static void main(String[] args) throws IOException {
        String file = readFile(args[0]);
        List<Integer> indexes = handleIndexes(args, file);
        List<Integer> multiset = findMultiset(indexes);

        for (Integer index : multiset) {
            System.out.print(index + ", ");
        }
        System.out.println();

        System.out.println(calculateSize(indexes.size()));
    }
}
