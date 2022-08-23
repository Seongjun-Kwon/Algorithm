import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k;
    static long[][] dp;
    static boolean[][][] road;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        dp = new long[n + 1][m + 1];
        road = new boolean[n + 1][m + 1][2];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if (a > c || b > d) {
                if (a == c) {
                    road[a][b][0] = true;
                } else {
                    road[a][b][1] = true;
                }
            } else {
                if (a == c) {
                    road[c][d][0] = true;
                } else {
                    road[c][d][1] = true;
                }
            }
        }

        for (int i = 0; i < n + 1; i++) {
            if (road[i][0][1]) {
                break;
            }

            dp[i][0] = 1;
        }

        for (int j = 0; j < m + 1; j++) {
            if (road[0][j][0]) {
                break;
            }

            dp[0][j] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (!road[i][j][0]) {
                    dp[i][j] += dp[i][j - 1];
                }
                if (!road[i][j][1]) {
                    dp[i][j] += dp[i - 1][j];
                }
            }
        }

        bw.write(Long.toString(dp[n][m]));
        br.close();
        bw.flush();
        bw.close();
    }
}
