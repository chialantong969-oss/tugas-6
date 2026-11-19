import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class handsontugas2 {
    public static void main(String[] args) {
        Path sourcePath = Paths.get("employees.txt");
        Path destPath = Paths.get("copy_employees.txt");

        if (Files.notExists(sourcePath)) {
            System.out.println("Galat: File " + sourcePath + " tidak ditemukan!");
            return;
        }

        List<String> employeeList = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(sourcePath, StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null) {
                employeeList.add(line);
            }

            System.out.println("Isi file employees.txt:");
            employeeList.forEach(System.out::println);

            Files.write(destPath, employeeList, StandardCharsets.UTF_8);
            System.out.println("Data berhasil disalin ke " + destPath);

        } catch (IOException e) {
            System.out.println("Terjadi galat I/O: " + e.getMessage());
        }
    }
}