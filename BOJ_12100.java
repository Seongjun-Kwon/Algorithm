import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, ans;
    static int[][] arr;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        ans = 0;
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(arr, 1);

        bw.write(Integer.toString(ans));
        br.close();
        bw.flush();
        bw.close();
    }

    static void solve(int[][] map, int cnt) {
        if (cnt > 5) {
            int max = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] > max) {
                        max = map[i][j];
                    }
                }
            }

            if (max > ans) {
                ans = max;
                return;
            }

            return;
        }

        for (int i = 0; i < 4; i++) {
            int[][] tmp = new int[n][n];
            copyArr(map, tmp);
            move(map, i);
            solve(map, cnt + 1);
            copyArr(tmp, map);
        }
    }

    static void copyArr(int[][] from, int[][] to) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                to[i][j] = from[i][j];
            }
        }
    }

    static void move(int[][] map, int dir) {
        if (dir == 0) { // 오른쪽
            for (int i = 0; i < n; i++) {
                for (int j = n - 1; j >= 0; j--) {
                    if (map[i][j] > 0) {
                        q.add(map[i][j]);
                        map[i][j] = 0;
                    }
                }

                merge(map, i, n - 1, 0, -1);
            }
        } else if (dir == 1) { // 아래
            for (int j = 0; j < n; j++) {
                for (int i = n - 1; i >= 0; i--) {
                    if (map[i][j] > 0) {
                        q.add(map[i][j]);
                        map[i][j] = 0;
                    }
                }

                merge(map, n - 1, j, -1, 0);
            }
        } else if (dir == 2) { // 왼쪽
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] > 0) {
                        q.add(map[i][j]);
                        map[i][j] = 0;
                    }
                }

                merge(map, i, 0, 0, 1);
            }
        } else { // 위
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++) {
                    if (map[i][j] > 0) {
                        q.add(map[i][j]);
                        map[i][j] = 0;
                    }
                }

                merge(map, 0, j, 1, 0);
            }
        }
    }

    static void merge(int[][] map, int row, int col, int dRow, int dCol) {
        while (!q.isEmpty()) {
            int val = q.poll();

            if (map[row][col] == 0) {
                map[row][col] = val;
            } else if (map[row][col] == val) {
                map[row][col] += val;
                row += dRow;
                col += dCol;
            } else {
                row += dRow;
                col += dCol;
                map[row][col] = val;
            }
        }
    }
}
