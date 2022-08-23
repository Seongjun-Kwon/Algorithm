import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static class Food {
        int p, f, s, v, c;

        public Food(int p, int f, int s, int v, int c) {
            this.p = p;
            this.f = f;
            this.s = s;
            this.v = v;
            this.c = c;
        }
    }

    static int n;
    static int mp, mf, ms, mv;
    static Food[] food;
    static boolean[] vis;
    static int answer = Integer.MAX_VALUE;
    static ArrayList<String> foodNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        food = new Food[n];
        vis = new boolean[n];
        foodNum = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            food[i] = new Food(p, f, s, v, c);
        }

        for (int i = 1; i <= n; i++) {
            solve(0, 0, i);
        }

        Collections.sort(foodNum);

        if (answer == Integer.MAX_VALUE) {
            answer = -1;
            sb.append(answer);
        } else {
            sb.append(answer).append('\n').append(foodNum.get(0));
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    static void solve(int idx, int cnt, int chooseNum) {
        if (cnt == chooseNum) {
            int tmpP = 0, tmpF = 0, tmpS = 0, tmpV = 0, tmpC = 0;

            for (int i = 0; i < n; i++) {
                if (vis[i]) {
                    tmpP += food[i].p;
                    tmpF += food[i].f;
                    tmpS += food[i].s;
                    tmpV += food[i].v;
                    tmpC += food[i].c;
                }
            }

            if (tmpP >= mp && tmpF >= mf && tmpS >= ms && tmpV >= mv) {
                if (answer >= tmpC) {
                    if (answer > tmpC) {
                        foodNum.clear();
                    }

                    answer = tmpC;

                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < n; i++) {
                        if (vis[i]) {
                            sb.append(i + 1).append(' ');
                        }
                    }

                    foodNum.add(sb.toString());
                }
            }

            return;
        }

        for (int i = idx; i < n; i++) {
            if (vis[i]) {
                continue;
            }

            vis[i] = true;
            solve(i + 1, cnt + 1, chooseNum);
            vis[i] = false;
        }
    }
}
