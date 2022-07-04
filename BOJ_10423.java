import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight <= o.weight ? -1 : 1;
        }
    }

    static int n, m, k;
    static int[] power;
    static ArrayList<ArrayList<Node>> list;
    static boolean[] vis;
    static int answer = 0;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        power = new int[k];
        list = new ArrayList<>();
        vis = new boolean[n + 1];
        cnt = k;

        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            power[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.get(u).add(new Node(v, w));
            list.get(v).add(new Node(u, w));
        }

        prim();

        bw.write(Integer.toString(answer));
        br.close();
        bw.flush();
        bw.close();
    }

    static void prim() {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            for (Node node : list.get(power[i])) {
                pq.add(node);
            }

            vis[power[i]] = true;
        }

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (vis[now.to]) {
                continue;
            }

            vis[now.to] = true;
            answer += now.weight;
            cnt++;

            if (cnt == n) {
                break;
            }

            for (Node nxt : list.get(now.to)) {
                if (vis[nxt.to]) {
                    continue;
                }

                pq.add(nxt);
            }
        }
    }
}
