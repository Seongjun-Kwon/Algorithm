import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Point implements Comparable<Point> {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x < o.x) {
                return -1;
            } else if (this.x == o.x) {
                return this.y < o.y ? -1 : 1;
            } else {
                return 1;
            }
        }
    }

    static int t;
    static List<Point> cafe;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            cafe = new ArrayList<>();
            cafe.add(new Point(-1, 0));

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                cafe.add(new Point(x, y));
            }

            Collections.sort(cafe);

            int idx = 1;

            while (idx <= n) {
                if (cafe.get(idx).x == cafe.get(idx - 1).x) {
                    idx++;
                } else if (cafe.get(idx).y == cafe.get(idx - 1).y) {
                    idx++;
                } else {
                    int cur = idx;
                    int curX = cafe.get(idx).x;

                    while (idx <= n && curX == cafe.get(idx).x) {
                        idx++;
                    }

                    List<Point> subList = cafe.subList(cur, idx);
                    Collections.reverse(subList);
                }
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());

            for (int i = 0; i < m; i++) {
                int cafeNum = Integer.parseInt(st.nextToken());
                sb.append(cafe.get(cafeNum).x).append(' ').append(cafe.get(cafeNum).y).append('\n');
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}
