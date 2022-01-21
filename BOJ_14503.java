import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m, r, c, d, ans;
    static int[][] arr;
    static boolean[][] vis;
    static int[] dr = {-1, 0, 1, 0}; // 북 동 남 서
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        ans = 0;
        arr = new int[n][m];
        vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(r, c, d);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j]) {
                    ans++;
                }
            }
        }

        bw.write(Integer.toString(ans));
        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs(int sr, int sc, int dir) {
        if (arr[sr][sc] == 1) { // 후진했는데 벽인 경우 종료
            return;
        } else {
            vis[sr][sc] = true;
        }

        for (int i = 0; i < 4; i++) {
            dir = (dir + 3) % 4; // 방향을 현재 방향에서 왼쪽으로 바꿔줌
            int nr = sr + dr[dir];
            int nc = sc + dc[dir];

            if (nr < 0 || nc < 0 || nr >= n || nc >= m || vis[nr][nc] || arr[nr][nc] == 1) { // 왼쪽 방향에 청소할 공간이 없다면 방향만 바꿔주고 반복
                continue;
            }

            dfs(nr, nc, dir);
            return;
        }

        dfs(sr - dr[dir], sc - dc[dir], dir); // 네 방향 다 청소 불가능 하면 방향 유지하고 후진
    }
}
