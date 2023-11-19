package exercise;

import java.util.concurrent.CompletableFuture;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

class App {

    // BEGIN
    private static Path getFullPath(String filePath) {
        return Paths.get(filePath).toAbsolutePath().normalize();
    }

    public static CompletableFuture<String> unionFiles(String pathOne, String pathTwo, String pathResult) {
        Path normalizedPath1 = Paths.get(pathOne).toAbsolutePath().normalize();
        Path normalizedPath2 = Paths.get(pathTwo).toAbsolutePath().normalize();
        Path normalizedResultPath = Paths.get(pathResult).toAbsolutePath().normalize();

        CompletableFuture<byte[]> data1 = CompletableFuture.supplyAsync(() -> {
            byte[] result;
            try {
                result = Files.readAllBytes(normalizedPath1);
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
            return result;
        });
        CompletableFuture<byte[]> data2 = CompletableFuture.supplyAsync(() -> {
            byte[] result;
            try {
                result = Files.readAllBytes(normalizedPath2);
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
            return result;
        });
        return data1.thenCombine(data2, (String1, String2) -> {
            try {
                Files.write(normalizedResultPath, String1, StandardOpenOption.CREATE);
                Files.write(normalizedResultPath, String2, StandardOpenOption.APPEND);
                return "Successfully combined and written to file";
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }).exceptionally(ex -> {
            System.out.println("Oops! We have an exception - " + ex.getMessage());
            return null;
        });

    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        
        // END
    }
}

