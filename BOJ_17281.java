import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] battersInfo;
    static int[] order; // order[i] = j : i번 타자는 j번 선수임
    static boolean[] select;
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        battersInfo = new int[n][10];
        order = new int[10];
        select = new boolean[10];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= 9; j++) {
                battersInfo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        order[4] = 1;
        select[1] = true;
        makeOrder(1);

        bw.write(Integer.toString(ans));
        br.close();
        bw.flush();
        bw.close();
    }

    static public void makeOrder(int num) { // 타순 정하기
        if (num == 4) {
            makeOrder(num + 1);
            return;
        }

        if (num == 10) {
            getScore();
            return;
        }

        for (int i = 2; i <= 9; i++) {
            if (select[i]) {
                continue;
            }

            order[num] = i;
            select[i] = true;
            makeOrder(num + 1);
            select[i] = false;
        }
    }

    static public void getScore() {
        int batter = 1;
        int score = 0;

        for (int i = 0; i < n; i++) {
            // 이닝마다 아웃, 주자 초기화
            int out = 0;
            boolean[] base = new boolean[4];

            while (out < 3) {
                int batterAction = battersInfo[i][order[batter]];

                if (batterAction == 0) { // 아웃
                    out++;

                } else if (batterAction == 1) { // 1루타의 경우
                    for (int j = 3; j >= 1; j--) {
                        if (base[j]) {
                            if (j == 3) { // 3루에 주자가 있을 경우
                                score++;
                                base[j] = false;
                                continue;
                            }

                            // 1, 2루에 주자가 있을 경우
                            base[j] = false;
                            base[j + 1] = true;
                        }
                    }
                    base[1] = true;

                } else if (batterAction == 2) { // 2루타의 경우
                    for (int j = 3; j >= 1; j--) {
                        if (base[j]) {
                            if (j == 3 || j == 2) { // 2, 3루에 주자가 있을 경우
                                score++;
                                base[j] = false;
                                continue;
                            }

                            // 1루에 주자가 있는 경우
                            base[j] = false;
                            base[j + 2] = true;
                        }
                    }
                    base[2] = true;

                } else if (batterAction == 3) { // 3루타의 경우
                    for (int j = 3; j >= 1; j--) {
                        if (base[j]) {
                            score++;
                            base[j] = false;
                            continue;
                        }
                    }
                    base[3] = true;

                } else { // 홈런의 경우
                    for (int j = 3; j >= 1; j--) {
                        if (base[j]) {
                            score++;
                            base[j] = false;
                        }
                    }
                    score++;
                }

                batter = (batter % 9) + 1;
            }
        }

        if (score > ans) {
            ans = score;
        }
    }
}
