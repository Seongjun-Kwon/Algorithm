import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static int n;
    static int[] arr;
    static int[] cnt;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        cnt = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            cnt[i] = Integer.parseInt(st.nextToken());
        }

        solve(arr[0], 1);

        sb.append(max).append('\n').append(min);

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    static void solve(int result, int idx) {
        if (idx == n) {
            if (max < result) {
                max = result;
            }

            if (min > result) {
                min = result;
            }

            return;
        }

        for (int i = 0; i < 4; i++) {
            if (cnt[i] <= 0) {
                continue;
            }

            cnt[i]--;

            if (i == 0) { // 덧셈
                solve(result + arr[idx], idx + 1);
            } else if (i == 1) { // 뺄셈
                solve(result - arr[idx], idx + 1);
            } else if (i == 2) { // 곱셈
                solve(result * arr[idx], idx + 1);
            } else { // 나눗셈
                solve(result / arr[idx], idx + 1);
            }

            cnt[i]++;
        }
    }
}
