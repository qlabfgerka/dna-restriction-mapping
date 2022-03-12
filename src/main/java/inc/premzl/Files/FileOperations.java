package inc.premzl.Files;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileOperations {
    public static String readFile(String path) throws IOException {
        return Files.readString(Path.of(path));
    }

    public static void writeToFile(Path path, String content) throws IOException {
        Files.writeString(path,
                content,
                StandardCharsets.UTF_16,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING);
    }
}
