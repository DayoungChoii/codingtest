package programmers.lv1;

import java.util.Stack;

public class Q64061 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[]{1,5,3,5,1,2,1,4}));
    }

    public static int solution(int[][] board, int[] moves) {
        Stack<Integer> resultStack = new Stack<>();
        int cnt = 0;
        for (int i = 0; i < moves.length; i++) {
            int colIndex = moves[i] - 1;
            for (int j = 0; j < board[colIndex].length; j++) {
                int curItem = board[j][colIndex];
                if (curItem != 0) {
                    if (!resultStack.isEmpty() && resultStack.peek() == curItem) {
                        resultStack.pop();
                        cnt += 2;
                    } else {
                        resultStack.add(curItem);
                    }
                    board[j][colIndex] = 0;
                    break;
                }
            }
        }

        return cnt;
    }
}
