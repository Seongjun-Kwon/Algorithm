import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] road;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        road = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                road[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        floyd();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;
            int C = Integer.parseInt(st.nextToken());

            if (road[A][B] <= C) {
                sb.append("Enjoy other party").append('\n');
            } else {
                sb.append("Stay here").append('\n');
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    static void floyd() {
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < n; k++) {
                    if (road[i][j] + road[j][k] < road[i][k]) {
                        road[i][k] = road[i][j] + road[j][k];
                    }
                }
            }
        }
    }
}
