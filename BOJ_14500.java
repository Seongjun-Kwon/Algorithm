import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[][] vis;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();

        bw.write(Integer.toString(ans));
        br.close();
        bw.flush();
        bw.close();
    }

    static void solve() { // 모든 칸마다 테트로미노의 모든 경우의 수를 놓아봄
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                vis[i][j] = true;
                dfs(i, j, 1, arr[i][j]);
                convex(i, j);
                vis[i][j] = false;
            }
        }
    }

    static void dfs(int r, int c, int cnt, int sum) { // ㅗ 모양을 제외하고 (r, c)에서 놓을 수 있는 모든 테트로미노 경우의 수 구함
        if (cnt == 4) {
            if (ans < sum) {
                ans = sum;
            }

            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nc < 0 || nr >= n || nc >= m || vis[nr][nc]) {
                continue;
            }

            vis[nr][nc] = true;
            dfs(nr, nc, cnt + 1, sum + arr[nr][nc]);
            vis[nr][nc] = false;
        }
    }

    static void convex(int r, int c) { // (r,c)에서 놓을수 있는 ㅗ 모양의 모든 테트로미노의 경우의 수 구함
        int wing = 4; // + 모양에서 날개의 갯수
        int min = Integer.MAX_VALUE; // + 모양에서 가장 값이 작은 날개의 값
        int sum = arr[r][c]; // 날개 3개 값의 총합

        for (int i = 0; i < 4; i++) {
            if (wing <= 2) { // 날개가 3개 이상이 아니면 ㅗ 모양이 아님
                return;
            }

            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
                wing--;
                continue;
            }

            if (min > arr[nr][nc]) {
                min = arr[nr][nc];
            }

            sum += arr[nr][nc];
        }

        if (wing == 4) { // + 모양에서 가장 작은 날개 값을 빼줌
            sum -= min;
        }

        if (ans < sum) {
            ans = sum;
        }
    }
}
