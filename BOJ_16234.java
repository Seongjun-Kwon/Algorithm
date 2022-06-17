import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, L, R;
    static int[][] A;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static boolean[][] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        vis = new boolean[N][N];
        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(Integer.toString(solve()));
        br.close();
        bw.flush();
        bw.close();
    }

    static int solve() {
        int moveCnt = 0;
        boolean isPossibleMove = true;

        while (true) {
            isPossibleMove = false;
            vis = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (vis[i][j]) {
                        continue;
                    }

                    if (movePopulation(i, j)) {
                        isPossibleMove = true;
                    }
                }
            }

            if (isPossibleMove) {
                moveCnt++;
            } else {
                return moveCnt;
            }
        }
    }

    static boolean movePopulation(int r, int c) { // 인구 이동이 가능한지 확인하고 가능하면 인구를 이동함.
        Queue<Point> q = new LinkedList<>();
        List<Point> list = new ArrayList<>();
        q.add(new Point(r, c));
        list.add(new Point(r, c));
        vis[r][c] = true;

        int population = A[r][c];
        int countryNum = 1;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N || vis[nr][nc]) {
                    continue;
                }

                int dis = Math.abs(A[nr][nc] - A[cur.r][cur.c]);

                if (dis < L || dis > R) {
                    continue;
                }

                q.add(new Point(nr, nc));
                list.add(new Point(nr, nc));
                vis[nr][nc] = true;
                population += A[nr][nc];
                countryNum++;
            }
        }

        if (list.size() == 1) {
            return false;
        } else {
            int updatePopulation = population / countryNum;

            for (Point point : list) {
                A[point.r][point.c] = updatePopulation;
            }

            return true;
        }
    }
}
