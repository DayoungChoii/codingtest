package programmers.brutefoce;

public class Q42842 {
    public static void main(String[] args) {
        int[] solution = solution(24, 24);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int row, column;
        for (int i = 1; i <= yellow; i++) {
            //노란색을 나누었을 때 0이 아니면
            if(yellow % i == 0) {
                column = i;
                row = yellow / i;
                //(가로+2)*2 + 세로*2의 값이 brown이면 답은 가로+2, 세로+2
                if((column + 2) * 2 + row * 2 == brown){
                    answer[0] = row + 2;
                    answer[1] = column + 2;
                    break;
                }
            }
        }
        return answer;
    }

}
