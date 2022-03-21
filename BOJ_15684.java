import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m, h;
    static int[][] line;
    static boolean finish;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        line = new int[h + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int point = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());

            line[point][idx] = 1;
            line[point][idx + 1] = 2;
        }

        for (int i = 0; i < 4; i++) {
            ans = i;
            solve(1, 0);

            if (finish) {
                break;
            }
        }

        if (!finish) {
            ans = -1;
        }

        bw.write(Integer.toString(ans));
        br.close();
        bw.flush();
        bw.close();
    }

    static void solve(int idx, int count) {
        if (finish) {
            return;
        }

        if (count == ans) {
            if (isPossible()) {
                finish = true;
                return;
            }

            return;
        }

        for (int i = idx; i < n; i++) {
            for (int j = 1; j < h + 1; j++) {
                if (line[j][i] != 0 || line[j][i + 1] != 0) {
                    continue;
                }

                line[j][i] = 1;
                line[j][i + 1] = 2;

                solve(i, count + 1);

                line[j][i] = 0;
                line[j][i + 1] = 0;
            }
        }
    }

    static boolean isPossible() {
        for (int i = 1; i < n + 1; i++) {
            int cur = i;

            for (int j = 1; j < h + 1; j++) {
                if (line[j][cur] == 1) {
                    cur++;
                } else if (line[j][cur] == 2) {
                    cur--;
                }
            }

            if (cur != i) {
                return false;
            }
        }

        return true;
    }
}
