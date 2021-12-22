import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static int n, m;
    static int[] arr;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        vis = new boolean[n];

        solve(0);

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    static void solve(int cnt) {
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(' ');
            }

            sb.append('\n');
            return;
        }

        for (int i = 0; i < n; i++) {
            if (vis[i]) {
                continue;
            }

            arr[cnt] = i + 1;
            vis[i] = true;
            solve(cnt + 1);
            vis[i] = false;
        }
    }
}
