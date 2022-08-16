package programmers.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class Q1829 {
    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = new int[m][n];
        picture[0] = new int[]{1, 1, 1, 0};
        picture[1] = new int[]{1, 2, 2, 0};
        picture[2] = new int[]{1, 0, 0, 1};
        picture[3] = new int[]{0, 0, 0, 1};
        picture[4] = new int[]{0, 0, 0, 3};
        picture[5] = new int[]{0, 0, 0, 3};

        int[] solution = solution(m, n, picture);
        for (int i : solution) {
            System.out.println(i);
        }
    }
    //m,n 그림 크기
    //정답은 몇 개의 영역이 있는지, 가장 큰 영역은 몇 칸으로 이루어져 있는
    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] visited = new boolean[m][n];

        //주의 해야할 점은 각 영역이 숫자로 구분되어 있음
        //색깔이 안칠해져 있는 부분은 0

        //모든원소를 돌아보며 visited가 true이고 픽쳐가 0이 아닌 경우만 bfs시작
        int resultArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(picture[i][j] != 0 && visited[i][j] == false){
                    resultArea = bfs(picture, visited, m, n, new Location(i,j), picture[i][j]);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, resultArea);
                    numberOfArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static int bfs(int[][] picture, boolean[][] visited,int m, int n ,Location startLocation, int curColor) {
        int[] rowOp = new int[]{1,-1,0,0};
        int[] columnOp = new int[]{0,0,1,-1};
        int cnt = 0;
        //큐 만들어서 큐에 넣고 visited함
        Queue<Location> q = new LinkedList<>();
        q.add(startLocation);
        visited[startLocation.row][startLocation.column] = true;
        cnt++;

        int nextRow;
        int nextColumn;
        //q에 요소가 없을 때 까지
        while (!q.isEmpty()) {
            //현재 요소를 꺼내 4방향 좌표 만들고
            Location curLocation = q.poll();
            for (int i = 0; i < 4; i++) {
                nextRow = rowOp[i] + curLocation.row;
                nextColumn = columnOp[i] + curLocation.column;
                //유효한 요소인지 체크, 범위 내에 있어야하고, 현재의 색과 같아야하고, 픽쳐가 0이 아니여야하고, 방문한 적이 없어야
                if((nextRow >=0 && nextColumn >= 0 && nextRow <m &&nextColumn<n)
                    && picture[nextRow][nextColumn] == curColor
                    && picture[nextRow][nextColumn] != 0
                    && visited[nextRow][nextColumn] == false){
                    q.add(new Location(nextRow, nextColumn));
                    visited[nextRow][nextColumn] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static class Location{
        int row;
        int column;

        public Location(int row, int coulum) {
            this.row = row;
            this.column = coulum;
        }
    }
}
