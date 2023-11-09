import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get(System.getProperty("user.home")+System.getProperty("file.separator") + "Documents\\REPOS");
        //Path path = Paths.get(System.getProperty("user.home"));
        List<Path> paths = listFiles(path);
        paths.forEach(x -> System.out.println(x));

    }

    // list all files from this path
    public static List<Path> listFiles(Path path) throws IOException {

        List<Path> result;
        try (Stream<Path> walk = Files.walk(path, 3)) {
            result = walk.filter(Files::isRegularFile)
                    .collect(Collectors.toList());
        }
        return result;

    }
}