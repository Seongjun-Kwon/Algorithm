import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static boolean[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new boolean[101][101];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            drawDragonCurve(x, y, d, g);
        }

        checkSquare();

        bw.write(Integer.toString(ans));
        br.close();
        bw.flush();
        bw.close();
    }

    static void drawDragonCurve(int x, int y, int d, int g) {
        List<Integer> dir = new ArrayList<>();
        dir.add(d);

        for (int i = 1; i < g + 1; i++) {
            for (int j = dir.size() - 1; j >= 0; j--) {
                dir.add((dir.get(j) + 1) % 4);
            }
        }

        map[y][x] = true;

        for (int i = 0; i < dir.size(); i++) {
            int direction = dir.get(i);
            x += dx[direction];
            y += dy[direction];

            map[y][x] = true;
        }
    }

    static void checkSquare() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) {
                    ans++;
                }
            }
        }
    }
}
