import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Bridge {
        int num, weight;

        public Bridge(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }

    static int n, m;
    static ArrayList<ArrayList<Bridge>> adj;
    static boolean[] vis;
    static int fac1, fac2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        adj = new ArrayList<>();
        vis = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            adj.get(A).add(new Bridge(B, C));
            adj.get(B).add(new Bridge(A, C));
        }

        st = new StringTokenizer(br.readLine());
        fac1 = Integer.parseInt(st.nextToken());
        fac2 = Integer.parseInt(st.nextToken());

        int answer = binarySearch();

        bw.write(Integer.toString(answer));
        br.close();
        bw.flush();
        bw.close();
    }

    static int binarySearch() {
        int lo = 1;
        int hi = 1000000001;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;

            if (bfs(mid)) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        return lo;
    }

    static boolean bfs(int weight) {
        Queue<Integer> q = new LinkedList<>();
        vis = new boolean[n + 1];
        q.add(fac1);
        vis[fac1] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == fac2) {
                return true;
            }

            for (int i = 0; i < adj.get(cur).size(); i++) {
                int nxt = adj.get(cur).get(i).num;
                int curToNxtWeight = adj.get(cur).get(i).weight;

                if (vis[nxt] || curToNxtWeight < weight) {
                    continue;
                }

                q.add(nxt);
                vis[nxt] = true;
            }
        }

        return false;
    }
}
