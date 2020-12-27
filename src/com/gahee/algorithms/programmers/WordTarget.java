package com.gahee.algorithms.programmers;

import java.util.*;

public class WordTarget {

    public static void main(String[] args) {
        String [] words = {"hot", "dot", "dog", "lot", "log", "cog", "hht", "hit", "hih", "hog", "kog", "pwq", "hhh"};
        String [] words2 = {"hot", "dot", "dog", "lot"};
        String [] w = {"hot", "dot", "dog", "lot", "log"};
        String [] w2 = {"jams", "mama", "kame", "lamf", "aaad", "aakd"};

        String begin = "hit";
        String target = "hhh";

        int ans = solution(begin, target, words);
        System.out.println(ans);
    }

    public static int solution(String begin, String target, String[] words) {
        int answer;

        int len = words[0].length();
        if(begin.length() != len || target.length() != len){
            return 0;
        }

        Word [] wordsArr = new Word[words.length + 1];
        boolean containsBegin = false;
        int beginIdx = 0;

        for (int i = 0; i < words.length; i++) {
            wordsArr[i] = new Word(words[i]);

            if(words[i].equals(begin)){
                containsBegin = true;
                beginIdx = i;
            }
        }

        Word beginWord;

        if(!containsBegin) {
            beginWord = new Word(begin);
            wordsArr[words.length] = beginWord;
        }else{
            beginWord = wordsArr[beginIdx];
        }

        HashMap<String, ArrayList<Word>> graph = new HashMap<>();

        //build graph if second contains ..
        for (Word curWord : wordsArr) {
            if(curWord == null){
                continue;
            }
            ArrayList<Word> list = graph.get(curWord.original);

            if (list == null) {
                list = new ArrayList<>();
            }
            //비교 단어
            for (Word comp : wordsArr) {
                if(comp == null){
                    continue;
                }
                if (curWord.original.equals(comp.original)) {
                    continue;
                }
                //비교 대상의 두번째 배열
                HashSet<String>[] compSec = comp.second;
                if(list.contains(comp)){
                    continue;
                }
                if(curWord.containsSecond(compSec)){
                    list.add(comp);
                }
//                System.out.println(curWord + " / " + list);
            }
            graph.put(curWord.original, list);
        }
//        System.out.println(graph);
        answer = findShortestPath(beginWord, target, graph);
        return answer;
    }

    private static int findShortestPath(
            Word beginWord,
            String target,
            HashMap<String, ArrayList<Word>> graph) {
        //시작하는 단어를 한개씩 바꾸어야 함.
        //begin word 를 그래프에 추가해서 연결된 노드가 있는지 확인한다.

        Queue<Word> queue = new LinkedList<>();
        queue.add(beginWord);

        while(!queue.isEmpty()){
            Word s = queue.poll();
            s.visited = true;
            System.out.println("visited => " + s);
            ArrayList<Word> list = graph.get(s.original);

            if(!list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                    Word t = list.get(i);
                    if (!t.visited) {
                        t.visited = true;
                        queue.add(t);
                        t.dist = s.dist + 1;
                        System.out.println("visited " + t);

                        if (t.original.equals(target)) {
                            System.out.println("found target " + t);
                            return t.dist;
                        }
                    }
                }
            }else{
                return s.dist;
            }
        }
        return 0;
    }

    static class Word{
        String original;
        String [] first;
        HashSet<String> [] second;
        boolean visited;
        int dist = 0;

        public Word(String original){
            this.original = original;
            this.first = new String[original.length()];
            this.second = new HashSet[original.length()];
            this.buildFirst();
            this.buildSecond();
        }

        public boolean containsSecond(HashSet<String> [] comp){
            for (int i = 0; i < second.length; i++) {
                HashSet<String> c = comp[i];
                for (HashSet<String> c1 : second) {
                    if (c.equals(c1)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void buildFirst(){
            char [] arr = original.toCharArray();
            for (int i = 0; i < original.length(); i++) {
                first[i] = String.valueOf(arr[i]);
            }
        }

        public void buildSecond(){
            HashSet<String> set;
            char [] originalArr = original.toCharArray();
            for (int i = 0; i < first.length; i++) {
                set = new HashSet<>();
                String w = first[i];
                String skipped = "";
                for (char c : originalArr) {
                    String o = String.valueOf(c);
                    if (o.equals(w) && !skipped.equals(w)) {
                        skipped = w;
                        continue;
                    }
                    set.add(o);
                }
                second[i] = set;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Word word = (Word) o;
            return Objects.equals(original, word.original);
        }

        @Override
        public int hashCode() {
            return Objects.hash(original);
        }

        @Override
        public String toString() {
            return original + " " + dist;
        }
    }
}
