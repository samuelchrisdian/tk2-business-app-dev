import java.util.Scanner;

public class KonversiBiner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String biner;
        boolean inputValid;

        do {
            // Input angka biner
            System.out.print("Input angka biner (maksimal 8 digit): ");
            biner = scanner.nextLine();

            // Cek panjang angka biner
            if (biner.length() > 8) {
                System.out.println("Digit kelebihan. Masukkan angka biner maksimal 8 digit.");
                inputValid = false;
            } else {
                inputValid = true;
            }

            // Cek karakter angka biner
            if (!isBinerValid(biner)) {
                System.out.println("Input tidak valid. Harap masukkan angka biner yang valid.");
                inputValid = false;
            }

        } while (!inputValid);

        // Konversi angka biner ke desimal
        int desimal = binerToDesimal(biner);

        // Output hasil
        System.out.println("Angka desimal dari biner " + biner + " adalah: " + desimal);

        scanner.close();
    }

    // Method untuk mengonversi angka biner ke desimal
    private static int binerToDesimal(String biner) {
        int desimal = 0;
        int panjang = biner.length();

        for (int i = 0; i < panjang; i++) {
            char digit = biner.charAt(i);
            if (digit == '1') {
                desimal += Math.pow(2, panjang - 1 - i);
            }
        }

        return desimal;
    }

    // Method untuk memeriksa apakah angka biner valid
    private static boolean isBinerValid(String biner) {
        for (char digit : biner.toCharArray()) {
            if (digit != '0' && digit != '1') {
                return false;
            }
        }
        return true;
    }
}
