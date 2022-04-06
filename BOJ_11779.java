import java.io.*;
import java.util.*;

public class Main {
    static class Bus implements Comparable<Bus> {
        int vertex, cost;

        public Bus(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Bus o) {
            return this.cost <= o.cost ? -1 : 1;
        }
    }

    static StringBuilder sb;
    static int n, m, start, end;
    static Bus[] bus;
    static int[] dis;
    static ArrayList<ArrayList<Bus>> adj;
    static int[] route;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        bus = new Bus[m];
        adj = new ArrayList<>();
        dis = new int[n + 1];
        route = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }

        Arrays.fill(dis, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adj.get(from).add(new Bus(to, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        solve(start);

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    static void solve(int x) { // 다익스트라
        PriorityQueue<Bus> pq = new PriorityQueue<>();
        Stack<Integer> sta = new Stack<>();
        dis[x] = 0;
        pq.add(new Bus(x, dis[x]));

        while (!pq.isEmpty()) {
            Bus cur = pq.poll();
            int curVertex = cur.vertex; // 현재 탐색 중인 정점
            int xToCurCost = cur.cost; // x에서 curVertex 까지의 최소 비용

            if (xToCurCost > dis[curVertex]) {
                continue;
            }

            for (Bus child : adj.get(curVertex)) {
                int nxtVertex = child.vertex; // 다음에 탐색할 정점
                int curToNxtCost = child.cost; // curVertex 에서 nxtVertex 까지의 비용

                if (xToCurCost + curToNxtCost < dis[nxtVertex]) {
                    dis[nxtVertex] = xToCurCost + curToNxtCost;
                    pq.add(new Bus(nxtVertex, dis[nxtVertex]));
                    route[nxtVertex] = curVertex;
                }
            }
        }

        sb.append(dis[end]).append('\n');

        // 경로 추적 과정
        sta.add(end);
        cnt = 1;

        while (route[end] != 0) {
            cnt++;
            sta.add(route[end]);
            end = route[end];
        }

        sb.append(cnt).append('\n');

        while (!sta.isEmpty()) {
            sb.append(sta.pop()).append(' ');
        }
    }
}
