package ru.netology.ibank.page;

import static com.codeborne.selenide.Selenide.$;

public class TransferPage {

    public TransferPage() {
    }

    public DashboardPage makeTransfer(int amount, String fromCardNumber) {
        $("[data-test-id=amount] input").setValue(String.valueOf(amount));
        $("[data-test-id=from] input").setValue(fromCardNumber);
        $("[data-test-id=action-transfer]").click();
        return new DashboardPage();
    }
}

