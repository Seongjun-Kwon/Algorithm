import java.io.*;
import java.util.*;

public class Main
{
	static double getDistance(double x1, double y1, double x2, double y2)
	{
		double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
		return distance;
	}

	static int inteval = 1000000;

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		double ax = Integer.parseInt(st.nextToken());
		double ay = Integer.parseInt(st.nextToken());
		double bx = Integer.parseInt(st.nextToken());
		double by = Integer.parseInt(st.nextToken());
		double cx = Integer.parseInt(st.nextToken());
		double cy = Integer.parseInt(st.nextToken());
		double dx = Integer.parseInt(st.nextToken());
		double dy = Integer.parseInt(st.nextToken());
		
		double MinhoDisX = (bx - ax) / inteval;
		double MinhoDisY = (by - ay) / inteval;
		double KanghoDisX = (dx - cx) / inteval;
		double KanghoDisY = (dy - cy) / inteval;
		
		int lo = 0;
		int hi = inteval;

		while (lo + 2 < hi)
		{
			int p = (2 * lo + hi) / 3;
			int q = (lo + 2 * hi) / 3;
			
			double pVal = getDistance(ax + MinhoDisX * p, ay + MinhoDisY * p, cx + KanghoDisX * p, cy + KanghoDisY * p);
			double qVal = getDistance(ax + MinhoDisX * q, ay + MinhoDisY * q, cx + KanghoDisX * q, cy + KanghoDisY * q);
			
			if (pVal > qVal)
				lo = p;
			
			else
				hi = q;
		}

		double min = getDistance(ax + MinhoDisX * hi, ay + MinhoDisY * hi, cx + KanghoDisX * hi, cy + KanghoDisY * hi);

		for (int i = lo; i < hi; i++)
		{
			double tmp = getDistance(ax + MinhoDisX * i, ay + MinhoDisY * i, cx + KanghoDisX * i, cy + KanghoDisY * i);
			if(tmp < min)
				min = tmp;
		}

		bw.write(Double.toString(min));
		br.close();
		bw.flush();
		bw.close();
	}
}
