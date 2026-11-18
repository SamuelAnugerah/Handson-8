import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class WriteUserInput {

    public static void main(String[] args) {

        Path path = Paths.get("user_input.txt");

        try (
            Scanner sc = new Scanner(System.in);
            BufferedWriter bw = Files.newBufferedWriter(path)
        ) {

            System.out.println("Masukkan teks (ketik exit untuk selesai):");

            while (true) {

                System.out.print("Input: ");
                String text = sc.nextLine();

                if (text.equalsIgnoreCase("exit")) {
                    break;
                }

                String timestamp = LocalDateTime.now().toString();

                bw.write(timestamp + " - " + text);
                bw.newLine();
            }

            System.out.println("Data berhasil disimpan!");

        } catch (IOException e) {

            System.out.println("Terjadi kesalahan: " +
                    e.getMessage());
        }
    }
}