package baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q11048 {
    //미로크기
    static int N,M;
    static int[][] miro;
    static int[][] visited;
    static int[] rowOp = {1, 0};
    static int[] columnOp = {0, 1};
    public static void main(String[] args) throws IOException {
        //방에 있는 사탕의 최대갯수
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        String[] strArr;

        str = br.readLine();
        strArr = str.split(" ");
        N = Integer.parseInt(strArr[0]);
        M = Integer.parseInt(strArr[1]);

        miro = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            str = br.readLine();
            strArr = str.split(" ");
            Arrays.fill(visited[i], -1);
            for (int j = 0; j < M; j++) {
                miro[i][j] = Integer.parseInt(strArr[j]);
            }
        }

        System.out.println(bfs(new Location(0,0)));
        //bfs로 탐색
    }

    public static int bfs(Location location){
        //Q만들기, Q에 넣고, visited에 표시
        Queue<Location> q = new LinkedList<>();
        q.add(location);
        visited[location.row][location.column] = miro[location.row][location.column];

        //Q에서 없어질 때까지 수행
        int nextRow;
        int nextColumn;
        while(!q.isEmpty()) {
            //Q에서 하나 빼서 움직일 수 있는 범위에서 범위 내에 있으
            Location curLocation = q.poll();
            for (int i = 0; i < 2; i++) {
                nextRow = curLocation.row + rowOp[i];
                nextColumn = curLocation.column + columnOp[i];
                if (nextRow >= 0 && nextColumn >= 0 && nextRow < N && nextColumn < M) {
                    //visited에 들어간 값 중 큰 값으로 바꾸기
                    int oldVisitedVal = visited[nextRow][nextColumn];
                    int newVisitedVal = miro[nextRow][nextColumn] + visited[curLocation.row][curLocation.column];

                    if (oldVisitedVal == -1 || (oldVisitedVal < newVisitedVal)) {
                        visited[nextRow][nextColumn] = newVisitedVal;
                        q.add(new Location(nextRow, nextColumn));
                    }
                }
            }
        }
        return visited[N - 1][M - 1];
    }

    static class Location{
        int row;
        int column;

        public Location(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
