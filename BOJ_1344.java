import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double A = Double.parseDouble(br.readLine()) / 100.0;
        double B = Double.parseDouble(br.readLine()) / 100.0;
        double[] perA = new double[19]; // perA[i] = A팀이 i골을 넣을 확률
        double[] perB = new double[19];

        perA[1] = combination(18, 1) * Math.pow(A, 1) * Math.pow((1.0 - A), 17);
        perB[1] = combination(18, 1) * Math.pow(B, 1) * Math.pow((1.0 - B), 17);

        for (int i = 2; i < 19; i++) {
            perA[i] = combination(18, i) * Math.pow(A, i) * Math.pow((1.0 - A), 18 - i);
            perB[i] = combination(18, i) * Math.pow(B, i) * Math.pow((1.0 - B), 18 - i);
        }

        double primePerA = perA[2] + perA[3] + perA[5] + perA[7] + perA[11] + perA[13] + perA[17];
        double primePerB = perB[2] + perB[3] + perB[5] + perB[7] + perB[11] + perB[13] + perB[17];

        double answer = primePerA + primePerB - primePerA * primePerB;

        bw.write(Double.toString(answer));
        br.close();
        bw.flush();
        bw.close();
    }

    static int combination(int n, int r) {
        if (r == 0 || r == n) {
            return 1;
        }

        return combination(n - 1, r - 1) + combination(n - 1, r);
    }
}
