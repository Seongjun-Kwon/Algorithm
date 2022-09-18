import java.io.*;

public class Main {
    static int G, P;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer = 0;

        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        parent = new int[G + 1];

        for (int i = 1; i < G + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < P; i++) {
            int num = Integer.parseInt(br.readLine());

            if (find(num) == 0) {
                break;
            }

            union(find(num) - 1, find(num));
            answer++;
        }

        bw.write(Integer.toString(answer));
        br.close();
        bw.flush();
        bw.close();
    }

    static void union(int a, int b) { // b가 a 자식이 된다
        a = find(a);
        b = find(b);
        parent[b] = a;
    }

    static int find(int a) {
        if (a == parent[a]) {
            return a;
        }

        parent[a] = find(parent[a]);

        return parent[a];
    }
}
