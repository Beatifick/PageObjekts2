package ru.netology.ibank.data;

import lombok.Value;

public class DataHelper {

    private DataHelper() {}

    // ====== АВТОРИЗАЦИЯ ======
    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static VerificationCode getVerificationCode() {
        return new VerificationCode("12345");
    }

    // ====== КАРТЫ ======
    public static CardInfo getFirstCard() {
        return new CardInfo("92df3f1c-a033-48e6-8390-206f6b1f56c0", "5559 0000 0000 0001");
    }

    public static CardInfo getSecondCard() {
        return new CardInfo("0f3f5c2a-249e-4c3d-8287-09f7a039391d", "5559 0000 0000 0002");
    }

    // ====== DTO ======
    @Value
    public static class AuthInfo {
        String login;
        String password;
    }

    @Value
    public static class VerificationCode {
        String code;
    }

    @Value
    public static class CardInfo {
        String id;
        String number;
    }

    // ====== Метод для расчета суммы перевода ======
    // Возвращает половину баланса карты списания
    public static int calculateTransferAmount(int balanceFromCard) {
        return balanceFromCard / 2; // можно брать 50% для теста
    }
}
