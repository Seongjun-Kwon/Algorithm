import java.io.*;
import java.util.*;

public class Main
{
	static int A, B, C;
	static boolean[][] vis;
	static boolean[] ans;

	static void DFS(int a, int b, int c) // a, b, c는 A, B, C 물통에 차 있는 물의 양
	{
		if (vis[a][b])
			return;
		
		if (a == 0)
			ans[c] = true;
		
		vis[a][b] = true;
		
		if (a + b > B) // A->B
			DFS(a + b - B, B, c);
		else
			DFS(0, a + b, c);
		
		DFS(0, b, a + c); // A->C
		
		if (b + a > A) // B->A
			DFS(A, a + b - A, c);
		else
			DFS(a + b, 0, c);
		
		DFS(a, 0, b + c); // B->C
		
		if (c + a > A) // C->A
			DFS(A, b, c + a - A);
		else
			DFS(c + a, b, 0);
		
		if (c + b > B) // C->B
			DFS(a, B, c + b - B);
		else
			DFS(a, c + b, 0);
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		vis = new boolean[201][201];
		ans = new boolean[201];
		
		DFS(0, 0, C);

		for (int i = 0; i < ans.length; i++)
		{
			if (ans[i])
				sb.append(i + " ");
		}

		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
