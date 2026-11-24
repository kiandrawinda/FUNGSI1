package fungsi1;

public class HitungBalok13 {

    static int hitungLuas(int pjg, int lb) {
        return pjg * lb;
    }

    static int hitungVolume(int tinggi, int a, int b) {
        return hitungLuas(a, b) * tinggi;
    }

    static int hitungLuasPermukaanBalok(int p, int l, int t) {
        return 2 * (hitungLuas(p, l) + hitungLuas(p, t) + hitungLuas(l, t));
    }

    public static void main(String[] args) {
        int[][] balok = {
            {4, 3, 5},
            {6, 2, 4},
            {8, 4, 3}
        };

        for (int i = 0; i < balok.length; i++) {
            int p = balok[i][0];
            int l = balok[i][1];
            int t = balok[i][2];
            System.out.println("Balok " + (i + 1)
                    + " -> Luas Permukaan: " + hitungLuasPermukaanBalok(p, l, t)
                    + ", Volume: " + hitungVolume(t, p, l));
        }
    }
}