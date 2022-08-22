package programmers.sort;

import java.util.Arrays;

public class Q42747 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{10, 9, 4, 1, 1}));
    }

    public static int solution(int[] citations) {
        //n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최대값이 h index
        //정렬
        Arrays.sort(citations);

        int h = 0;
        int referredPaperCnt, nonReferredPaperCnt;

        int theNumberOfPaper = citations.length;
        for (int i = citations[theNumberOfPaper-1]; i >= 0; i--) {
            referredPaperCnt = 0;
            nonReferredPaperCnt = 0;
            for (int j = 0; j < theNumberOfPaper; j++) {
                //현재 논문의 인용수가 전체 논문의 수 보다 크다면 나간다
//                if (citations[i] > theNumberOfPaper) break;
                //현재 h가 비교하는 논문의 인용수보다 작거나 같으면 인용논문 카운트 더하기
                if(i <= citations[j]) referredPaperCnt++;
                //현재 h가 비교하는 논문의 인용수보다 크면 인용논문 카운트 더하기
                if(i > citations[j]) nonReferredPaperCnt++;
            }
            if(referredPaperCnt >= i && nonReferredPaperCnt <= i) h = Math.max(h, i);
        }
        return h;
    }
}
