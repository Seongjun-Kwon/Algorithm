import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return r == point.r && c == point.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }

    static int n, k, r;
    static boolean[][] vis;
    static Point[] cow;
    static ArrayList<Point>[][] road;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        cow = new Point[k];
        road = new ArrayList[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                road[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int startR = Integer.parseInt(st.nextToken());
            int startC = Integer.parseInt(st.nextToken());
            int endR = Integer.parseInt(st.nextToken());
            int endC = Integer.parseInt(st.nextToken());

            road[startR][startC].add(new Point(endR, endC));
            road[endR][endC].add(new Point(startR, startC));
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int cowR = Integer.parseInt(st.nextToken());
            int cowC = Integer.parseInt(st.nextToken());

            cow[i] = new Point(cowR, cowC);
        }

        solve();

        bw.write(Integer.toString(cnt));
        br.close();
        bw.flush();
        bw.close();
    }

    static void solve() {
        for (int i = 0; i < k; i++) {
            vis = new boolean[n + 1][n + 1];

            int cowR = cow[i].r;
            int cowC = cow[i].c;

            bfs(cowR, cowC);

            for (int j = i; j < k; j++) {
                Point otherCow = cow[j];

                if (!vis[otherCow.r][otherCow.c]) {
                    cnt++;
                }
            }
        }
    }

    static void bfs(int startR, int startC) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startR, startC));
        vis[startR][startC] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if (nr < 1 || nc < 1 || nr > n || nc > n || vis[nr][nc]) {
                    continue;
                }

                if (road[cur.r][cur.c].contains(new Point(nr, nc))) {
                    continue;
                }

                q.add(new Point(nr, nc));
                vis[nr][nc] = true;
            }
        }
    }
}
