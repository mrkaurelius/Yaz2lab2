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
            {
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
            }

            //

            SubLevel sl2 =  new SubLevel(1,1);
            {
                Word w1 = new Word("TUŞ");
                Word w2 = new Word("ŞUT");
                // ambiguous method name !!!
                sl2.setLetters("ŞTU");

                List<LetterRect> lr1 = w1.getLetterRects();
                List<LetterRect> lr2 = w2.getLetterRects();

                lr1.add(new LetterRect(2,2,'T'));
                lr1.add(new LetterRect(3,2,'U'));
                lr1.add(new LetterRect(4,2,'Ş'));

                lr2.add(new LetterRect(4,2,'Ş'));
                lr2.add(new LetterRect(4,3,'U'));
                lr2.add(new LetterRect(4,4,'T'));

                w1.setLetterRects(lr1);
                w2.setLetterRects(lr2);

                sl2.getWordList().add(w1);
                sl2.getWordList().add(w2);
            }

            //

            SubLevel sl3 =  new SubLevel(1,2);
            {
                Word w1 = new Word("KAŞ");
                Word w2 = new Word("AŞK");
                sl3.setLetters("ŞAK");

                List<LetterRect> lr1 = w1.getLetterRects();
                List<LetterRect> lr2 = w2.getLetterRects();

                lr1.add(new LetterRect(1,1,'K'));
                lr1.add(new LetterRect(2,1,'A'));
                lr1.add(new LetterRect(3,1,'Ş'));

                lr2.add(new LetterRect(2,1,'A'));
                lr2.add(new LetterRect(2,2,'Ş'));
                lr2.add(new LetterRect(2,3,'K'));

                w1.setLetterRects(lr1);
                w2.setLetterRects(lr2);

                sl3.getWordList().add(w1);
                sl3.getWordList().add(w2);
            }

            SubLevel sl4 =  new SubLevel(1,3);
            {
                Word w1 = new Word("NEŞE");
                Word w2 = new Word("ŞEN");
                sl4.setLetters("ŞNE");

                List<LetterRect> lr1 = w1.getLetterRects();
                List<LetterRect> lr2 = w2.getLetterRects();

                lr1.add(new LetterRect(1,1,'N'));
                lr1.add(new LetterRect(2,1,'E'));
                lr1.add(new LetterRect(3,1,'Ş'));
                lr1.add(new LetterRect(4,1,'E'));

                lr2.add(new LetterRect(3,1,'Ş'));
                lr2.add(new LetterRect(3,2,'E'));
                lr2.add(new LetterRect(3,3,'N'));

                w1.setLetterRects(lr1);
                w2.setLetterRects(lr2);

                sl4.getWordList().add(w1);
                sl4.getWordList().add(w2);
            }

            SubLevel sl5 =  new SubLevel(1,4);
            {
                Word w1 = new Word("AMCA");
                Word w2 = new Word("AMA");
                Word w3 = new Word("CAM");

                sl5.setLetters("ACM");

                List<LetterRect> lr1 = w1.getLetterRects();
                List<LetterRect> lr2 = w2.getLetterRects();
                List<LetterRect> lr3 = w3.getLetterRects();


                lr1.add(new LetterRect(1,1,'A'));
                lr1.add(new LetterRect(2,1,'M'));
                lr1.add(new LetterRect(3,1,'C'));
                lr1.add(new LetterRect(4,1,'A'));

                lr2.add(new LetterRect(1,1,'A'));
                lr2.add(new LetterRect(1,2,'M'));
                lr2.add(new LetterRect(1,3,'A'));

                lr3.add(new LetterRect(3,1,'C'));
                lr3.add(new LetterRect(3,2,'A'));
                lr3.add(new LetterRect(3,3,'M'));


                w1.setLetterRects(lr1);
                w2.setLetterRects(lr2);
                w3.setLetterRects(lr3);


                sl5.getWordList().add(w1);
                sl5.getWordList().add(w2);
                sl5.getWordList().add(w3);
            }

            return Arrays.asList(sl1,sl2,sl3,sl4,sl5);
        }
    },
    LEVEL_2 {
        @Override
        public List<SubLevel> getSubLevels() {
            SubLevel sl1 = new SubLevel(2,0);
            {
                Word w1 = new Word("DİNÇ");
                Word w2 = new Word("ÇİN");
                // ambiguous method name !!!
                sl1.setLetters("DÇNİ");

                List<LetterRect> lr1 = w1.getLetterRects();
                List<LetterRect> lr2 = w2.getLetterRects();

                lr1.add(new LetterRect(1,1,'D'));
                lr1.add(new LetterRect(2,1,'İ'));
                lr1.add(new LetterRect(3,1,'N'));
                lr1.add(new LetterRect(4,1,'Ç'));

                lr2.add(new LetterRect(4,1,'Ç'));
                lr2.add(new LetterRect(4,2,'İ'));
                lr2.add(new LetterRect(4,3,'N'));

                w1.setLetterRects(lr1);
                w2.setLetterRects(lr2);

                sl1.getWordList().add(w1);
                sl1.getWordList().add(w2);
            }

            SubLevel sl2 = new SubLevel(2,1);
            {
                Word w1 = new Word("RÜYA");
                Word w3 = new Word("RAY");
                Word w2 = new Word("YAR");

                // ambiguous method name !!!
                sl2.setLetters("ÜRYA");

                List<LetterRect> lr1 = w1.getLetterRects();
                List<LetterRect> lr2 = w2.getLetterRects();
                List<LetterRect> lr3 = w3.getLetterRects();

                lr1.add(new LetterRect(1,1,'R'));
                lr1.add(new LetterRect(2,1,'Ü'));
                lr1.add(new LetterRect(3,1,'Y'));
                lr1.add(new LetterRect(4,1,'A'));

                lr2.add(new LetterRect(1,3,'Y'));
                lr2.add(new LetterRect(2,3,'A'));
                lr2.add(new LetterRect(3,3,'R'));

                lr3.add(new LetterRect(1,1,'R'));
                lr3.add(new LetterRect(1,2,'A'));
                lr3.add(new LetterRect(1,3,'Y'));


                w1.setLetterRects(lr1);
                w2.setLetterRects(lr2);
                w3.setLetterRects(lr3);

                sl2.getWordList().add(w1);
                sl2.getWordList().add(w2);
                sl2.getWordList().add(w3);
            }

            SubLevel sl3 = new SubLevel(2,2);
            {
                Word w1 = new Word("TÜM");
                Word w2 = new Word("TİM");
                Word w3 = new Word("MİT");
                Word w4 = new Word("ÜMİT");

                sl3.setLetters("TİMÜ");

                List<LetterRect> lr1 = w1.getLetterRects();
                List<LetterRect> lr2 = w2.getLetterRects();
                List<LetterRect> lr3 = w3.getLetterRects();
                List<LetterRect> lr4 = w4.getLetterRects();

                lr1.add(new LetterRect(2,1,'T'));
                lr1.add(new LetterRect(3,1,'Ü'));
                lr1.add(new LetterRect(4,1,'M'));

                lr2.add(new LetterRect(2,1,'T'));
                lr2.add(new LetterRect(2,2,'İ'));
                lr2.add(new LetterRect(2,3,'M'));

                lr3.add(new LetterRect(4,1,'M'));
                lr3.add(new LetterRect(4,2,'İ'));
                lr3.add(new LetterRect(4,3,'T'));

                lr4.add(new LetterRect(1,3,'Ü'));
                lr4.add(new LetterRect(2,3,'M'));
                lr4.add(new LetterRect(3,3,'İ'));
                lr4.add(new LetterRect(4,3,'T'));


                w1.setLetterRects(lr1);
                w2.setLetterRects(lr2);
                w3.setLetterRects(lr3);
                w4.setLetterRects(lr4);

                sl3.getWordList().add(w1);
                sl3.getWordList().add(w2);
                sl3.getWordList().add(w3);
                sl3.getWordList().add(w4);
            }

            SubLevel sl4 = new SubLevel(2,3);
            {
                Word w1 = new Word("CEZA");
                Word w2 = new Word("CAZ");
                Word w3 = new Word("ECZA");
                Word w4 = new Word("EZA");

                sl4.setLetters("EACZ");

                List<LetterRect> lr1 = w1.getLetterRects();
                List<LetterRect> lr2 = w2.getLetterRects();
                List<LetterRect> lr3 = w3.getLetterRects();
                List<LetterRect> lr4 = w4.getLetterRects();

                lr1.add(new LetterRect(2,1,'C'));
                lr1.add(new LetterRect(2,2,'E'));
                lr1.add(new LetterRect(2,3,'Z'));
                lr1.add(new LetterRect(2,4,'A'));

                lr2.add(new LetterRect(1,4,'C'));
                lr2.add(new LetterRect(2,4,'A'));
                lr2.add(new LetterRect(3,4,'Z'));

                lr3.add(new LetterRect(2,2,'E'));
                lr3.add(new LetterRect(3,2,'C'));
                lr3.add(new LetterRect(4,2,'Z'));
                lr3.add(new LetterRect(5,2,'A'));


                lr4.add(new LetterRect(4,1,'E'));
                lr4.add(new LetterRect(4,2,'Z'));
                lr4.add(new LetterRect(4,3,'A'));


                w1.setLetterRects(lr1);
                w2.setLetterRects(lr2);
                w3.setLetterRects(lr3);
                w4.setLetterRects(lr4);

                sl4.getWordList().add(w1);
                sl4.getWordList().add(w2);
                sl4.getWordList().add(w3);
                sl4.getWordList().add(w4);
            }

            SubLevel sl5 = new SubLevel(2,4);
            {
                Word w1 = new Word("OBA");
                Word w2 = new Word("BOYA");
                Word w3 = new Word("BOY");
                Word w4 = new Word("BAY");
                Word w5 = new Word("OYA");

                sl5.setLetters("YABO");

                List<LetterRect> lr1 = w1.getLetterRects();
                List<LetterRect> lr2 = w2.getLetterRects();
                List<LetterRect> lr3 = w3.getLetterRects();
                List<LetterRect> lr4 = w4.getLetterRects();
                List<LetterRect> lr5 = w5.getLetterRects();

                lr1.add(new LetterRect(3,1,'O'));
                lr1.add(new LetterRect(4,1,'B'));
                lr1.add(new LetterRect(5,1,'A'));

                lr2.add(new LetterRect(2,3,'B'));
                lr2.add(new LetterRect(3,3,'O'));
                lr2.add(new LetterRect(4,3,'Y'));
                lr2.add(new LetterRect(5,3,'A'));

                lr3.add(new LetterRect(4,1,'B'));
                lr3.add(new LetterRect(4,2,'O'));
                lr3.add(new LetterRect(4,3,'Y'));

                lr4.add(new LetterRect(2,3,'B'));
                lr4.add(new LetterRect(2,4,'A'));
                lr4.add(new LetterRect(2,5,'Y'));

                lr5.add(new LetterRect(1,5,'O'));
                lr5.add(new LetterRect(2,5,'Y'));
                lr5.add(new LetterRect(3,5,'A'));

                w1.setLetterRects(lr1);
                w2.setLetterRects(lr2);
                w3.setLetterRects(lr3);
                w4.setLetterRects(lr4);
                w5.setLetterRects(lr5);

                sl5.getWordList().add(w1);
                sl5.getWordList().add(w2);
                sl5.getWordList().add(w3);
                sl5.getWordList().add(w4);
                sl5.getWordList().add(w5);
            }

            SubLevel sl6 = new SubLevel(2,5);
            {
                Word w1 = new Word("İL");
                Word w2 = new Word("İLE");
                Word w3 = new Word("İLÇE");
                Word w4 = new Word("ÇİLE");
                Word w5 = new Word("ÇİL");
                Word w6 = new Word("ELÇİ");

                sl6.setLetters("ÇELİ");

                List<LetterRect> lr1 = w1.getLetterRects();
                List<LetterRect> lr2 = w2.getLetterRects();
                List<LetterRect> lr3 = w3.getLetterRects();
                List<LetterRect> lr4 = w4.getLetterRects();
                List<LetterRect> lr5 = w5.getLetterRects();
                List<LetterRect> lr6 = w6.getLetterRects();


                lr1.add(new LetterRect(6,2,'İ'));
                lr1.add(new LetterRect(7,2,'L'));

                lr2.add(new LetterRect(1,1,'İ'));
                lr2.add(new LetterRect(2,1,'L'));
                lr2.add(new LetterRect(3,1,'E'));

                lr3.add(new LetterRect(3,4,'İ'));
                lr3.add(new LetterRect(4,4,'L'));
                lr3.add(new LetterRect(5,4,'Ç'));
                lr3.add(new LetterRect(6,4,'E'));

                lr4.add(new LetterRect(6,1,'Ç'));
                lr4.add(new LetterRect(6,2,'İ'));
                lr4.add(new LetterRect(6,3,'L'));
                lr4.add(new LetterRect(6,4,'E'));

                lr5.add(new LetterRect(1,6,'Ç'));
                lr5.add(new LetterRect(2,6,'İ'));
                lr5.add(new LetterRect(3,6,'L'));

                lr6.add(new LetterRect(3,1,'E'));
                lr6.add(new LetterRect(3,2,'L'));
                lr6.add(new LetterRect(3,3,'Ç'));
                lr6.add(new LetterRect(3,4,'İ'));

                w1.setLetterRects(lr1);
                w2.setLetterRects(lr2);
                w3.setLetterRects(lr3);
                w4.setLetterRects(lr4);
                w5.setLetterRects(lr5);
                w6.setLetterRects(lr6);

                sl6.getWordList().add(w1);
                sl6.getWordList().add(w2);
                sl6.getWordList().add(w3);
                sl6.getWordList().add(w4);
                sl6.getWordList().add(w5);
                sl6.getWordList().add(w6);
            }

            return Arrays.asList(sl1,sl2,sl3,sl4,sl5,sl6);
        }
    },
    LEVEL_3 {
        @Override
        public List<SubLevel> getSubLevels() {
            SubLevel sl1 = new SubLevel(3,0);
            {
                Word w1 = new Word("BEYAZ");
                Word w2 = new Word("YAZ");

                sl1.setLetters("YAZBE");

                List<LetterRect> lr1 = w1.getLetterRects();
                List<LetterRect> lr2 = w2.getLetterRects();

                lr1.add(new LetterRect(3,1,'B'));
                lr1.add(new LetterRect(3,2,'E'));
                lr1.add(new LetterRect(3,3,'Y'));
                lr1.add(new LetterRect(3,4,'A'));
                lr1.add(new LetterRect(3,5,'Z'));


                lr2.add(new LetterRect(1,5,'Y'));
                lr2.add(new LetterRect(2,5,'A'));
                lr2.add(new LetterRect(3,5,'Z'));

                w1.setLetterRects(lr1);
                w2.setLetterRects(lr2);

                sl1.getWordList().add(w1);
                sl1.getWordList().add(w2);
            }

            SubLevel sl2 = new SubLevel(3,1);
            {
                Word w1 = new Word("SÖĞÜT");
                Word w2 = new Word("ÖĞÜT");
                Word w3 = new Word("SÜT");

                // ambiguous method name !!!
                sl2.setLetters("TÜĞSÖ");

                List<LetterRect> lr1 = w1.getLetterRects();
                List<LetterRect> lr2 = w2.getLetterRects();
                List<LetterRect> lr3 = w3.getLetterRects();

                lr1.add(new LetterRect(1,1,'S'));
                lr1.add(new LetterRect(2,1,'Ö'));
                lr1.add(new LetterRect(3,1,'Ğ'));
                lr1.add(new LetterRect(4,1,'Ü'));
                lr1.add(new LetterRect(5,1,'T'));

                lr2.add(new LetterRect(2,1,'Ö'));
                lr2.add(new LetterRect(2,2,'Ğ'));
                lr2.add(new LetterRect(2,3,'Ü'));
                lr2.add(new LetterRect(2,4,'T'));

                lr3.add(new LetterRect(1,3,'S'));
                lr3.add(new LetterRect(2,3,'Ü'));
                lr3.add(new LetterRect(3,3,'T'));

                w1.setLetterRects(lr1);
                w2.setLetterRects(lr2);
                w3.setLetterRects(lr3);

                sl2.getWordList().add(w1);
                sl2.getWordList().add(w2);
                sl2.getWordList().add(w3);
            }

            SubLevel sl3 = new SubLevel(3,2);
            {
                Word w1 = new Word("SON");
                Word w2 = new Word("SAĞ");
                Word w3 = new Word("SOĞAN");
                Word w4 = new Word("AĞ");

                // ambiguous method name !!!
                sl3.setLetters("ĞANSO");

                List<LetterRect> lr1 = w1.getLetterRects();
                List<LetterRect> lr2 = w2.getLetterRects();
                List<LetterRect> lr3 = w3.getLetterRects();
                List<LetterRect> lr4 = w4.getLetterRects();

                lr1.add(new LetterRect(3,1,'S'));
                lr1.add(new LetterRect(4,1,'O'));
                lr1.add(new LetterRect(5,1,'N'));

                lr2.add(new LetterRect(3,1,'S'));
                lr2.add(new LetterRect(3,2,'A'));
                lr2.add(new LetterRect(3,3,'Ğ'));

                lr3.add(new LetterRect(1,3,'S'));
                lr3.add(new LetterRect(2,3,'O'));
                lr3.add(new LetterRect(3,3,'Ğ'));
                lr3.add(new LetterRect(4,3,'A'));
                lr3.add(new LetterRect(5,3,'N'));

                lr4.add(new LetterRect(3,2,'A'));
                lr4.add(new LetterRect(4,2,'Ğ'));


                w1.setLetterRects(lr1);
                w2.setLetterRects(lr2);
                w3.setLetterRects(lr3);
                w4.setLetterRects(lr4);

                sl3.getWordList().add(w1);
                sl3.getWordList().add(w2);
                sl3.getWordList().add(w3);
                sl3.getWordList().add(w4);

            }

            SubLevel sl4 = new SubLevel(3,3);
            {
                Word w1 = new Word("NOT");
                Word w2 = new Word("NET");
                Word w3 = new Word("TON");
                Word w4 = new Word("JETON");
                Word w5 = new Word("JET");

                sl4.setLetters("ONJET");

                List<LetterRect> lr1 = w1.getLetterRects();
                List<LetterRect> lr2 = w2.getLetterRects();
                List<LetterRect> lr3 = w3.getLetterRects();
                List<LetterRect> lr4 = w4.getLetterRects();
                List<LetterRect> lr5 = w5.getLetterRects();

                lr1.add(new LetterRect(3,1,'N'));
                lr1.add(new LetterRect(4,1,'O'));
                lr1.add(new LetterRect(5,1,'T'));

                lr2.add(new LetterRect(3,1,'N'));
                lr2.add(new LetterRect(3,2,'E'));
                lr2.add(new LetterRect(3,3,'T'));

                lr3.add(new LetterRect(5,1,'T'));
                lr3.add(new LetterRect(5,2,'O'));
                lr3.add(new LetterRect(5,3,'N'));

                lr4.add(new LetterRect(1,3,'J'));
                lr4.add(new LetterRect(2,3,'E'));
                lr4.add(new LetterRect(3,3,'T'));
                lr4.add(new LetterRect(4,3,'O'));
                lr4.add(new LetterRect(5,3,'N'));

                lr5.add(new LetterRect(1,3,'J'));
                lr5.add(new LetterRect(1,4,'E'));
                lr5.add(new LetterRect(1,5,'T'));

                w1.setLetterRects(lr1);
                w2.setLetterRects(lr2);
                w3.setLetterRects(lr3);
                w4.setLetterRects(lr4);
                w5.setLetterRects(lr5);

                sl4.getWordList().add(w1);
                sl4.getWordList().add(w2);
                sl4.getWordList().add(w3);
                sl4.getWordList().add(w4);
                sl4.getWordList().add(w5);
            }

            SubLevel sl5 = new SubLevel(3,4);
            {
                Word w1 = new Word("ARDA");
                Word w2 = new Word("ARA");
                Word w3 = new Word("ADA");
                Word w4 = new Word("DAMA");
                Word w5 = new Word("RADAR");
                Word w6 = new Word("DAR");

                sl5.setLetters("IDARM");

                List<LetterRect> lr1 = w1.getLetterRects();
                List<LetterRect> lr2 = w2.getLetterRects();
                List<LetterRect> lr3 = w3.getLetterRects();
                List<LetterRect> lr4 = w4.getLetterRects();
                List<LetterRect> lr5 = w5.getLetterRects();
                List<LetterRect> lr6 = w6.getLetterRects();


                lr1.add(new LetterRect(2,1,'A'));
                lr1.add(new LetterRect(3,1,'R'));
                lr1.add(new LetterRect(4,1,'D'));
                lr1.add(new LetterRect(5,1,'A'));

                lr2.add(new LetterRect(1,2,'A'));
                lr2.add(new LetterRect(1,3,'R'));
                lr2.add(new LetterRect(1,4,'A'));

                lr3.add(new LetterRect(1,4,'A'));
                lr3.add(new LetterRect(2,4,'D'));
                lr3.add(new LetterRect(3,4,'A'));

                lr4.add(new LetterRect(7,2,'D'));
                lr4.add(new LetterRect(7,3,'A'));
                lr4.add(new LetterRect(7,4,'M'));
                lr4.add(new LetterRect(7,5,'A'));

                lr5.add(new LetterRect(3,1,'R'));
                lr5.add(new LetterRect(3,2,'A'));
                lr5.add(new LetterRect(3,3,'D'));
                lr5.add(new LetterRect(3,4,'A'));
                lr5.add(new LetterRect(3,5,'R'));

                lr6.add(new LetterRect(3,3,'D'));
                lr6.add(new LetterRect(4,3,'A'));
                lr6.add(new LetterRect(5,3,'R'));

                w1.setLetterRects(lr1);
                w2.setLetterRects(lr2);
                w3.setLetterRects(lr3);
                w4.setLetterRects(lr4);
                w5.setLetterRects(lr5);
                w6.setLetterRects(lr6);

                sl5.getWordList().add(w1);
                sl5.getWordList().add(w2);
                sl5.getWordList().add(w3);
                sl5.getWordList().add(w4);
                sl5.getWordList().add(w5);
                sl5.getWordList().add(w6);
            }

            SubLevel sl6 = new SubLevel(3,5);
            {
                Word w1 = new Word("İBİK");
                Word w2 = new Word("BİTİK");
                Word w3 = new Word("BİTKİ");
                Word w4 = new Word("İTKİ");
                Word w5 = new Word("BİT");
                Word w6 = new Word("TİK");
                Word w7 = new Word("İKİ");

                sl6.setLetters("TKİBİ");

                List<LetterRect> lr1 = w1.getLetterRects();
                List<LetterRect> lr2 = w2.getLetterRects();
                List<LetterRect> lr3 = w3.getLetterRects();
                List<LetterRect> lr4 = w4.getLetterRects();
                List<LetterRect> lr5 = w5.getLetterRects();
                List<LetterRect> lr6 = w6.getLetterRects();
                List<LetterRect> lr7 = w6.getLetterRects();

                lr1.add(new LetterRect(2,1,'İ'));
                lr1.add(new LetterRect(3,1,'B'));
                lr1.add(new LetterRect(4,1,'İ'));
                lr1.add(new LetterRect(5,1,'K'));


                lr2.add(new LetterRect(3,1,'B'));
                lr2.add(new LetterRect(3,2,'İ'));
                lr2.add(new LetterRect(3,3,'T'));
                lr2.add(new LetterRect(3,4,'İ'));
                lr2.add(new LetterRect(3,5,'K'));

                lr3.add(new LetterRect(1,3,'B'));
                lr3.add(new LetterRect(2,3,'İ'));
                lr3.add(new LetterRect(3,3,'T'));
                lr3.add(new LetterRect(4,3,'K'));
                lr3.add(new LetterRect(5,3,'İ'));

                lr4.add(new LetterRect(3,4,'İ'));
                lr4.add(new LetterRect(4,4,'T'));
                lr4.add(new LetterRect(5,4,'K'));
                lr4.add(new LetterRect(6,4,'İ'));

                lr5.add(new LetterRect(1,3,'B'));
                lr5.add(new LetterRect(1,4,'İ'));
                lr5.add(new LetterRect(1,5,'T'));

                lr6.add(new LetterRect(1,5,'T'));
                lr6.add(new LetterRect(2,5,'İ'));
                lr6.add(new LetterRect(3,5,'K'));

                lr7.add(new LetterRect(5,3,'İ'));
                lr7.add(new LetterRect(5,4,'K'));
                lr7.add(new LetterRect(5,5,'İ'));

                w1.setLetterRects(lr1);
                w2.setLetterRects(lr2);
                w3.setLetterRects(lr3);
                w4.setLetterRects(lr4);
                w5.setLetterRects(lr5);
                w6.setLetterRects(lr6);
                w7.setLetterRects(lr7);

                sl6.getWordList().add(w1);
                sl6.getWordList().add(w2);
                sl6.getWordList().add(w3);
                sl6.getWordList().add(w4);
                sl6.getWordList().add(w5);
                sl6.getWordList().add(w6);
                sl6.getWordList().add(w7);
            }

            return Arrays.asList(sl1,sl2,sl3,sl4,sl5,sl6);
        }
    };
}
