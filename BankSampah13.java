package fungsi1;

import java.util.Scanner;

public class BankSampah13 {

    public static double[] inputSetoran(int n, Scanner sc) {
        double[] setoran = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Berat setoran nasabah ke-" + (i + 1) + " (kg): ");
            setoran[i] = sc.nextDouble();
        }
        return setoran;
    }

    public static void tampilSetoran(double[] setoran) {
        System.out.println("\nData Setoran:");
        for (int i = 0; i < setoran.length; i++) {
            System.out.println("Nasabah ke-" + (i + 1) + ": " + setoran[i] + " kg");
        }
    }

    public static double totalSetoran(double[] setoran) {
        double total = 0;
        for (double s : setoran) {
            total += s;
        }
        return total;
    }

    public static double hitungSaldo(double berat, double hargaPerKg) {
        return berat * hargaPerKg;
    }

    public static int nasabahTerbanyak(double[] setoran) {
        int idxMax = 0;
        for (int i = 1; i < setoran.length; i++) {
            if (setoran[i] > setoran[idxMax]) {
                idxMax = i;
            }
        }
        return idxMax;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double hargaPerKg = 3000.0;

        System.out.print("Masukkan jumlah nasabah (N): ");
        int n = sc.nextInt();

        double[] setoran = inputSetoran(n, sc);
        tampilSetoran(setoran);

        System.out.println("\nSaldo Nasabah:");
        for (int i = 0; i < setoran.length; i++) {
            System.out.printf("Nasabah ke-%d: Rp%.0f%n", (i + 1), hitungSaldo(setoran[i], hargaPerKg));
        }

        System.out.println("\nTotal setoran: " + totalSetoran(setoran) + " kg");
        int idxMax = nasabahTerbanyak(setoran);
        System.out.println("Nasabah setoran terbanyak: Nasabah ke-" + (idxMax + 1));

        sc.close();
    }
}