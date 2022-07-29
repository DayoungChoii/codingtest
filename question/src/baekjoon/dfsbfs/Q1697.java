package baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1697 {
    static int N, K;
    static int[] visited;
    public static void main(String[] args) {
        //N동생의 위치, K동생의 위치
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        visited = new int[100001];
        Arrays.fill(visited, -1);
        System.out.println(bfs(N));
    }

    public static int bfs(int n){
        //큐에 시작점 넣기 visited에 표시
        int fastestTime = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = 0;
        //while문에서 큐의 값이 없을 때 까지 경로탐색
        while(!q.isEmpty()) {
            Integer curX = q.poll();
            //위치가 k일 때 탈출
            if(curX == K) {
                fastestTime = visited[curX];
                break;
            }
            int nextX;
            //현재 위치에서 +1, -1, *2로 움직일 수 있음
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    nextX = curX  * 2;
                } else if (i == 1) {
                    nextX = curX + 1;
                }else{
                    nextX = curX - 1;
                }
                //범위 안에 있고, visited가 -1일 때 다음경로로 이동
                if ((nextX >= 0 && nextX <= 100000) && visited[nextX] == -1) {
                    q.add(nextX);
                    visited[nextX] = visited[curX] + 1;
                }
            }
        }
        return fastestTime;
    }
}
