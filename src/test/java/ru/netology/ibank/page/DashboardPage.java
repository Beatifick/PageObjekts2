package ru.netology.ibank.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.netology.ibank.data.DataHelper.CardInfo;

import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {

    // Селектор всех карточек на странице
    private ElementsCollection cards = $$(".list__item div");

    // Получение баланса карты
    public int getCardBalance(CardInfo card) {
        SelenideElement cardElement = cards.findBy(
                Condition.attribute("data-test-id", card.getId())
        ).shouldBe(Condition.visible);

        String text = cardElement.getText();
        return extractBalance(text);
    }

    // Выбор карты для перевода / пополнения
    public TransferPage selectCardToTransfer(CardInfo card) {
        cards.findBy(Condition.attribute("data-test-id", card.getId()))
                .shouldBe(Condition.visible)
                .$("[data-test-id=action-deposit]") // кнопка "Пополнить"
                .click();
        return new TransferPage();
    }

    // Извлечение баланса из строки вида: "**** **** **** 0001, баланс: 15000 р."
    private int extractBalance(String text) {
        String balanceStart = "баланс: ";
        String balanceFinish = " р.";
        int start = text.indexOf(balanceStart) + balanceStart.length();
        int end = text.indexOf(balanceFinish, start);
        String value = text.substring(start, end).trim().replace(" ", "");
        return Integer.parseInt(value);
    }
}
