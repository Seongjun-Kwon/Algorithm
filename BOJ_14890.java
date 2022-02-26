import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, L;
    static int[][] map;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            solve(i, true);
            solve(i, false);
        }

        bw.write(Integer.toString(ans));
        br.close();
        bw.flush();
        bw.close();
    }

    static void solve(int depth, boolean isRow) {
        int length = 1; // 경사로를 놓을 수 있는 평면의 길이

        for (int i = 1; i < N; i++) {
            int dis = 0;

            if (isRow) {
                dis = map[depth][i] - map[depth][i - 1];
            } else {
                dis = map[i][depth] - map[i - 1][depth];
            }

            if (dis == 0) { // 연속된 평면
                length++;
            } else if (dis == 1 && length >= L) { // 오르막이고, 경사로를 놓을 수 있는 경우
                length = 1;
            } else if (dis == -1 && length >= 0) { // 내리막이고, 경사로를 놓을 수 있는 경우
                length = -1 * L + 1;
            } else { // 높이 차이가 1 이상나거나, 경사로를 놓을 수 없는 경우
                return;
            }
        }

        if (length >= 0) {
            ans++;
        }
    }
}
