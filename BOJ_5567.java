import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static ArrayList<ArrayList<Integer>> adj;
    static int[] dis;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dis = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dis, -1);
        }

        adj = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        bfs();

        bw.write(Integer.toString(ans));
        br.close();
        bw.flush();
        bw.close();
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        dis[1] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int nxt : adj.get(cur)) {
                if (dis[nxt] >= 0) {
                    continue;
                }

                q.add(nxt);
                dis[nxt] = dis[cur] + 1;

                if (dis[nxt] > 2) {
                    return;
                }

                ans++;
            }
        }
    }
}
