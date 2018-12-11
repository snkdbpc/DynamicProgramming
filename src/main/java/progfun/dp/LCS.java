package progfun.dp;

public class LCS {

    public static void main(String[] args) {
        String str1 = "AGGTAB", str2 = "GXTXAYB";
        System.out.println(getLCSRec(str1, str2, str1.length(), str2.length()));
        System.out.println(getLCSDP(str1, str2));
    }

    private static int getLCSRec(String a, String b, int i, int j) {
        if (i == 0 || j == 0) {
            return 0;
        } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
            return 1 + getLCSRec(a, b, i - 1, j - 1);
        } else {
            return Math.max(getLCSRec(a, b, i - 1, j), getLCSRec(a, b, i, j - 1));
        }
    }

    private static int getLCSDP(String a, String b) {
        int[][] tab = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                if (i == 0 || j == 0) {
                    tab[i][j] = 0;
                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    tab[i][j] = 1 + tab[i - 1][j - 1];
                } else {
                    tab[i][j] = Math.max(tab[i - 1][j], tab[i][j - 1]);
                }
            }
        }
        return tab[a.length()][b.length()];
    }
}