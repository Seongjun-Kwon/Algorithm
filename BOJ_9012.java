import java.io.*;
import java.util.Stack;

public class Main
{
	static int n;

	public static String VPS(String str) throws IOException
	{
		Stack<Character> s = new Stack<>();

		for (int j = 0; j < str.length(); j++)
		{
			char c = str.charAt(j);
			if (c == '(')
				s.push(c);
			else if (c == ')')
			{
				if (!s.empty())
				{
					if (s.peek() == '(')
						s.pop();
				}
				else if (s.empty())
				{
					return "NO";
				}
			}
		}

		if (s.empty())
			return "YES";
		else
			return "NO";
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++)
		{
			String str = br.readLine();
			bw.write(VPS(str) + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}
