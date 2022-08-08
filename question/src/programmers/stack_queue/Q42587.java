package programmers.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class Q42587 {
    public static void main(String[] args) {
        int[] pri = new int[]{2,1,3,2};
        int location = 2;
        System.out.println(solution(pri, location));
    }

    public static int solution(int[] priorities, int location) {
        //1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
        //2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
        //3. 그렇지 않으면 J를 인쇄합니다.
        //숫자가 클수록 중요도 높음

        //우선순위를 이용하여 workQueue에 넣기
        Queue<Work> q = new LinkedList();
        for (int i = 0; i < priorities.length; i++) {
            Work work = new Work();
            work.num = priorities[i];
            if (i == location) {
                work.flag = true;
            } else{
                work.flag = false;
            }
            q.add(work);
        }

        //현재의 요소가 가장 큰 값이고, flag가 true인 값
        int cnt = 0;
        boolean bigOneFlag = isTheBiggestOne(q);
        while(!(bigOneFlag && q.peek().flag == true)){
            if(bigOneFlag){
                q.poll();
                cnt++;
            } else{
                Work work = q.poll();
                q.add(work);
            }
            bigOneFlag = isTheBiggestOne(q);
        }

        return ++cnt;
    }

    private static boolean isTheBiggestOne(Queue<Work> q) {
        Work curWork = q.peek();
        int index = -1;
        for (Work work : q) {
            index++;
            if(index == 0) continue;
            //현재 요소보다 크면 바로 false리턴
            if(curWork.num < work.num) return false;

        }

        return true;
    }

    static class Work{
        int num;
        boolean flag;
    }
}
