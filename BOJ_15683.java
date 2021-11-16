import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static class CCTV {
        int r;
        int c;
        int type;

        public CCTV(int r, int c, int type) {
            this.r = r;
            this.c = c;
            this.type = type;
        }
    }

    static int n, m;
    static int[][] arr;
    static CCTV cctv[];
    static int cctvCnt = 0;
    static int ans = Integer.MAX_VALUE;
    static int[] dir = {4, 2, 4, 4, 1};

    static void arrCopy(int[][] a, int[][] b) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                a[i][j] = b[i][j];
        }
    }

    static void update(int dir, CCTV cctv) {
        dir = dir % 4;

        if (dir == 0) {
            for (int i = cctv.c + 1; i < m; i++) {
                if (arr[cctv.r][i] == 6)
                    break;
                arr[cctv.r][i] = -1;
            }
        }

        if (dir == 1) {
            for (int i = cctv.r - 1; i >= 0; i--) {
                if (arr[i][cctv.c] == 6)
                    break;
                arr[i][cctv.c] = -1;
            }
        }

        if (dir == 2) {
            for (int i = cctv.c - 1; i >= 0; i--) {
                if (arr[cctv.r][i] == 6)
                    break;
                arr[cctv.r][i] = -1;
            }
        }

        if (dir == 3) {
            for (int i = cctv.r + 1; i < n; i++) {
                if (arr[i][cctv.c] == 6)
                    break;
                arr[i][cctv.c] = -1;
            }
        }
    }

    static void DFS(int cctvIdx) {
        if (cctvIdx == cctvCnt) {
            int blind = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 0)
                        blind++;
                }
            }

            if (ans > blind)
                ans = blind;

            return;
        }

        int[][] temp = new int[8][8];

        for (int i = 0; i < dir[cctv[cctvIdx].type]; i++) {
            arrCopy(temp, arr);

            if (cctv[cctvIdx].type == 0)
                update(i, cctv[cctvIdx]);

            if (cctv[cctvIdx].type == 1) {
                update(i, cctv[cctvIdx]);
                update(i + 2, cctv[cctvIdx]);
            }

            if (cctv[cctvIdx].type == 2) {
                update(i, cctv[cctvIdx]);
                update(i + 1, cctv[cctvIdx]);
            }

            if (cctv[cctvIdx].type == 3) {
                update(i, cctv[cctvIdx]);
                update(i + 1, cctv[cctvIdx]);
                update(i + 2, cctv[cctvIdx]);
            }

            if (cctv[cctvIdx].type == 4) {
                update(i, cctv[cctvIdx]);
                update(i + 1, cctv[cctvIdx]);
                update(i + 2, cctv[cctvIdx]);
                update(i + 3, cctv[cctvIdx]);
            }

            DFS(cctvIdx + 1);
            arrCopy(arr, temp);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        cctv = new CCTV[8];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] != 6 && arr[i][j] != 0)
                    cctv[cctvCnt++] = new CCTV(i, j, arr[i][j] - 1);
            }
        }

        DFS(0);

        bw.write(Integer.toString(ans));
        br.close();
        bw.flush();
        bw.close();
    }
}
