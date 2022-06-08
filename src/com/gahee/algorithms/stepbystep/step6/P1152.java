package com.gahee.algorithms.stepbystep.step6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1152 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        char [] chars = line.toCharArray();

        int k = 0;
        int word = 0;
        for (char c : chars) {
            if (c != ' ') {
                // if there is an alphabet, increment k
                k++;
            } else {
                // if there is no alphabet,
                // check if k is not 0
                // in other words, check if there was a word
                // right before a blank character.
                if (k != 0) {
                    word++;
                    // increment the word count
                    k = 0;
                    // initialize k to 0 for counting the next word
                }
            }
        }
        // lastly, if k is still not 0, then it means there was a word
        // right before the termination of the above for loop.
        if (k != 0) {
            word++;
        }
        System.out.println(word);
    }
}
