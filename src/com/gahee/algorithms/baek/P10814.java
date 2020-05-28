package com.gahee.algorithms.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P10814 {

    public static void main(String[] args) throws IOException {

        //나이와 이름이 가입한 순서대로 주어진다.
        //회원들 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에 오도록
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        ArrayList<Member> members = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            members.add(new Member(i, age, name));
        }

        Collections.sort(members);

        for (int i = 0; i < members.size(); i++) {
            System.out.println(members.get(i));
        }

        br.close();
    }
}

class Member implements Comparable{

    int order;
    int age;
    String name;

    public Member(int order, int age, String name) {
        this.order = order;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return age + " " + name;
    }

    @Override
    public int compareTo(Object o) {
        if(this.age > ((Member)o).age){
            //나이의 오름차순
            return 1;
        }else if(this.age == ((Member)o).age
                && this.order > ((Member)o).order){
            //나이가 같으면 순서의 오름차순
            return 1;
        }else{
            return -1;
        }
    }
}
