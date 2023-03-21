package org.example;

public class NicknameIsSame implements NicknameCkeck {
    @Override
    public boolean nicknameIsGood(String nickname) {
        return nickname.replace(nickname.charAt(0),' ').trim().isBlank();
    }
}
