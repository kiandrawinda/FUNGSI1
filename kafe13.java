package fungsi1;

import java.util.Scanner;

public class kafe13 {

    public static void Menu(String namaPelanggan, boolean isMember) {
        System.out.println("Selamat datang, " + namaPelanggan + "!");
        if (isMember) {
            System.out.println("Anda adalah member, dapatkan diskon 10% untuk setiap pembelian!");
        }
        System.out.println("===== MENU RESTO KAFE =====");
        System.out.println("1. Kopi Hitam - Rp 15,000");
        System.out.println("2. Cappuccino - Rp 20,000");
        System.out.println("3. Latte - Rp 22,000");
        System.out.println("4. Teh Tarik - Rp 12,000");
        System.out.println("5. Roti Bakar - Rp 10,000");
        System.out.println("6. Mie Goreng - Rp 18,000");
        System.out.println("===========================");
        System.out.println("Silakan pilih menu yang Anda inginkan.");
    }

    public static int hitungTotalHargaNoAbsen(int pilihanMenu, int banyakItem) {
        int[] hargaItems = {15000, 20000, 22000, 12000, 10000, 18000};
        int hargaTotal = hargaItems[pilihanMenu - 1] * banyakItem;
        return hargaTotal;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu("Andi", true);

        int totalKeseluruhan = 0;
        char pesanLagi;

        do {
            System.out.print("\nMasukkan nomor menu yang ingin Anda pesan: ");
            int pilihanMenu = sc.nextInt();

            if (pilihanMenu < 1 || pilihanMenu > 6) {
                System.out.println("Menu tidak tersedia");
                pesanLagi = 'y';
                continue;
            }

            System.out.print("Masukkan jumlah item yang ingin dipesan: ");
            int banyakItem = sc.nextInt();

            totalKeseluruhan += hitungTotalHargaNoAbsen(pilihanMenu, banyakItem);

            System.out.print("Pesan menu lain (y/n)? ");
            pesanLagi = sc.next().charAt(0);
        } while (pesanLagi == 'y' || pesanLagi == 'Y');

        System.out.println("Total keseluruhan pesanan Anda: Rp" + totalKeseluruhan);
        sc.close();
    }
}