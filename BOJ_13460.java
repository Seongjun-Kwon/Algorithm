import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int redR, redC, blueR, blueC;

        public Point(int redR, int redC, int blueR, int blueC) {
            this.redR = redR;
            this.redC = redC;
            this.blueR = blueR;
            this.blueC = blueC;
        }
    }

    static int n, m;
    static char[][] board;
    static int redR, redC, blueR, blueC;
    static int[][][][] cnt;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        cnt = new int[n][m][n][m]; // cnt[redR][redC][blueR][blueC]: 빨간공이 (redR, redC), 파란공이 (blueR, blueC)에 도착했을 때 기울인 횟수

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    Arrays.fill(cnt[i][j][k], -1);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            char[] tmp = br.readLine().toCharArray();

            for (int j = 0; j < m; j++) {
                board[i][j] = tmp[j];

                if (board[i][j] == 'R') {
                    redR = i;
                    redC = j;
                } else if (board[i][j] == 'B') {
                    blueR = i;
                    blueC = j;
                }
            }
        }

        bfs(redR, redC, blueR, blueC);

        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }

        bw.write(Integer.toString(ans));
        br.close();
        bw.flush();
        bw.close();
    }

    static void bfs(int rr, int rc, int br, int bc) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(rr, rc, br, bc));
        cnt[rr][rc][br][bc] = 0;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            if (cnt[cur.redR][cur.redC][cur.blueR][cur.blueC] >= 10) { // 10번 이하로 기울여서 성공못하면 실패
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nrr = cur.redR;
                int nrc = cur.redC;
                int nbr = cur.blueR;
                int nbc = cur.blueC;

                while (board[nrr + dr[i]][nrc + dc[i]] != '#') { // 빨간 구슬을 벽에 닿을 때까지 이동시킴
                    nrr += dr[i];
                    nrc += dc[i];

                    if (board[nrr][nrc] == 'O') {
                        break;
                    }
                }

                while (board[nbr + dr[i]][nbc + dc[i]] != '#') { // 파란 구슬을 벽에 닿을 때까지 이동시킴
                    nbr += dr[i];
                    nbc += dc[i];

                    if (board[nbr][nbc] == 'O') {
                        break;
                    }
                }

                if (board[nbr][nbc] == 'O') { // 파란 구슬이 구멍에 빠지면 실패
                    continue;
                }

                if (board[nrr][nrc] == 'O') { // 파란 구슬이 구멍에 빠지지 않고, 빨간 구슬이 구멍에 빠지면 성공
                    cnt[nrr][nrc][nbr][nbc] = cnt[cur.redR][cur.redC][cur.blueR][cur.blueC] + 1;

                    if (ans > cnt[nrr][nrc][nbr][nbc]) {
                        ans = cnt[nrr][nrc][nbr][nbc];
                    }

                    return;
                }

                if (nrr == nbr && nrc == nbc) { // 빨간색과 파란색이 기울이는 방향으로 같은 줄에 있을 시, 기울였을 때 위치가 같아지는 경우가 생김
                    int redMoveDis = Math.abs(nrr - cur.redR) + Math.abs(nrc - cur.redC);
                    int blueMoveDis = Math.abs(nbr - cur.blueR) + Math.abs(nbc - cur.blueC);

                    if (redMoveDis > blueMoveDis) { // 파란색이 일찍 도착한 경우 빨간색을 뒤로 놓아줌
                        nrr -= dr[i];
                        nrc -= dc[i];
                    } else { // 빨간색이 일찍 도착한 경우 파란색을 뒤로 놓아줌
                        nbr -= dr[i];
                        nbc -= dc[i];
                    }
                }

                if (cnt[nrr][nrc][nbr][nbc] >= 0) { // >= 0 이면 이미 한 번 이상 방문했다는 의미
                    continue;
                }

                q.add(new Point(nrr, nrc, nbr, nbc));
                cnt[nrr][nrc][nbr][nbc] = cnt[cur.redR][cur.redC][cur.blueR][cur.blueC] + 1;
            }
        }
    }
}
