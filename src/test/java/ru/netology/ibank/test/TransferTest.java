package ru.netology.ibank.test;

import org.junit.jupiter.api.Test;
import ru.netology.ibank.data.DataHelper;
import ru.netology.ibank.page.DashboardPage;
import ru.netology.ibank.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransferTest {

    @Test
    void shouldTransferMoneyBetweenOwnCards() {
        open("http://localhost:9999");

        // Получаем данные карт и пользователя
        DataHelper.AuthInfo auth = DataHelper.getAuthInfo();
        DataHelper.VerificationCode code = DataHelper.getVerificationCode();
        DataHelper.CardInfo firstCard = DataHelper.getFirstCard();
        DataHelper.CardInfo secondCard = DataHelper.getSecondCard();

        // Логин и верификация
        DashboardPage dashboardPage = new LoginPage()
                .login(auth.getLogin(), auth.getPassword())
                .verify(code.getCode());

        // Сохраняем текущие балансы
        int balanceFirst = dashboardPage.getCardBalance(firstCard);
        int balanceSecond = dashboardPage.getCardBalance(secondCard);

        dashboardPage
                .selectCardToTransfer(secondCard)
                .makeTransfer(1000, firstCard.getNumber());

        assertEquals(balanceFirst - 1000,
                dashboardPage.getCardBalance(firstCard));
        assertEquals(balanceSecond + 1000,
                dashboardPage.getCardBalance(secondCard));
    }
}