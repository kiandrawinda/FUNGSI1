package fungsi1;

import java.util.Scanner;

public class RekapLaundry13 {

    public static void inputData(int[][] data, String[] layanan, String[] hari, Scanner sc) {
        for (int i = 0; i < layanan.length; i++) {
            System.out.println("Input berat untuk " + layanan[i] + ":");
            for (int j = 0; j < hari.length; j++) {
                System.out.print("  " + hari[j] + ": ");
                data[i][j] = sc.nextInt();
            }
        }
    }

    public static void tampilData(int[][] data, String[] layanan, int[] harga, String[] hari) {
        System.out.printf("%-16s %-10s", "Layanan", "Harga/kg");
        for (String h : hari) {
            System.out.printf(" %-10s", h);
        }
        System.out.println();

        for (int i = 0; i < layanan.length; i++) {
            System.out.printf("%-16s Rp%-8d", layanan[i], harga[i]);
            for (int j = 0; j < hari.length; j++) {
                System.out.printf(" %-10d", data[i][j]);
            }
            System.out.println();
        }
    }

    public static int totalPerLayanan(int[][] data, int idxLayanan) {
        int total = 0;
        for (int j = 0; j < data[idxLayanan].length; j++) {
            total += data[idxLayanan][j];
        }
        return total;
    }

    public static void layananTertinggi(int[][] data, String[] layanan) {
        int idxMax = 0;
        int max = totalPerLayanan(data, 0);
        for (int i = 1; i < layanan.length; i++) {
            int tot = totalPerLayanan(data, i);
            if (tot > max) {
                max = tot;
                idxMax = i;
            }
        }
        System.out.println("\nLayanan tertinggi: " + layanan[idxMax] + " (" + max + " kg)");
    }

    public static int hariTersibuk(int[][] data) {
        int idxMax = 0;
        int max = 0;
        for (int i = 0; i < data.length; i++) {
            max += data[i][0];
        }
        for (int j = 1; j < data[0].length; j++) {
            int tot = 0;
            for (int i = 0; i < data.length; i++) {
                tot += data[i][j];
            }
            if (tot > max) {
                max = tot;
                idxMax = j;
            }
        }
        return idxMax;
    }

    public static void hitungPendapatan(int[][] data, String[] layanan, int[] harga, int jumlahHari) {
        System.out.println("\nPendapatan per Layanan:");
        long totalSemua = 0;
        for (int i = 0; i < layanan.length; i++) {
            long pend = (long) totalPerLayanan(data, i) * harga[i];
            totalSemua += pend;
            System.out.println("- " + layanan[i] + ": Rp" + pend);
        }
        System.out.println("Total pendapatan selama " + jumlahHari + " hari: Rp" + totalSemua);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Jumlah layanan: ");
        int jmlLayanan = sc.nextInt();
        System.out.print("Jumlah hari: ");
        int jmlHari = sc.nextInt();
        sc.nextLine();

        String[] layanan = new String[jmlLayanan];
        int[] harga = new int[jmlLayanan];
        String[] hari = new String[jmlHari];
        int[][] data = new int[jmlLayanan][jmlHari];

        for (int i = 0; i < jmlLayanan; i++) {
            System.out.print("Nama layanan ke-" + (i + 1) + ": ");
            layanan[i] = sc.nextLine();
            System.out.print("Harga per kg: ");
            harga[i] = sc.nextInt();
            sc.nextLine();
        }

        for (int j = 0; j < jmlHari; j++) {
            hari[j] = "Hari ke-" + (j + 1);
        }

        inputData(data, layanan, hari, sc);
        tampilData(data, layanan, harga, hari);
        layananTertinggi(data, layanan);
        int idxSibuk = hariTersibuk(data);
        System.out.println("Hari tersibuk: " + hari[idxSibuk]);
        hitungPendapatan(data, layanan, harga, jmlHari);

        sc.close();
    }
}