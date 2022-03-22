import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static int n, m;
    static String[] name;
    static ArrayList<ArrayList<Integer>> tree;
    static int[] indeg;
    static HashMap<String, Integer> map;
    static ArrayList<Integer> parent;
    static ArrayList<ArrayList<Integer>> child;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        name = new String[n];
        indeg = new int[n];
        tree = new ArrayList<>();
        map = new HashMap<>();
        parent = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            name[i] = st.nextToken();
        }

        Arrays.sort(name);

        for (int i = 0; i < n; i++) {
            map.put(name[i], i);
        }

        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int child = map.get(st.nextToken());
            int parent = map.get(st.nextToken());

            tree.get(parent).add(child);
            indeg[child]++;
        }

        topoSort();
        print();

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    static void topoSort() {
        Queue<Integer> q = new LinkedList<>();
        child = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            child.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
                parent.add(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int nxt : tree.get(cur)) {
                indeg[nxt]--;

                if (indeg[nxt] == 0) {
                    q.offer(nxt);
                    child.get(cur).add(nxt);
                }
            }
        }
    }

    static void print() {
        sb.append(parent.size()).append('\n');

        for (int idx : parent) {
            sb.append(name[idx]).append(' ');
        }

        sb.append('\n');

        for (int i = 0; i < n; i++) {
            sb.append(name[i]).append(' ').append(child.get(i).size()).append(' ');

            child.get(i).sort(null);

            for (int idx : child.get(i)) {
                sb.append(name[idx]).append(' ');
            }

            sb.append('\n');
        }
    }
}
