package com.gahee.algorithms.baek;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P11650 {

    public static void main(String[] args) throws IOException {
        //2차원 평면 위의 점 N개, x좌표 증가 -> y좌표 증가 정렬 후 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        //좌표 값들을 저장한다.
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points.add(new Point(x, y));
        }

        Collections.sort(points);

        for (int i = 0; i < points.size(); i++) {
            System.out.println(points.get(i));
        }

        br.close();
    }
}

class Point implements Comparable{
    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y= y;
    }

    @Override
    public int compareTo(Object o) {
// x 좌표를 기준으로 정렬
//        if(this.x > ((Point) o).x){
//            return 1;
//        }else if(this.x ==  ((Point) o).x && this.y > ((Point) o).y){
//            return 1;
//        }else{
//            return -1;
//        }

        // y 좌표를 기준으로 정렬
        if(this.y > ((Point) o).y){
            return 1;
        }else if(this.y ==  ((Point) o).y && this.x > ((Point) o).x){
            return 1;
        }else{
            return -1;
        }
    }

    @Override
    public java.lang.String toString() {
        return x +" " + y;
    }
}
