import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int cmd, a, b;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            cmd = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (cmd == 0) {
                union(a, b);
            } else { // cmd == 1
                if (find(a) == find(b)) {
                    sb.append("YES").append('\n');
                } else {
                    sb.append("NO").append('\n');
                }
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    static int find(int x) { // x의 부모를 찾는 메서드
        if (parent[x] == x) {
            return x;
        }

        parent[x] = find(parent[x]);

        return parent[x];
    }

    static void union(int x, int y) { // x와 y를 합치는 메서드
        x = find(x);
        y = find(y);

        if (x == y) {
            return;
        }

        parent[y] = x;
    }
}
