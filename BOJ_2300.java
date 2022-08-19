import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Point implements Comparable<Point> {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(Point o) {
            if (this.r < o.r) {
                return -1;
            } else if (this.r == o.r) {
                return this.c <= o.c ? -1 : 1;
            } else {
                return 1;
            }
        }
    }

    static int n;
    static int[] dp; // dp[i] = 0 ~ i번째 건물까지 연결하는 비용의 최솟값
    static Point[] point;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        dp = new int[n];
        point = new Point[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Math.abs(Integer.parseInt(st.nextToken()));

            point[i] = new Point(x, y);
        }

        Arrays.fill(dp, Integer.MAX_VALUE);
        Arrays.sort(point);

        dp[0] = point[0].c * 2;
        for (int i = 1; i < n; i++) {
            int height = 0;

            for (int j = i; j >= 0; j--) {
                height = Math.max(height, point[j].c);
                int cost = Math.max(height * 2, point[i].r - point[j].r);

                if (j > 0) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + cost);
                } else {
                    dp[i] = Math.min(dp[i], cost);
                }
            }
        }

        bw.write(Integer.toString(dp[n - 1]));
        br.close();
        bw.flush();
        bw.close();
    }
}
