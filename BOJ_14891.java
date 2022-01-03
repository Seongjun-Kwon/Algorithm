import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] gear;
    static int k, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        gear = new int[4][8];
        ans = 0;

        for (int i = 0; i < 4; i++) {
            String[] str = br.readLine().split("");

            for (int j = 0; j < 8; j++) {
                gear[i][j] = Integer.parseInt(str[j]);
            }
        }

        k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            turnAllGear(num, dir);
        }

        getAnswer();

        bw.write(Integer.toString(ans));
        br.close();
        bw.flush();
        bw.close();
    }

    static void turnAllGear(int num, int dir) {
        int[] dirTmp = new int[4];
        dirTmp[num] = dir;

        for (int i = num; i < 3; i++) {
            if (gear[i][2] != gear[i + 1][6]) {
                dirTmp[i + 1] = -1 * dirTmp[i];
            }
        }

        for (int i = num; i > 0; i--) {
            if (gear[i][6] != gear[i - 1][2]) {
                dirTmp[i - 1] = -1 * dirTmp[i];
            }
        }

        for (int i = 0; i < 4; i++) {
            if (dirTmp[i] != 0) {
                turnOneGear(i, dirTmp[i]);
            }
        }
    }

    static void turnOneGear(int num, int dir) {
        int[] tmp = new int[8];

        if (dir == 1) { // 시계 방향
            for (int i = 0; i < 8; i++) {
                tmp[(i + 1) % 8] = gear[num][i];
            }
        } else if (dir == -1) { // 반시계 방향
            for (int i = 0; i < 8; i++) {
                tmp[i] = gear[num][(i + 1) % 8];
            }
        }

        for (int i = 0; i < 8; i++) {
            gear[num][i] = tmp[i];
        }
    }

    static void getAnswer() {
        for (int i = 0; i < 4; i++) {
            if (gear[i][0] == 1) {
                ans += Math.pow(2, i);
            }
        }
    }
}
