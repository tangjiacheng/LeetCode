package com.recall;

import com.recall.LetterCombinations;
import java.util.List;

public class test {
    public static void main(String[] args) {
//        LetterCombinations lc = new LetterCombinations();
//        List<String> list = lc.letterCombinations("852");
//        System.out.println(list);

        MovingCount mc = new MovingCount();
        System.out.println(mc.movingCount(18, 50, 50));
    }
}
