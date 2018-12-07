package progfun.dp;

public class FiboDP {

    public static void main(String... args) {

        int n = Integer.parseInt(args[0]);
        int[] list = new int[n];
        System.out.println(getNFib(n, list));

    }

    private static int getNFib(int n, int[] list) {
        if (n <= 2) {
            return 1;
        } else if (list[n - 1] != 0) {
            return list[n - 1];
        } else {
            list[n - 1] = getNFib(n - 1, list) + getNFib(n - 2, list);
            return list[n - 1];
        }
    }
}
