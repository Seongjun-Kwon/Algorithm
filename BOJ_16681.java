import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int node;
        long distance;

        public Node(int node, long distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance <= o.distance ? -1 : 1;
        }
    }

    static int n, m, d, e;
    static int[] h;
    static ArrayList<ArrayList<Node>> adj;
    static long[] disToPeak;
    static long[] disToStart;
    static long answer = Long.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        h = new int[n + 1];
        adj = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());

            adj.get(from).add(new Node(to, dis));
            adj.get(to).add(new Node(from, dis));
        }

        disToPeak = solve(true);
        disToStart = solve(false);

        for (int i = 1; i < n + 1; i++) {
            if (disToPeak[i] == Long.MAX_VALUE || disToStart[i] == Long.MAX_VALUE) {
                continue;
            }

            answer = Math.max(answer, h[i] * e - (disToPeak[i] + disToStart[i]) * d);
        }

        if (answer == Long.MIN_VALUE) {
            sb.append("Impossible");
        } else {
            sb.append(answer);
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    static long[] solve(boolean isUp) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        long[] dis = new long[n + 1];
        Arrays.fill(dis, Long.MAX_VALUE);

        if (isUp) {
            dis[1] = 0;
            pq.add(new Node(1, dis[1]));
        } else {
            dis[n] = 0;
            pq.add(new Node(n, dis[n]));
        }

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curIdx = cur.node;
            long startToCurDis = cur.distance;

            if (startToCurDis > dis[curIdx]) {
                continue;
            }

            for (Node nxt : adj.get(curIdx)) {
                int nxtIdx = nxt.node;
                long curToNxtDis = nxt.distance;

                if (h[curIdx] >= h[nxtIdx]) {
                    continue;
                }

                if (dis[nxtIdx] > startToCurDis + curToNxtDis) {
                    dis[nxtIdx] = startToCurDis + curToNxtDis;
                    pq.add(new Node(nxtIdx, dis[nxtIdx]));
                }
            }
        }

        return dis;
    }
}
