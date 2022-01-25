import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];

        solve(1, 0);

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    static void solve(int num, int cnt) {
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(' ');
            }

            sb.append('\n');
            return;
        }

        for (int i = num; i < n + 1; i++) {
            arr[cnt] = i;
            solve(i, cnt + 1);
        }
    }
}
