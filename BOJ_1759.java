import java.io.*;
import java.util.*;

public class Main
{
	static int L, C;
	static char[] arr;
	static boolean[] vis;
	static String ans = "";

	static boolean isVowel(char a)
	{
		if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u')
			return true;
		else
			return false;
	}

	static void DFS(int idx, int length, int vowel, int consonant)
	{
		if (length == L)
		{
			if (vowel < 1 || consonant < 2)
				return;

			for (int i = 0; i < C; i++)
			{
				if (vis[i])
					ans += arr[i];
			}

			ans += "\n";
			return;
		}

		for (int i = idx; i < C; i++)
		{
			vis[i] = true;
			
			if (isVowel(arr[i]))
				DFS(i + 1, length + 1, vowel + 1, consonant);
			else
				DFS(i + 1, length + 1, vowel, consonant + 1);
			
			vis[i] = false;
		}
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		vis = new boolean[C];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < C; i++)
			arr[i] = st.nextToken().charAt(0);
		
		Arrays.sort(arr);
		DFS(0, 0, 0, 0);
		
		bw.write(ans);
		br.close();
		bw.flush();
		bw.close();
	}
}
