package com.example.yaz2lab2java;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// level here

public enum InitialState implements LevelSettings{
    EMPTY {
        @Override
        public List<SubLevel> getSubLevels() {
            return Collections.emptyList();
        }
    },
    LEVEL_1 {
        @Override
        public List<SubLevel> getSubLevels() {
            SubLevel sl1 = new SubLevel(1,0);
            Word w1 = new Word("ÇAM");
            Word w2 = new Word("MAÇ");
            // ambiguous method name !!!
            sl1.setLetters("AMÇ");

            List<LetterRect> lr1 = w1.getLetterRects();
            List<LetterRect> lr2 = w2.getLetterRects();

            lr1.add(new LetterRect(4,4,'Ç'));
            lr1.add(new LetterRect(5,4,'A'));
            lr1.add(new LetterRect(6,4,'M'));

            lr2.add(new LetterRect(5,3,'M'));
            lr2.add(new LetterRect(5,4,'A'));
            lr2.add(new LetterRect(5,5,'Ç'));

            w1.setLetterRects(lr1);
            w2.setLetterRects(lr2);

            sl1.getWordList().add(w1);
            sl1.getWordList().add(w2);

            SubLevel sl2 =  new SubLevel(1,1);
            Word w3 = new Word("TUŞ");
            Word w4 = new Word("ŞUT");
            // ambiguous method name !!!
            sl2.setLetters("ŞTU");

            List<LetterRect> lr3 = w3.getLetterRects();
            List<LetterRect> lr4 = w4.getLetterRects();

            lr3.add(new LetterRect(2,2,'T'));
            lr3.add(new LetterRect(3,2,'U'));
            lr3.add(new LetterRect(4,2,'Ş'));

            lr4.add(new LetterRect(4,2,'Ş'));
            lr4.add(new LetterRect(4,3,'U'));
            lr4.add(new LetterRect(4,4,'T'));

            w3.setLetterRects(lr3);
            w4.setLetterRects(lr4);

            sl2.getWordList().add(w3);
            sl2.getWordList().add(w4);

            return Arrays.asList(sl1, sl2);
        }
    },
    LEVEL_2 {
        @Override
        public List<SubLevel> getSubLevels() {
            SubLevel g1 = new SubLevel(2,0);
            SubLevel g2 = new SubLevel(2,1);
            return Arrays.asList(g1, g2);
        }
    },
    LEVEL_3 {
        @Override
        public List<SubLevel> getSubLevels() {
            SubLevel g1 = new SubLevel(3,0);
            SubLevel g2 = new SubLevel(3,1);
            return Arrays.asList(g1, g2);
        }
    };
}
