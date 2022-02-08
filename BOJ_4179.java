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

    static int r, c;
    static char[][] maze;
    static Queue<Point> jq;
    static Queue<Point> fq;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        maze = new char[r][c];
        jq = new LinkedList<>();
        fq = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            char[] tmp = br.readLine().toCharArray();

            for (int j = 0; j < c; j++) {
                maze[i][j] = tmp[j];

                if (maze[i][j] == 'J') {
                    jq.add(new Point(i, j));
                } else if (maze[i][j] == 'F') {
                    fq.add(new Point(i, j));
                }
            }
        }

        if (bfs()) {
            sb.append(ans);
        } else {
            sb.append("IMPOSSIBLE");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    static boolean bfs() {
        while (!jq.isEmpty()) {
            int fSize = fq.size();
            for (int i = 0; i < fSize; i++) { // 불이 퍼진다
                Point curF = fq.poll();

                for (int j = 0; j < 4; j++) {
                    int nfr = curF.r + dr[j];
                    int nfc = curF.c + dc[j];

                    if (nfr < 0 || nfc < 0 || nfr >= r || nfc >= c || maze[nfr][nfc] == '#' || maze[nfr][nfc] == 'F') { // 범위를 벗어낫거나, 벽이거나, 이미 불이 퍼진 곳일 경우
                        continue;
                    }

                    maze[nfr][nfc] = 'F';
                    fq.add(new Point(nfr, nfc));
                }
            }

            int jSize = jq.size();
            for (int i = 0; i < jSize; i++) { // 지훈이가 이동한다
                Point curJ = jq.poll();

                for (int j = 0; j < 4; j++) {
                    int njr = curJ.r + dr[j];
                    int njc = curJ.c + dc[j];

                    if (njr < 0 || njc < 0 || njr >= r || njc >= c) { // 지훈이가 미로를 탈출했을 때
                        ans++;
                        return true;
                    }

                    if (maze[njr][njc] == '#' || maze[njr][njc] == 'F' || maze[njr][njc] == 'J') { // 벽이거나, 불이거나, 이미 방문한 경우
                        continue;
                    }

                    maze[njr][njc] = 'J';
                    jq.add(new Point(njr, njc));
                }
            }

            ans++;
        }

        return false;
    }
}
