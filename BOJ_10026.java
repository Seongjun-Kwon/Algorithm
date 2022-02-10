import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int n;
    static char[][] picture;
    static boolean[][] vis;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int notBlindCnt = 0, blindCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        picture = new char[n][n];
        vis = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            char[] tmp = br.readLine().toCharArray();

            for (int j = 0; j < n; j++) {
                picture[i][j] = tmp[j];
            }
        }

        for (int i = 0; i < n; i++) { // 적록색약이 아닌 경우
            for (int j = 0; j < n; j++) {
                if (vis[i][j]) {
                    continue;
                }

                solve(i, j);
                notBlindCnt++;
            }
        }

        vis = new boolean[n][n];

        for (int i = 0; i < n; i++) { // 적록색약의 경우를 위해 그림에서 G를 R로 바꿔줌
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'G') {
                    picture[i][j] = 'R';
                }
            }
        }

        for (int i = 0; i < n; i++) { // 적록색약의 경우
            for (int j = 0; j < n; j++) {
                if (vis[i][j]) {
                    continue;
                }

                solve(i, j);
                blindCnt++;
            }
        }

        sb.append(notBlindCnt).append(' ').append(blindCnt);

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    static void solve(int r, int c) { // 적록색약이 아닌 경우
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c));
        vis[r][c] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            char curColor = picture[cur.r][cur.c];

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= n || curColor != picture[nr][nc] || vis[nr][nc]) {
                    continue;
                }

                q.add(new Point(nr, nc));
                vis[nr][nc] = true;
            }
        }
    }
}
