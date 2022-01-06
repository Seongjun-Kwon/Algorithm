import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static int n, m, x, y, k;
    static int[][] map;
    static int[] cmd;
    static int[] dice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        cmd = new int[k];
        dice = new int[7];
//             2
//           4 1 3
//             5
//             6

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            cmd[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < k; i++) {
            solve(cmd[i]);
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    static void solve(int dir) {
        int nr = x;
        int nc = y;

        if (dir == 1) { // 동쪽
            nc++;
        } else if (dir == 2) { // 서쪽
            nc--;
        } else if (dir == 3) { // 북쪽
            nr--;
        } else { // dir == 4 남쪽
            nr++;
        }

        if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
            return;
        }

        x = nr;
        y = nc;
        roll(dir);

        if (map[nr][nc] == 0) {
            map[nr][nc] = dice[1];
        } else { // map[nr][nc] != 0
            dice[1] = map[nr][nc];
            map[nr][nc] = 0;
        }

        sb.append(dice[6]).append('\n');
    }

    static void roll(int dir) {
        int[] tmp = new int[7];

        for (int i = 1; i < 7; i++) {
            tmp[i] = dice[i];
        }

        if (dir == 1) {
            tmp[1] = dice[3];
            tmp[3] = dice[6];
            tmp[4] = dice[1];
            tmp[6] = dice[4];
        } else if (dir == 2) {
            tmp[1] = dice[4];
            tmp[3] = dice[1];
            tmp[4] = dice[6];
            tmp[6] = dice[3];
        } else if (dir == 3) {
            tmp[1] = dice[2];
            tmp[2] = dice[6];
            tmp[5] = dice[1];
            tmp[6] = dice[5];
        } else { // dir == 4
            tmp[1] = dice[5];
            tmp[2] = dice[1];
            tmp[5] = dice[6];
            tmp[6] = dice[2];
        }

        for (int i = 1; i < 7; i++) {
            dice[i] = tmp[i];
        }
    }
}
