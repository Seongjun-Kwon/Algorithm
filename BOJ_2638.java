import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int n, m;
    static int[][] map;
    static boolean[][] vis;
    static int[][] noCheese;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        vis = new boolean[n][m];
        noCheese = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();

        bw.write(Integer.toString(answer));
        br.close();
        bw.flush();
        bw.close();
    }

    static void solve() {
        while (true) {
            for (int i = 0; i < n; i++) {
                Arrays.fill(noCheese[i], 0);
            }

            bfs();

            boolean isMelt = isCheeseMelt();
            if (isMelt) {
                answer++;
            } else {
                break;
            }
        }
    }

    static void bfs() {
        Queue<Point> q = new LinkedList<>();
        vis = new boolean[n][m];
        q.add(new Point(0, 0));
        map[0][0] = 2;
        vis[0][0] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m || vis[nr][nc]) {
                    continue;
                }

                if (map[nr][nc] == 1) {
                    noCheese[nr][nc]++;
                    continue;
                }

                q.add(new Point(nr, nc));
                map[nr][nc] = 2;
                vis[nr][nc] = true;
            }
        }
    }

    static boolean isCheeseMelt() {
        boolean check = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (noCheese[i][j] >= 2) {
                    check = true;
                    map[i][j] = 0;
                }
            }
        }

        return check;
    }
}
