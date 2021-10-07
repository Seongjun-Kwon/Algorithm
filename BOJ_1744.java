import java.io.*;
import java.util.*;

public class Main
{
	static int n, sum, cntPlus, cntMinus, cntOne;
	static boolean hasZero;
	static ArrayList<Integer> arrPlus;
	static ArrayList<Integer> arrMinus;

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		sum = 0;
		cntPlus = 0;
		cntMinus = 0;
		cntOne = 0;
		arrPlus = new ArrayList<>();
		arrMinus = new ArrayList<>();

		for (int i = 0; i < n; i++)
		{
			int tmp = Integer.parseInt(br.readLine());

			if (tmp > 0)
			{
				if (tmp == 1)
				{
					cntOne++;
					continue;
				}

				arrPlus.add(tmp);
				cntPlus++;
			}
			else
			{
				if (tmp == 0)
				{
					hasZero = true;
					continue;
				}

				arrMinus.add(tmp);
				cntMinus++;
			}
		}

		Collections.sort(arrPlus);
		Collections.sort(arrMinus);

		if (cntPlus % 2 == 0)
		{
			for (int i = arrPlus.size() - 1; i > 0; i -= 2)
				sum += arrPlus.get(i) * arrPlus.get(i - 1);
			
			sum += cntOne;
		}
		else
		{
			for (int i = arrPlus.size() - 1; i > 1; i -= 2)
				sum += arrPlus.get(i) * arrPlus.get(i - 1);
			
			sum += arrPlus.get(0);
			sum += cntOne;
		}

		if (cntMinus % 2 == 0)
		{
			for (int i = 0; i < arrMinus.size() - 1; i += 2)
				sum += arrMinus.get(i) * arrMinus.get(i + 1);
		}
		else
		{
			if (hasZero)
			{
				for (int i = 0; i < arrMinus.size() - 2; i += 2)
					sum += arrMinus.get(i) * arrMinus.get(i + 1);
			}
			else
			{
				for (int i = 0; i < arrMinus.size() - 2; i += 2)
					sum += arrMinus.get(i) * arrMinus.get(i + 1);
				
				sum += arrMinus.get(arrMinus.size() - 1);
			}
		}

		bw.write(Integer.toString(sum));
		br.close();
		bw.flush();
		bw.close();
	}
}
