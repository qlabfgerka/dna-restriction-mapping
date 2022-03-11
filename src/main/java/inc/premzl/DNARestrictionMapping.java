package inc.premzl;

import java.io.IOException;
import java.util.List;

import static inc.premzl.DNA.RestrictionCut.handleIndexes;
import static inc.premzl.Files.FileOperations.readFile;

public class DNARestrictionMapping {
    public static void main(String[] args) throws IOException {
        String file = readFile(args[0]);
        List<Integer> indexes = handleIndexes(args, file);

        for (Integer index : indexes) {
            System.out.print(index + ", ");
        }
        System.out.println();
    }
}
