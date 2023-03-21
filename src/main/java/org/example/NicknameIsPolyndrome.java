package org.example;

public class NicknameIsPolyndrome implements NicknameCkeck {
    @Override
    public boolean nicknameIsGood(String nickname) {
        return new StringBuilder(nickname).reverse().toString().equals(nickname);
    }
}
