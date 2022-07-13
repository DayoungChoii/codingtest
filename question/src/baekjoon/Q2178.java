package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q2178 {

    static int[][] map;
    static boolean[][] visited;
    static Point[] operator = new Point[4];
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String mapInfo = br.readLine();
        String[] mapInfoArr = mapInfo.split(" ");
        N = Integer.parseInt(mapInfoArr[0]);
        M = Integer.parseInt(mapInfoArr[1]);

        map = new int[N][M];
        visited = new boolean[N][M];

        operator[0] = new Point(-1, 0);
        operator[1] = new Point(1, 0);
        operator[2] = new Point(0, -1);
        operator[3] = new Point(0, 1);

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            Arrays.fill(visited[i], false);
            for (int j = 0; j < M; j++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }

        System.out.println(bfs(new Point(0, 0, 1)));
    }

    static int bfs(Point point){
        Queue<Point> q = new LinkedList<>();
        int x;
        int y;
        int answer = 0;

        visited[point.x][point.y] = true;
        q.add(point);

        while(!q.isEmpty()){
            Point curPoint = q.poll();
            for (int i = 0; i < 4; i++) {
                x = curPoint.x + operator[i].x;
                y = curPoint.y + operator[i].y;
                if((x >= 0 && y >= 0 && x < N && y < M) && map[x][y] == 1 && visited[x][y] == false){
                    if(x == N-1 && y == M-1)answer = curPoint.depth+1;
                    visited[x][y] = true;
                    q.add(new Point(x, y, curPoint.depth + 1));

                }
            }
        }
        return answer;
    }

    static class Point{
        int x;
        int y;
        int depth;

        public Point(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
