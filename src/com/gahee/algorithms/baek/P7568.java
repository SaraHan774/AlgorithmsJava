package com.gahee.algorithms.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P7568 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Person> people = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            people.add(new Person(weight, height));
        }

        //등수를 나타내는 배열 arr 이다.
        int [] arr = new int[N];
        //자신보다 큰 사람의 수 + 1 이 등수이므로 일단 다 1로 채운다.
        Arrays.fill(arr, 1);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 매번 처음부터 다 비교한다. 어차피 자기 자신이면 compareTo 결과가 -1 이 나오므로.
                if(people.get(i).compareTo(people.get(j)) > 0){
                    //자신보다 덩치가 크다면 배열의 숫자를 1 증가시킨다.
                    arr[i] += 1;
                }
            }
        }
        //비교가 끝난 후 등수를 출력한다.
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
        br.close();
    }

    // Comparable 을 이용해 무게와 키가 둘 다 큰지 or 작은지 비교한다.
    static class Person implements Comparable{
        int weight;
        int height;

        public Person(int weight, int height){
            this.weight = weight;
            this.height = height;
        }

        @Override
        public int compareTo(Object o) {
            if(((Person)o).height > this.height &&
                    (((Person) o).weight) > this.weight){
                // 키, 몸무게 모두 클 경우에만 1 을 반환한다.
                return 1;
            }
            //같거나 작은 경우는 -1을 반환하도록 한다.
            return -1;
        }
    }
}
