import java.io.*;
import java.util.ArrayList;
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
    static boolean[][] isLightOn;
    static boolean[][] vis;
    static boolean[][] movePossible;
    static ArrayList<Point>[][] button;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int answer = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        isLightOn = new boolean[n][n];
        vis = new boolean[n][n];
        movePossible = new boolean[n][n];
        button = new ArrayList[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                button[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int curR = Integer.parseInt(st.nextToken()) - 1;
            int curC = Integer.parseInt(st.nextToken()) - 1;
            int lightR = Integer.parseInt(st.nextToken()) - 1;
            int lightC = Integer.parseInt(st.nextToken()) - 1;

            button[curR][curC].add(new Point(lightR, lightC));
        }

        bfs();

        bw.write(Integer.toString(answer));
        br.close();
        bw.flush();
        bw.close();
    }

    static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));
        isLightOn[0][0] = true;
        vis[0][0] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < button[cur.r][cur.c].size(); i++) {
                Point nxtLight = button[cur.r][cur.c].get(i);

                if (!isLightOn[nxtLight.r][nxtLight.c]) {
                    isLightOn[nxtLight.r][nxtLight.c] = true;
                    answer++;
                }

                if (!movePossible[nxtLight.r][nxtLight.c] || vis[nxtLight.r][nxtLight.c]) {
                    continue;
                }

                q.add(new Point(nxtLight.r, nxtLight.c));
                vis[nxtLight.r][nxtLight.c] = true;
            }

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= n) {
                    continue;
                }

                movePossible[nr][nc] = true;

                if (!isLightOn[nr][nc] || vis[nr][nc]) {
                    continue;
                }

                q.add(new Point(nr, nc));
                vis[nr][nc] = true;
            }
        }
    }
}
