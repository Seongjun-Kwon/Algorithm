import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int ans;
    static char[][] arr;
    static boolean[][] vis;
    static ArrayList<Point> list;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ans = 0;
        arr = new char[12][6];
        vis = new boolean[12][6];
        list = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            String str = br.readLine();

            for (int j = 0; j < 6; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        solve();

        bw.write(Integer.toString(ans));
        br.close();
        bw.flush();
        bw.close();
    }

    static void solve() {
        while (true) {
            boolean flag = false; // 참이면 터진 뿌요 있음, 거짓이면 없음.

            for (int i = 0; i < 12; i++) { // 매 연쇄마다 vis를 초기화
                Arrays.fill(vis[i], false);
            }

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (!vis[i][j] && arr[i][j] != '.') {
                        BFS(i, j);
                    }

                    if (list.size() >= 4) { // bfs를 한 번 돌고 list에 4개 이상이 담기면 터트림.
                        flag = true;

                        for (Point p : list) {
                            arr[p.r][p.c] = '.';
                        }
                    }

                    list.clear(); // bfs를 한 번 돌고 나면 list를 비워줌.
                }
            }

            goDown();

            if (!flag) { // 뿌요가 터지지 않아 변화 없으면 탈출.
                break;
            } else {
                ans++;
            }
        }
    }

    static void BFS(int startR, int startC) {
        Queue<Point> q = new LinkedList<>();
        char color = arr[startR][startC];

        q.add(new Point(startR, startC));
        vis[startR][startC] = true;
        list.add(new Point(startR, startC));

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if (nr < 0 || nr >= 12 || nc < 0 || nc >= 6 || vis[nr][nc] || arr[nr][nc] != color) {
                    continue;
                }

                q.add(new Point(nr, nc));
                vis[nr][nc] = true;
                list.add(new Point(nr, nc));
            }
        }
    }

    static void goDown() {
        for (int i = 0; i < 6; i++) {
            for (int j = 11; j > 0; j--) {
                if (arr[j][i] == '.') {
                    for (int k = j - 1; k >= 0; k--) {
                        if (arr[k][i] != '.') {
                            arr[j][i] = arr[k][i];
                            arr[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }
}
