package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10828 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MyStatic myStatic = new MyStatic();

        int n;
        String order;

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            order = br.readLine();
            String[] orderArr = order.split(" ");
            if (orderArr[0].equals("push")) {
                myStatic.push(Integer.parseInt(orderArr[1]));
            } else if(orderArr[0].equals("top")){
                System.out.println(myStatic.top());
            } else if (orderArr[0].equals("size")) {
                System.out.println(myStatic.size());
            } else if (orderArr[0].equals("empty")) {
                System.out.println(myStatic.empty());
            } else if (orderArr[0].equals("pop")) {
                System.out.println(myStatic.pop());
            }

        }
    }

    public static class MyStatic{
        static int index = -1;
        static int[] restoreBox = new int[100000];

        public void push(int x){
            index++;
            restoreBox[index] = x;
        }

        public int pop(){
            return index == -1 ? -1:  restoreBox[index--];
        }

        public int size() {
            return index+1;
        }

        public int empty() {
            return index == -1 ? 1 : 0;
        }

        public int top() {
            return index == -1 ? -1:  restoreBox[index];
        }
    }
}
