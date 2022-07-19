package programmers.dfsbfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q43162 {
    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        arr[0] = new int[]{1, 1, 0};
        arr[1] = new int[]{1, 1, 0,};
        arr[2] = new int[]{0, 0, 1,};

        System.out.println(solution(3, arr));
    }
    static boolean visited[];
    public static int solution(int n, int[][] computers) {
        int cnt = 0;
        visited = new boolean[n];
        Arrays.fill(visited, false);
        //visited배열을 돌며 네트워크를 찾는다.
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                bfs(i, n, computers);
                cnt++;
            }
        }
        return cnt;
    }
    //현재 컴퓨터 번호를 받아 이어진 컴퓨터를 체크
    public static void bfs(int v, int n, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;

        while(!q.isEmpty()){
            int curComputer = q.poll();
            //루프를 돌며 computers에 연결된 컴퓨터들 방문
            for (int i = 0; i < n; i++) {
                //방문하지 않은 컴퓨터면 방문
                if(computers[curComputer][i] == 1&& !visited[i]){
                    //방문한 컴퓨터 체크, 큐에 넣어주기
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
