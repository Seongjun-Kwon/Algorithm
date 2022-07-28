import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static class Fish {
        int r, c;
        int num;
        int dir;
        boolean isLive;

        public Fish(int r, int c, int num, int dir, boolean isLive) {
            this.r = r;
            this.c = c;
            this.num = num;
            this.dir = dir;
            this.isLive = isLive;
        }
    }

    static int[][] place;
    static Fish[] fish;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, -1, -1, -1, 0, 1, 1, 1};
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        place = new int[4][4];
        fish = new Fish[17];

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1;
                place[i][j] = num;
                fish[num] = new Fish(i, j, num, dir, true);
            }
        }

        int startFishNum = place[0][0];
        fish[startFishNum].isLive = false;
        int sharkDir = fish[startFishNum].dir;
        place[0][0] = -1;

        moveShark(0, 0, sharkDir, startFishNum);

        bw.write(Integer.toString(answer));
        br.close();
        bw.flush();
        bw.close();
    }

    static private void moveShark(int sharkR, int sharkC, int sharkDir, int eatSum) {
        if (answer < eatSum) {
            answer = eatSum;
        }

        int[][] copyPlace = new int[4][4];
        Fish[] copyFish = new Fish[17];
        copyArr(place, copyPlace, fish, copyFish);

        moveFish();

        for (int i = 1; i <= 3; i++) {
            int nr = sharkR + dr[sharkDir] * i;
            int nc = sharkC + dc[sharkDir] * i;

            if (nr < 0 || nc < 0 || nr >= 4 || nc >= 4 || place[nr][nc] == 0) {
                continue;
            }

            int eatFishNum = place[nr][nc];
            int nDir = fish[eatFishNum].dir;

            place[sharkR][sharkC] = 0;
            place[nr][nc] = -1;
            fish[eatFishNum].isLive = false;

            moveShark(nr, nc, nDir, eatSum + eatFishNum);

            place[sharkR][sharkC] = -1;
            place[nr][nc] = eatFishNum;
            fish[eatFishNum].isLive = true;
        }

        copyArr(copyPlace, place, copyFish, fish);
    }

    static void copyArr(int[][] place, int[][] copyPlace, Fish[] fish, Fish[] copyFish) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                copyPlace[i][j] = place[i][j];
            }
        }

        for (int i = 1; i < 17; i++) {
            copyFish[i] = new Fish(fish[i].r, fish[i].c, fish[i].num, fish[i].dir, fish[i].isLive);
        }
    }

    static private void moveFish() {
        for (int i = 1; i < 17; i++) {
            if (!fish[i].isLive) {
                continue;
            }

            int cnt = 0;
            int dir = fish[i].dir;
            Fish cur = fish[i];

            while (cnt < 8) {
                fish[i].dir = dir;
                int nr = cur.r + dr[dir];
                int nc = cur.c + dc[dir];

                if (nr < 0 || nc < 0 || nr >= 4 || nc >= 4) {
                    cnt++;
                    dir = (dir + 1) % 8;
                    continue;
                }

                int changeFishNum = place[nr][nc];

                if (changeFishNum == -1) {
                    cnt++;
                    dir = (dir + 1) % 8;
                    continue;
                } else if (changeFishNum == 0) {
                    place[nr][nc] = i;
                    place[cur.r][cur.c] = changeFishNum;
                    fish[i].r = nr;
                    fish[i].c = nc;
                    break;
                } else {
                    place[nr][nc] = i;
                    place[cur.r][cur.c] = changeFishNum;
                    fish[changeFishNum].r = cur.r;
                    fish[changeFishNum].c = cur.c;
                    fish[i].r = nr;
                    fish[i].c = nc;
                    break;
                }
            }
        }
    }
}
