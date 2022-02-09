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
    static int[][] map;
    static ArrayList<Point> blank;
    static ArrayList<Point> virus;
    static int[] select;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        blank = new ArrayList<>(); // 빈 칸들이 있는 위치를 담아줌
        virus = new ArrayList<>(); // 바이러스들이 있는 위치를 담아줌
        select = new int[3]; // 선택한 3개 빈칸의 blank 리스트 내에서의 인덱스를 담아줌

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 0) {
                    blank.add(new Point(i, j));
                } else if (map[i][j] == 2) {
                    virus.add(new Point(i, j));
                }
            }
        }

        solve(0, 0);

        bw.write(Integer.toString(ans));
        br.close();
        bw.flush();
        bw.close();
    }

    static void solve(int idx, int cnt) {
        if (cnt == 3) { // 벽을 3개를 고르면 종료
            int sum = 0;

            int[][] tmp = new int[n][m];
            copyArr(map, tmp); // 3개를 고를 때마다 변화가 생기므로 원본을 유지해줘야함

            for (int i = 0; i < 3; i++) { // 3개의 벽을 세운다
                int wallIdx = select[i];
                tmp[blank.get(wallIdx).r][blank.get(wallIdx).c] = 1;
            }

            for (Point curVirus : virus) { // 바이러스들을 전파시킨다
                bfs(tmp, curVirus.r, curVirus.c);
            }

            for (int i = 0; i < n; i++) { // 안전 영역 크기 구해준다
                for (int j = 0; j < m; j++) {
                    if (tmp[i][j] == 0) {
                        sum++;
                    }
                }
            }

            if (ans < sum) {
                ans = sum;
            }

            return;
        }

        for (int i = idx; i < blank.size(); i++) { // 빈 칸들 중에서 빈 칸을 3개를 고른다
            select[cnt] = i;
            solve(i + 1, cnt + 1);
        }
    }

    static void copyArr(int[][] from, int[][] to) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                to[i][j] = from[i][j];
            }
        }
    }

    static void bfs(int[][] arr, int r, int c) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c));
        arr[r][c] = 2;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m || arr[nr][nc] > 0) {
                    continue;
                }

                q.add(new Point(nr, nc));
                arr[nr][nc] = 2;
            }
        }
    }
}
