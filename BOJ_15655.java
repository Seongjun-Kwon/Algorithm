import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static int n, m;
    static int[] input;
    static int[] ans;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        input = new int[n];
        ans = new int[m];
        vis = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);

        solve(0, 0);

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    static void solve(int idx, int cnt) {
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                sb.append(ans[i]).append(' ');
            }

            sb.append('\n');
            return;
        }

        for (int i = idx; i < n; i++) {
            if (vis[i]) {
                continue;
            }

            vis[i] = true;
            ans[cnt] = input[i];
            solve(i + 1, cnt + 1);
            vis[i] = false;
        }
    }
}
