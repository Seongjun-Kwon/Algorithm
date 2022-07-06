import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight <= o.weight ? -1 : 1;
        }
    }

    static int n, m, k;
    static PriorityQueue<Edge> pq;
    static int[] power;
    static int[] parent;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>();
        power = new int[k + 1];

        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            power[i] = Integer.parseInt(st.nextToken());
            parent[power[i]] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            pq.add(new Edge(u, v, w));
        }

        kruskal();

        bw.write(Integer.toString(answer));
        br.close();
        bw.flush();
        bw.close();
    }

    static void kruskal() {
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int fromRoot = find(cur.from);
            int toRoot = find(cur.to);

            if (fromRoot == toRoot) {
                continue;
            }

            union(cur.from, cur.to);
            answer += cur.weight;

            if (check()) {
                break;
            }
        }
    }

    static int find(int x) {
        if (parent[x] == 0) {
            return 0;
        }

        if (x == parent[x]) {
            return x;
        }

        parent[x] = find(parent[x]);

        return parent[x];
    }

    static void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if (xRoot == yRoot) {
            return;
        } else {
            if (yRoot == 0) {
                parent[xRoot] = yRoot;
            } else {
                parent[yRoot] = xRoot;
            }
        }
    }

    static boolean check() {
        for (int i = 1; i < n + 1; i++) {
            if (parent[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
