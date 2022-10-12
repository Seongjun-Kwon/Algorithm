import java.io.*;
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

    static int n, m, p;
    static int[] s;
    static char[][] board;
    static boolean[][] vis;
    static Queue<Point>[] q;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        s = new int[p];
        board = new char[n][m];
        vis = new boolean[n][m];
        q = new Queue[p];
        ans = new int[p];

        for (int i = 0; i < p; i++) {
            q[i] = new LinkedList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < p; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j);

                if (board[i][j] >= '1' && board[i][j] <= '9') {
                    int num = board[i][j] - '0' - 1;
                    ans[num]++;
                    vis[i][j] = true;
                    q[num].add(new Point(i, j));
                }
            }
        }

        int player = 0;
        int allPlayerCnt = 0;

        while (true) {
            int expandCnt = bfs(q[player], s[player]);

            ans[player] += expandCnt;
            allPlayerCnt += expandCnt;
            player++;

            if (player == p) {
                if (allPlayerCnt == 0) {
                    break;
                }

                player = 0;
                allPlayerCnt = 0;
            }
        }

        for (int i = 0; i < p; i++) {
            sb.append(ans[i]).append(' ');
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    static int bfs(Queue<Point> q, int s) {
        int dis = 0;
        int cnt = 0;

        while (!q.isEmpty()) {
            if (dis >= s) {
                break;
            }

            int size = q.size();

            for (int i = 0; i < size; i++) {
                Point cur = q.poll();

                for (int j = 0; j < 4; j++) {
                    int nr = cur.r + dr[j];
                    int nc = cur.c + dc[j];

                    if (nr < 0 || nc < 0 || nr >= n || nc >= m || vis[nr][nc] || board[nr][nc] == '#') {
                        continue;
                    }

                    board[nr][nc] = board[cur.r][cur.c];
                    q.add(new Point(nr, nc));
                    vis[nr][nc] = true;
                    cnt++;
                }
            }

            dis++;
        }

        return cnt;
    }
}
