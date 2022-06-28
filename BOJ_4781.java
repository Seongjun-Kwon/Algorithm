import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] dp; // dp[i] = j , i 원으로 구매할 수 있는 가장 높은 칼로리는 j 라는 의미

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken().replace(".", ""));
            dp = new int[m + 1];

            if (n == 0 && m == 0) {
                break;
            }

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken().replace(".", ""));

                for (int j = p; j < m + 1; j++) {
                    if (dp[j] < dp[j - p] + c) {
                        dp[j] = dp[j - p] + c;
                    }
                }
            }

            sb.append(dp[m]).append('\n');
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}
