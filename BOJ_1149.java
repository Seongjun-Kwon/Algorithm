import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, ans;
    static int[][] cost;
    static int[][] dp; // dp[i][j] = i번째 집을 j색으로 칠했을 때 모든 비용의 최솟값(j-> 0=빨, 1=초, 2=파)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        ans = Integer.MAX_VALUE;
        cost = new int[n][3];
        dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 3; i++) {
            dp[0][i] = cost[0][i];
        }

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
        }

        for (int i = 0; i < 3; i++) {
            if (dp[n - 1][i] < ans) {
                ans = dp[n - 1][i];
            }
        }

        bw.write(Integer.toString(ans));
        br.close();
        bw.flush();
        bw.close();
    }
}
