import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FilesExample {

    private static final String FILE_DIRECTORY = "files";
    private static final String FILE_NAME_1 = "file1";
    private static final String FILE_NAME_2 = "file2";
    private static final String FILE_NAME_3 = "file3";


    public static void main(String[] args) throws IOException {
        final String classPath = System.getProperty("java.class.path");

        Path path = Paths.get("/home");
        Path anotherPath = Paths.get("documents");
        Path newPath = path.resolve(anotherPath);
        System.out.println(newPath);

        // Create directory and empty files
        final Path workingDirectory = Files.createDirectory(Paths.get(classPath).resolve(FILE_DIRECTORY));
        final Path file1 = Files.createFile(workingDirectory.resolve(FILE_NAME_1));
        final Path file2 = Files.createFile(workingDirectory.resolve(FILE_NAME_2));

        // Check if file path is a regular file and if directory path is directory
        System.out.println("File " + FILE_NAME_1 + " is file: " + Files.isRegularFile(file1));
        System.out.println("File " + FILE_DIRECTORY + " is file: " + Files.isDirectory(workingDirectory));


        // Write lines to a file
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(file1)) {
            bufferedWriter.write("First line");
            bufferedWriter.newLine();
            bufferedWriter.write("Second line");
            bufferedWriter.newLine();
            bufferedWriter.write("Third line");
        }

        // Read all lines from a file
        List<String> lines = Files.readAllLines(file1);

        System.out.println(FILE_NAME_1 + " lines:");
        for (String line : lines) {
            System.out.println(line);
        }

        // Write files content char by char to another file
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(file2)) {
            try (BufferedReader bufferedReader = Files.newBufferedReader(file1)) {
                for (int c; (c = bufferedReader.read()) != -1; ) {
                    bufferedWriter.write(c);
                }
            }
        }

        // Read files content by line (Used for big files)
        try (BufferedReader reader = Files.newBufferedReader(file2)) {
            System.out.println(FILE_NAME_2 + " lines:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }

        // Copies file content to another file
        final Path file3 = Files.copy(file1, workingDirectory.resolve(FILE_NAME_3));

        System.out.println(FILE_NAME_3 + " lines:");
        for (String line : lines) {
            System.out.println(line);
        }

        // Prints files size
        System.out.println(FILE_NAME_3 + " size:");
        System.out.println(Files.size(file3));

        // Deletes file
        Files.delete(file1);
        Files.delete(file2);
        Files.delete(file3);
        Files.delete(workingDirectory);

        // Checks if file deleted successfully
        System.out.println(FILE_NAME_1 + "exists: " + Files.exists(file1));
    }

}
