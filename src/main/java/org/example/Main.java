package org.example;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static final AtomicInteger counterLength3 = new AtomicInteger(0);
    public static final AtomicInteger counterLength4 = new AtomicInteger(0);
    public static final AtomicInteger counterLength5 = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        String[] nicknames = generateNicknames();

        Counter polyndromeCheck = new Counter(nicknames, new NicknameIsPolyndrome());
        Counter sameCheck = new Counter(nicknames, new NicknameIsSame());
        Counter increasingCkeck = new Counter(nicknames, new NicknameIncreasing());

        polyndromeCheck.join();
        sameCheck.join();
        increasingCkeck.join();

        printResults(3, counterLength3.get());
        printResults(4, counterLength4.get());
        printResults(5, counterLength5.get());
    }

    private static void printResults(int targetLength, int totalNicknames) {
        System.out.printf("Красивых слов с длиной %d: %d шт\n", targetLength, totalNicknames);
    }

    public static String[] generateNicknames() {
        Random random = new Random();
        String[] texts = new String[100_000];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText("abc", 3 + random.nextInt(3));
        }
        return texts;
    }

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }
}