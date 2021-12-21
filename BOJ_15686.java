import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, m, ans;
    static int[][] arr;
    static boolean[] survive;
    static ArrayList<Point> home;
    static ArrayList<Point> chicken;

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = Integer.MAX_VALUE;
        arr = new int[n][n];
        home = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 1) {
                    home.add(new Point(i, j));
                } else if (arr[i][j] == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }

        survive = new boolean[chicken.size()];

        DFS(0, 0);

        bw.write(Integer.toString(ans));
        br.close();
        bw.flush();
        bw.close();
    }

    static void DFS(int idx, int cnt) {
        if (cnt == m) {
            int sum = 0;

            for (int i = 0; i < home.size(); i++) {
                Point curH = home.get(i);
                int tmp = Integer.MAX_VALUE;

                for (int j = 0; j < chicken.size(); j++) {
                    if (survive[j]) {
                        Point curC = chicken.get(j);
                        int distance = Math.abs(curH.r - curC.r) + Math.abs(curH.c - curC.c);

                        if (tmp > distance) {
                            tmp = distance;
                        }
                    }
                }

                sum += tmp;
            }

            if (ans > sum) {
                ans = sum;
            }

            return;
        }

        for (int i = idx; i < chicken.size(); i++) {
            survive[i] = true;
            DFS(i + 1, cnt + 1);
            survive[i] = false;
        }
    }
}
