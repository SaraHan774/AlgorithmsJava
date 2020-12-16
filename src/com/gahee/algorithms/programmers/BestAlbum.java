package com.gahee.algorithms.programmers;

import java.util.*;

public class BestAlbum {

    public static void main(String[] args) {
        String [] g = {"classic", "pop", "classic", "classic", "pop", "sample1"};
        int [] p = {500, 600, 150, 800, 2500, 100000};

        solution(g, p);
    }

    public static int[] solution(String[] genres, int[] plays) {
        int[] answer;

        HashMap<String, Genre> map = new HashMap<>();

        if(genres.length == 1){
            answer = new int[1];
            return answer;
        }

        for (int i = 0; i < genres.length; i++) {
            String key = genres[i];
            int play = plays[i];
            Music music = new Music(play, i);

            Genre g;
            if(!map.containsKey(key)){
                g = new Genre();
                //기본 생성자에서 큐를 초기화 해주어야 함!
                g.total += play;
                g.musicPriorityQueue.add(music);
            }else {
                g = map.get(key);
                g.musicPriorityQueue.add(music);
                g.total += play;
            }
            map.put(genres[i], g);
        }

        //보조 배열을 만들어서 맵의 엔트리들을 total 기준 내림차순으로 정렬해준다
        int subIdx = 0;
        Map.Entry<String, Genre> [] sub = new Map.Entry[map.size()];
        for (Map.Entry<String, Genre> entry : map.entrySet()) {
            sub[subIdx++] = entry;
        }
        Arrays.sort(sub, (o1, o2) ->
                -Integer.compare(o1.getValue().total, o2.getValue().total));

        //정답의 배열을 우선 맵 사이즈의 두배로 초기화
        answer = new int[map.size()*2];

        int idx = 0;
        for (Map.Entry<String, Genre> stringGenreEntry : sub) {
            PriorityQueue<Music> queue = stringGenreEntry.getValue().musicPriorityQueue;
            if(!queue.isEmpty()) {
                if (queue.size() == 1) {
                    answer[idx++] = queue.poll().id;
                } else{
                    answer[idx++] = queue.poll().id;
                    answer[idx++] = queue.poll().id;
                }
            }
        }

        //정답 배열의 인덱스가 채워진 곳 까지만 정답으로 반환한다.
        return Arrays.copyOfRange(answer, 0, idx);
    }

    static class Genre{
        PriorityQueue<Music> musicPriorityQueue;
        int total;

        //초기화 하는 것 까먹지 말기 !
        public Genre(){
            musicPriorityQueue = new PriorityQueue<>();
            total = 0;
        }
    }

    static class Music implements Comparable{
        int playCnt;
        int id;
        public Music(int pc, int id){
            playCnt = pc;
            this.id = id;
        }

        @Override
        public int compareTo(Object o) {
            //거꾸로 비교할 때는 순서 바꿔주기 !
            return Integer.compare(((Music) o).playCnt, this.playCnt);
        }
    }
}
