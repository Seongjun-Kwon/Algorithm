import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class Command {
        int sec;
        char dir;

        public Command(int sec, char dir) {
            this.sec = sec;
            this.dir = dir;
        }
    }

    static int n, k, L;
    static int[][] map;
    static Command[] cmd;
    static Deque<Point> deq;
    static int[] dr = {0, 1, 0, -1}; // 동 남 서 북
    static int[] dc = {1, 0, -1, 0};
    static boolean[][] vis;
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        map = new int[n][n];
        deq = new ArrayDeque<>();
        vis = new boolean[n][n];

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            map[r][c] = 1;
        }

        L = Integer.parseInt(br.readLine());
        cmd = new Command[L];

        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sec = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);

            cmd[i] = new Command(sec, dir);
        }

        solve(0);

        bw.write(Integer.toString(time));
        br.close();
        bw.flush();
        bw.close();
    }

    static void solve(int dir) {
        deq.addLast(new Point(0, 0));
        vis[0][0] = true;
        int cmdIdx = 0;

        while (true) {
            time++;

            Point head = deq.peekLast();
            int nr = head.r + dr[dir];
            int nc = head.c + dc[dir];

            if (nr < 0 || nc < 0 || nr >= n || nc >= n || vis[nr][nc]) {
                break;
            }

            deq.addLast(new Point(nr, nc));
            vis[nr][nc] = true;

            if (map[nr][nc] == 1) {
                map[nr][nc] = 0;
            } else {
                Point tail = deq.pollFirst();
                vis[tail.r][tail.c] = false;
            }

            if (cmdIdx < L && time == cmd[cmdIdx].sec) {
                if (cmd[cmdIdx].dir == 'L') {
                    dir = (dir + 3) % 4;
                } else if (cmd[cmdIdx].dir == 'D') {
                    dir = (dir + 1) % 4;
                }

                cmdIdx++;
            }
        }
    }
}
