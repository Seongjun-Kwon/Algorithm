import java.io.*;
import java.util.*;

public class Main
{
	static int n;
	static List<Integer>[] tree;
	static StringBuilder sb = new StringBuilder();

	static void preorder(int start)
	{
		int l = tree[start].get(0);
		int r = tree[start].get(1);
		sb.append((char) (start + 'A' - 1));
		if (l != -18)
			preorder(l);
		if (r != -18)
			preorder(r);
	}

	static void inorder(int start)
	{
		int l = tree[start].get(0);
		int r = tree[start].get(1);
		if (l != -18)
			inorder(l);
		sb.append((char) (start + 'A' - 1));
		if (r != -18)
			inorder(r);
	}

	static void postorder(int start)
	{
		int l = tree[start].get(0);
		int r = tree[start].get(1);
		if (l != -18)
			postorder(l);
		if (r != -18)
			postorder(r);
		sb.append((char) (start + 'A' - 1));
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		tree = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++)
			tree[i] = new ArrayList<>();

		for (int i = 0; i < n; i++)
		{
			st = new StringTokenizer(br.readLine());
			int root = st.nextToken().charAt(0) - 'A' + 1;
			int left = st.nextToken().charAt(0) - 'A' + 1;
			int right = st.nextToken().charAt(0) - 'A' + 1;
			tree[root].add(left);
			tree[root].add(right);
		}

		preorder(1);
		sb.append("\n");
		inorder(1);
		sb.append("\n");
		postorder(1);
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
