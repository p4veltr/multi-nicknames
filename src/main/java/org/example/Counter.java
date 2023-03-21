package org.example;

import static org.example.Main.*;

public class Counter extends Thread {
    private final String[] nicknames;
    public final NicknameCkeck nicknameCkeck;

    public Counter(String[] nicknames, NicknameCkeck nicknameCkeck) {
        this.nicknames = nicknames;
        this.nicknameCkeck = nicknameCkeck;
        start();
    }

    @Override
    public void run() {
        for (String nickname: nicknames) {
            if (! nicknameCkeck.nicknameIsGood(nickname)) continue;
            switch (nickname.length()) {
                case 3 -> counterLength3.incrementAndGet();
                case 4 -> counterLength4.incrementAndGet();
                case 5 -> counterLength5.incrementAndGet();
            }
        }
    }
}
