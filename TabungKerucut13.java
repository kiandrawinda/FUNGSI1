package fungsi1;

import java.util.Scanner;

public class TabungKerucut13 {

    public static double luasLingkaran(double r) {
        return Math.PI * r * r;
    }

    public static double volumeTabung(double r, double t) {
        return luasLingkaran(r) * t;
    }

    public static double luasPermukaanTabung(double r, double t) {
        return 2 * luasLingkaran(r) + (2 * Math.PI * r * t);
    }

    public static double volumeKerucut(double r, double t) {
        return volumeTabung(r, t) / 3.0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilih;

        do {
            System.out.println("\n1. Luas Lingkaran");
            System.out.println("2. Volume Tabung");
            System.out.println("3. Luas Permukaan Tabung");
            System.out.println("4. Volume Kerucut");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilih = sc.nextInt();

            if (pilih == 1) {
                System.out.print("r: ");
                double r = sc.nextDouble();
                System.out.println("Hasil: " + luasLingkaran(r));
            } else if (pilih == 2) {
                System.out.print("r: ");
                double r = sc.nextDouble();
                System.out.print("t: ");
                double t = sc.nextDouble();
                System.out.println("Hasil: " + volumeTabung(r, t));
            } else if (pilih == 3) {
                System.out.print("r: ");
                double r = sc.nextDouble();
                System.out.print("t: ");
                double t = sc.nextDouble();
                System.out.println("Hasil: " + luasPermukaanTabung(r, t));
            } else if (pilih == 4) {
                System.out.print("r: ");
                double r = sc.nextDouble();
                System.out.print("t: ");
                double t = sc.nextDouble();
                System.out.println("Hasil: " + volumeKerucut(r, t));
            }
        } while (pilih != 0);

        sc.close();
    }
}