package programmers.dfsbfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q1844 {
    public static void main(String[] args) {
        int[][] maps = new int[5][5];
        maps[0] = new int[]{1, 0, 1, 1, 1};
        maps[1] = new int[]{1, 0, 1, 0, 1};
        maps[2] = new int[]{1, 0, 1, 1, 1};
        maps[3] = new int[]{1, 1, 1, 0, 1};
        maps[4] = new int[]{0, 0, 0, 0, 1};
        System.out.println(solution(maps));

    }

    public static int solution(int[][] maps) {
        int h, w, answer;
        h = maps.length;
        w = maps[0].length;
        int[][] visited = new int[h][w];
        for (int i = 0; i < maps.length; i++) {
            Arrays.fill(visited[i], 0);
        }
        //bfs로 경로를 탐색 후, visited n-1,m-1자리를 방문하지 않았으면 return -1
        int shortcutCount = bfs(new Location(0, 0), maps,visited, h, w);
        if(shortcutCount == 0){
            answer = -1;
        } else {
            answer = shortcutCount;
        }
        return answer;
    }

    public static int bfs(Location location,int[][] maps,int[][] visited,int h, int w){
        //큐와 오퍼레이터
        int[] rowOp = new int[]{1, -1, 0, 0};
        int[] columnOp = new int[]{0, 0, 1, -1};
        Queue<Location> q = new LinkedList<>();
        q.add(location);
        visited[location.row][location.column] = 1;

        //while문
        while (!q.isEmpty()) {
            Location curLocation = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextRow = curLocation.row + rowOp[i];
                int nextColumn = curLocation.column+ columnOp[i];
                //큐에서 하나 꺼내, 루프 돌며,범위 안이고, 벽이 아니고, 방문하지 않은 곳이면 방문
                if((nextRow>=0&&nextColumn>=0&&nextRow<h&&nextColumn<w)
                    && maps[nextRow][nextColumn] == 1
                    && visited[nextRow][nextColumn] == 0){
                    //큐에 넣어주고, visited에 depth 표시
                    q.add(new Location(nextRow, nextColumn));
                    visited[nextRow][nextColumn] = visited[curLocation.row][curLocation.column] + 1;
                }
            }
        }
        return visited[h - 1][w - 1];
    }

    public static class Location{
        int row;
        int column;

        public Location(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
