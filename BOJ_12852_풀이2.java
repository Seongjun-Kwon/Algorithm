import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1]; // dp[i] = k -> i를 1로 만드는 최소 연산 횟수는 k회이다.
        int[] root = new int[n + 1]; // root[i] = k -> i는 연산 후 k이다.

        dp[1] = 0;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + 1;
            root[i] = i - 1;

            if (i % 3 == 0) {
                if (dp[i] > dp[i / 3] + 1) {
                    dp[i] = dp[i / 3] + 1;
                    root[i] = i / 3;
                }
            }

            if (i % 2 == 0) {
                if (dp[i] > dp[i / 2] + 1) {
                    dp[i] = dp[i / 2] + 1;
                    root[i] = i / 2;
                }
            }
        }

        sb.append(dp[n]).append('\n');
        for (int i = n; i != 0; i = root[i]) {
            sb.append(i).append(' ');
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}
