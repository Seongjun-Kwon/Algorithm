import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[] vis;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0);

        bw.write(Integer.toString(ans));
        br.close();
        bw.flush();
        bw.close();
    }

    static void solve(int idx, int cnt) {
        if (cnt == n / 2) {
            int[] start = new int[n / 2]; // start 팀을 담음
            int[] link = new int[n / 2]; // link 팀을 담음
            int startIdx = 0, linkIdx = 0;
            int startSum = 0, linkSum = 0; // start, link 팀의 능력치 합

            for (int i = 0; i < n; i++) { // start, link 배열을 채워줌
                if (vis[i]) {
                    start[startIdx++] = i;
                } else {
                    link[linkIdx++] = i;
                }
            }

            for (int i = 0; i < n / 2 - 1; i++) { // start 팀의 능력치 합을 구해줌
                for (int j = i + 1; j < n / 2; j++) {
                    startSum += (arr[start[i]][start[j]] + arr[start[j]][start[i]]);
                }
            }

            for (int i = 0; i < n / 2 - 1; i++) { // link 팀의 능력치 합을 구해줌
                for (int j = i + 1; j < n / 2; j++) {
                    linkSum += (arr[link[i]][link[j]] + arr[link[j]][link[i]]);
                }
            }

            if (ans > Math.abs(startSum - linkSum)) {
                ans = Math.abs(startSum - linkSum);
            }

            return;
        }

        for (int i = idx; i < n; i++) {
            if (vis[i]) {
                continue;
            }

            vis[i] = true;
            solve(i + 1, cnt + 1);
            vis[i] = false;
        }
    }
}
