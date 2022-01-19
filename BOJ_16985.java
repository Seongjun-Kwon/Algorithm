import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int r, c, h;

        public Point(int r, int c, int h) {
            this.r = r;
            this.c = c;
            this.h = h;
        }
    }

    static int[][][] map; // 입력 받는 미로의 정보
    static int[][][] dis; // 출발점으로부터의 거리
    static int[] order; // 판을 쌓는 순서
    static boolean[] vis; // 판을 쌓을 때 방문 여부
    static int[] rotateDir; // 각 판의 회전 각도
    static int[] dr = {0, 1, 0, -1, 0, 0};
    static int[] dc = {1, 0, -1, 0, 0, 0};
    static int[] dh = {0, 0, 0, 0, -1, 1};
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        map = new int[5][5][5];
        order = new int[5];
        vis = new boolean[5];
        rotateDir = new int[5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int k = 0; k < 5; k++) {
                    map[j][k][i] = Integer.parseInt(st.nextToken());
                }
            }
        }

        buildBoard(0);

        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }

        bw.write(Integer.toString(ans));
        br.close();
        bw.flush();
        bw.close();
    }

    static void buildBoard(int r) {
        if (r == 5) {
            int[][][] tmp = new int[5][5][5];

            copyArr(map, tmp);

            for (int i = 0; i < 5; i++) { // 정해진 쌓는 순서대로 판을 쌓는다.
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        tmp[i][j][k] = map[i][j][order[k]];
                    }
                }
            }

//            rotateAll(0, tmp);

            for (int i = 0; i < 4; i++) {
                rotate90(0, tmp);

                for (int j = 0; j < 4; j++) {
                    rotate90(1, tmp);

                    for (int k = 0; k < 4; k++) {
                        rotate90(2, tmp);

                        for (int l = 0; l < 4; l++) {
                            rotate90(3, tmp);

                            for (int m = 0; m < 4; m++) {
                                rotate90(4, tmp);

                                if (tmp[0][0][0] == 1 && tmp[4][4][4] == 1) {
                                    bfs(0, 0, 0, tmp);
                                }
                            }
                        }
                    }
                }
            }

            return;
        }

        for (int i = 0; i < 5; i++) {
            if (vis[i]) {
                continue;
            }

            vis[i] = true;
            order[i] = r;
            buildBoard(r + 1);
            vis[i] = false;
        }
    }

    static void copyArr(int[][][] from, int[][][] to) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    to[i][j][k] = from[i][j][k];
                }
            }
        }
    }

//    static void rotateAll(int r, int[][][] arr) {
//        if (r == 5) {
//            int[][][] tmp = new int[5][5][5];
//
//            copyArr(arr, tmp);
//
//            for (int i = 0; i < 5; i++) { // 정해진 회전 방향에 따라 각 판을 전부 돌린다.
//                rotateOne(rotateDir[i], i, tmp);
//            }
//
//            if (tmp[0][0][0] == 1 && tmp[4][4][4] == 1) {
//                bfs(0, 0, 0, tmp);
//            }
//
//            return;
//        }
//
//        for (int i = 0; i < 4; i++) {
//            rotateDir[r] = i;
//            rotateAll(r + 1, arr);
//        }
//    }

//    static void rotateOne(int dir, int depth, int[][][] arr) {
//        for (int i = 0; i < dir; i++) {
//            rotate90(depth, arr);
//        }
//    }

    static void rotate90(int depth, int[][][] arr) {
        int[][][] tmp = new int[5][5][5];

        copyArr(arr, tmp);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j][depth] = tmp[4 - j][i][depth];
            }
        }
    }

    static void bfs(int r, int c, int h, int[][][] arr) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c, h));

        dis = new int[5][5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dis[i][j], -1);
            }
        }

        dis[r][c][h] = 0;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            if (cur.r == 4 && cur.c == 4 && cur.h == 4) {
                if (ans > dis[cur.r][cur.c][cur.h]) {
                    ans = dis[cur.r][cur.c][cur.h];
                    continue;
                }
            }

            for (int i = 0; i < 6; i++) {
                int nxtR = cur.r + dr[i];
                int nxtC = cur.c + dc[i];
                int nxtH = cur.h + dh[i];

                if (nxtR < 0 || nxtC < 0 || nxtH < 0 || nxtR >= 5 || nxtC >= 5 || nxtH >= 5 || arr[nxtR][nxtC][nxtH] == 0 || dis[nxtR][nxtC][nxtH] >= 0) {
                    continue;
                }

                q.add(new Point(nxtR, nxtC, nxtH));
                dis[nxtR][nxtC][nxtH] = dis[cur.r][cur.c][cur.h] + 1;
            }
        }
    }
}
