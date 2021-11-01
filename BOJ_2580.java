import java.io.*;
import java.util.*;

public class Main
{
	static StringBuilder sb = new StringBuilder();
	static int[][] arr;

	static boolean isPossible(int row, int col, int val)
	{
		for (int i = 0; i < 9; i++)
		{
			if (arr[row][i] == val)
				return false;
		}

		for (int i = 0; i < 9; i++)
		{
			if (arr[i][col] == val)
				return false;
		}

		int rowStart = (row / 3) * 3;
		int colStart = (col / 3) * 3;

		for (int i = rowStart; i < rowStart + 3; i++)
		{
			for (int j = colStart; j < colStart + 3; j++)
			{
				if (arr[i][j] == val)
					return false;
			}
		}

		return true;
	}

	static void solve(int row, int col)
	{
		if (row == 9)
		{
			for (int i = 0; i < 9; i++)
			{
				for (int j = 0; j < 9; j++)
					sb.append(arr[i][j] + " ");
				
				sb.append("\n");
			}

			System.out.println(sb);
			System.exit(0);
		}

		if (col == 9)
		{
			solve(row + 1, 0);
			return;
		}

		if (arr[row][col] == 0)
		{
			for (int i = 1; i <= 9; i++)
			{
				if (isPossible(row, col, i))
				{
					arr[row][col] = i;
					solve(row, col + 1);
				}
			}

			arr[row][col] = 0;
			return;
		}

		solve(row, col + 1);
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		arr = new int[9][9];

		for (int i = 0; i < 9; i++)
		{
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 9; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}

		solve(0, 0);
	}
}
