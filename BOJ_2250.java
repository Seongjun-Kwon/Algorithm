import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Tree {
        int left, right;

        public Tree(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    static int n;
    static Tree[] tree;
    static int[] parent;
    static ArrayList<Integer>[] arr;
    static int rowIdx = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        tree = new Tree[n + 1];
        parent = new int[n + 1];
        arr = new ArrayList[n + 1];

        Arrays.fill(parent, -1);
        for (int i = 1; i < n + 1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int mid = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            if (left != -1) {
                parent[left] = mid;
            }
            if (right != -1) {
                parent[right] = mid;
            }

            tree[mid] = new Tree(left, right);
        }

        int root = -1;
        for (int i = 1; i < n + 1; i++) {
            if (parent[i] == -1) {
                root = i;
                break;
            }
        }

        dfs(root, 1);

        int level = 0, maxWidth = 0;
        for (int i = 1; i < n + 1; i++) {
            int length = arr[i].size();

            if (length == 0) {
                continue;
            }

            int max = arr[i].get(length - 1);
            int min = arr[i].get(0);
            int width = max - min + 1;

            if (maxWidth < width) {
                maxWidth = width;
                level = i;
            }
        }

        sb.append(level).append(' ').append(maxWidth);

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs(int root, int level) {
        if (tree[root].left != -1) {
            dfs(tree[root].left, level + 1);
        }

        arr[level].add(rowIdx++);

        if (tree[root].right != -1) {
            dfs(tree[root].right, level + 1);
        }
    }
}
