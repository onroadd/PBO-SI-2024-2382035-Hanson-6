import java.util.Scanner;

 public class Tugas {
    public static void tampilkanMenu() {
        System.out.println("Pilih bangun datar:");
        System.out.println("1. Persegi");
        System.out.println("2. Persegi Panjang");
        System.out.println("3. Lingkaran");
        System.out.println("4. Keluar");
        System.out.print("Masukkan pilihan Anda: ");
    }

    public static class BangunDatar {

        public static void luasKelilingPersegi(double sisi) {
            double luas = sisi * sisi;
            double keliling = 4 * sisi;
            System.out.println("Luas persegi: " + luas);
            System.out.println("Keliling persegi: " + keliling);
        }

        public static void luasKelilingPersegiPanjang(double panjang, double lebar) {
            double luas = panjang * lebar;
            double keliling = 2 * (panjang + lebar);
            System.out.println("Luas persegi panjang: " + luas);
            System.out.println("Keliling persegi panjang: " + keliling);
        }

        public static void luasKelilingLingkaran(double jariJari) {
            double luas = Math.PI * jariJari * jariJari;
            double keliling = 2 * Math.PI * jariJari;
            System.out.println("Luas lingkaran: " + luas);
            System.out.println("Keliling lingkaran: " + keliling);
        }
    }

    public static double inputAngka(Scanner scanner, String prompt) {
        double input = -1;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print(prompt);
                input = Double.parseDouble(scanner.nextLine());
                if (input > 0) {
                    valid = true;
                } else {
                    System.out.println("Masukkan angka yang lebih besar dari 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Silakan masukkan angka.");
            }
        }
        return input;
    }

    public static void prosesPilihan(int pilihan, Scanner scanner) {
        switch (pilihan) {
            case 1:
                double sisi = inputAngka(scanner, "Masukkan sisi persegi: ");
                BangunDatar.luasKelilingPersegi(sisi);
                break;
            case 2:
                double panjang = inputAngka(scanner, "Masukkan panjang persegi panjang: ");
                double lebar = inputAngka(scanner, "Masukkan lebar persegi panjang: ");
                BangunDatar.luasKelilingPersegiPanjang(panjang, lebar);
                break;
            case 3:
                double jariJari = inputAngka(scanner, "Masukkan jari-jari lingkaran: ");
                BangunDatar.luasKelilingLingkaran(jariJari);
                break;
            case 4:
                System.out.println("Terima kasih telah menggunakan program ini.");
                System.exit(0);  // Keluar dari program
                break;
            default:
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            tampilkanMenu();
            try {
                pilihan = Integer.parseInt(scanner.nextLine());
                prosesPilihan(pilihan, scanner);
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Silakan masukkan angka.");
                pilihan = -1; // Set to an invalid option to loop again
            }
            System.out.println(); // Spasi antara operasi
        } while (pilihan != 4); // Loop sampai pengguna memilih keluar

        scanner.close();
    }
}

