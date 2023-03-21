package org.example;

public class NicknameIncreasing implements NicknameCkeck {
    @Override
    public boolean nicknameIsGood(String nickname) {
        for (int i = 1; i < nickname.length(); i++) {
            if (nickname.charAt(i) < nickname.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
