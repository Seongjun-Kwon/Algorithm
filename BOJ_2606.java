import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int node; // 컴퓨터의 수
    static int edge; // 간선의 수
    static boolean[] vis; // bfs 에서 방문한 컴퓨터를 표시할 배열
    static ArrayList<ArrayList<Integer>> adj; // 인접리스트를 이용하여 그래프 표현
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        node = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());
        vis = new boolean[node + 1];

        adj = new ArrayList<>();
        for (int i = 0; i < node + 1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adj.get(from).add(to);
            adj.get(to).add(from);
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
        vis[1] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int nxt : adj.get(cur)) {
                if (vis[nxt]) {
                    continue;
                }

                q.add(nxt);
                vis[nxt] = true;
                ans++;
            }
        }
    }
}
