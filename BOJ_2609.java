import java.io.*;

public class Main
{
	public static int gcd(int x, int y)
	{
		if (y == 0)
			return x;
		else
			return gcd(y, x % y);
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] str = br.readLine().split(" ");
		
		int a = Integer.parseInt(str[0]);
		int b = Integer.parseInt(str[1]);
		bw.write(Integer.toString(gcd(a, b)) + "\n" + Integer.toString((a * b / gcd(a, b))));
		
		br.close();
		bw.flush();
		bw.close();
	}
}
