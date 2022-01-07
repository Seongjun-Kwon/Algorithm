import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static StringBuilder sb;
    static int n;
    static int[] dis;
    static int[] root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        dis = new int[n + 1];
        root = new int[n + 1];

        bfs(n);

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dis[start] = 0;

        while (!q.isEmpty()) {
            for (int i = 0; i < q.size(); i++) {
                int cur = q.poll();

                if (cur == 1) {
                    sb.append(dis[1]).append('\n');
                    print(1);
                    return;
                }

                if (cur % 3 == 0) {
                    int nxt = cur / 3;

                    if (dis[nxt] == 0) {
                        q.add(nxt);
                        dis[nxt] = dis[cur] + 1;
                        root[nxt] = cur;
                    }
                }

                if (cur % 2 == 0) {
                    int nxt = cur / 2;

                    if (dis[nxt] == 0) {
                        q.add(nxt);
                        dis[nxt] = dis[cur] + 1;
                        root[nxt] = cur;
                    }
                }

                if (cur > 1) {
                    int nxt = cur - 1;

                    if (dis[nxt] == 0) {
                        q.add(nxt);
                        dis[nxt] = dis[cur] + 1;
                        root[nxt] = cur;
                    }
                }
            }
        }
    }

    static void print(int x) {
        if (x == 0) {
            return;
        }

        print(root[x]);
        sb.append(x).append(' ');
    }
}
