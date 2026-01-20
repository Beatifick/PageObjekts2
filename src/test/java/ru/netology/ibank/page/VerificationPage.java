package ru.netology.ibank.page;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {

    public VerificationPage() {
    }

    public DashboardPage verify(String code) {
        $("[data-test-id=code] input").setValue(code);
        $("[data-test-id=action-verify]").click();
        return new DashboardPage();
    }
}

