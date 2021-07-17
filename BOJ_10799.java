import java.io.*;
import java.util.Stack;

public class Main
{
	static int cnt;

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> s = new Stack<>();
		String str = br.readLine();
		char[] c = new char[str.length()];

		for (int i = 0; i < str.length(); i++)
		{
			c[i] = str.charAt(i);
			if (c[i] == '(')
				s.push('(');
			else if (c[i] == ')')
			{
				if (!s.empty())
				{
					if (c[i - 1] == '(')
					{
						s.pop();
						cnt += s.size();
					}
					else
					{
						s.pop();
						cnt++;
					}
				}
			}
		}

		bw.write(Integer.toString(cnt));
		br.close();
		bw.flush();
		bw.close();
	}
}
