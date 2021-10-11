import java.io.*;
import java.util.*;

public class Main
{
	static int r, c;
	static int[][] arr;

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new int[r][c];

		for (int i = 0; i < r; i++)
		{
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < c; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}

		if (r % 2 == 1)
		{
			for (int i = 0; i < r; i++)
			{
				for (int j = 0; j < c - 1; j++)
				{
					if (i % 2 == 0)
						sb.append("R");
					else
						sb.append("L");
				}

				if (i < r - 1)
					sb.append("D");
			}
		}
		else if ((r % 2 == 0) && (c % 2 == 1))
		{
			for (int i = 0; i < c; i++)
			{
				for (int j = 0; j < r - 1; j++)
				{
					if (i % 2 == 0)
						sb.append("D");
					else
						sb.append("U");
				}

				if (i < c - 1)
					sb.append("R");
			}
		}
		else
		{
			int minR = 0;
			int minC = 0;
			int min = 1001;

			for (int i = 0; i < r; i++)
			{
				int j;
				
				if (i % 2 == 0)
					j = 1;
				else
					j = 0;

				for (; j < c; j += 2)
				{
					if (arr[i][j] < min)
					{
						min = arr[i][j];
						minR = i;
						minC = j;
					}
				}
			}

			int startR = 0;
			int startC = 0;
			int endR = r - 1;
			int endC = c - 1;
			
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();

			while (endR - startR > 1)
			{
				if (startR + 1 < minR)
				{
					for (int i = 0; i < c - 1; i++)
						sb1.append("R");
					
					sb1.append("D");
					
					for (int i = 0; i < c - 1; i++)
						sb1.append("L");
					
					sb1.append("D");
					startR += 2;
				}

				if (minR + 1 < endR)
				{
					for (int i = 0; i < c - 1; i++)
						sb2.append("R");
					
					sb2.append("D");
					
					for (int i = 0; i < c - 1; i++)
						sb2.append("L");
					
					sb2.append("D");
					endR -= 2;
				}
			}

			while (endC - startC > 1)
			{
				if (startC + 1 < minC)
				{
					sb1.append("D");
					sb1.append("R");
					sb1.append("U");
					sb1.append("R");
					startC += 2;
				}

				if (minC + 1 < endC)
				{
					sb2.append("D");
					sb2.append("R");
					sb2.append("U");
					sb2.append("R");
					endC -= 2;
				}
			}

			if (minC == startC)
			{
				sb1.append("R");
				sb1.append("D");
			}
			else
			{
				sb1.append("D");
				sb1.append("R");
			}

			sb.append(sb1);
			sb.append(sb2.reverse());
		}

		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
