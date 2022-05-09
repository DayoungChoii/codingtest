package programmers;

import java.util.ArrayList;
import java.util.List;

public class Q42840 {

    public static void main(String[] args) {
        int[] anwsers = {1,2,3,4,5};
        System.out.println(solution(anwsers));
    }

    public static int[] solution(int[] answers) {
        int answersLength = answers.length;

        int index;
        List<PersonInfo> personInfoList = new ArrayList<>(3);
        personInfoList.add(new PersonInfo(1,new int[] {1, 2, 3, 4, 5}));
        personInfoList.add(new PersonInfo(2, new int[]{2, 1, 2, 3, 2, 4, 2, 5}));
        personInfoList.add(new PersonInfo(3, new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}));

        for (int i = 0; i < answersLength; i++) {
            for(PersonInfo person : personInfoList){
                index = i % person.length;
                if(answers[i] == person.personAnswer[index]){
                    person.cnt++;
                }
            }
        }
        List<Integer> answerList = new ArrayList<>();

        int maxVal = Math.max(personInfoList.get(0).cnt, Math.max(personInfoList.get(1).cnt, personInfoList.get(2).cnt));
        if(maxVal== personInfoList.get(0).cnt){
            answerList.add(personInfoList.get(0).index);
        }
        if(maxVal == personInfoList.get(1).cnt){
            answerList.add(personInfoList.get(1).index);
        }
        if(maxVal == personInfoList.get(2).cnt){
            answerList.add(personInfoList.get(2).index);
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size() ;i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    public static class PersonInfo{
        int index;
        int cnt = 0;
        int[] personAnswer;
        int length;

        public PersonInfo(int index, int[] personAnswer) {
            this.index = index;
            this.personAnswer = personAnswer;
            this.length = personAnswer.length;
        }
    }
}


