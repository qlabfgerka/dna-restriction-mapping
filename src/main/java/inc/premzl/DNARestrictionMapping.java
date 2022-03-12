package inc.premzl;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static inc.premzl.DNA.Reconstruction.bruteForce;
import static inc.premzl.DNA.Reconstruction.partialDigest;
import static inc.premzl.DNA.RestrictionCut.*;
import static inc.premzl.Files.FileOperations.readFile;
import static inc.premzl.Files.FileOperations.writeToFile;
import static inc.premzl.Lists.ListOperations.listOfListsToString;
import static inc.premzl.Lists.ListOperations.printListOfLists;

public class DNARestrictionMapping {
    public static void main(String[] args) throws Exception {
        if (args.length < 4) throw new Exception("Invalid arguments size");
        String file = readFile(args[0]);
        List<Integer> multiset = findMultiset(handleIndexes(Arrays.copyOfRange(args, 3, args.length), file));
        List<List<Integer>> list;

        if (Objects.equals(args[1], "b")) {
            list = bruteForce(multiset, calculateSize(multiset.size()));
            printListOfLists(list);
        } else if (Objects.equals(args[1], "bnb")) {
            list = partialDigest(multiset);
            printListOfLists(list);
        } else if (Objects.equals(args[1], "bTest") || Objects.equals(args[1], "bnbTest")) {
            System.out.println(calculateSize(multiset.size()) - 2);
            long avgTime = 0, start, end;
            int iterations = 10000;
            for (int i = 0; i < iterations; i++) {
                start = System.nanoTime();
                if (Objects.equals(args[1], "bTest")) bruteForce(multiset, calculateSize(multiset.size()));
                else partialDigest(multiset);
                end = System.nanoTime();
                avgTime += (end - start);
                multiset = findMultiset(handleIndexes(Arrays.copyOfRange(args, 3, args.length), file));
            }
            System.out.println((double) TimeUnit.MILLISECONDS.convert(avgTime, TimeUnit.NANOSECONDS) / iterations);
            return;
        } else throw new Exception("Invalid algorithm argument");

        if (Objects.equals(args[2], "y")) {
            writeToFile(Path.of("assets\\output\\out.txt"), listOfListsToString(list));
        }
    }
}
