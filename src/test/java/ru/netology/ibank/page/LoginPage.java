package ru.netology.ibank.page;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public LoginPage() {
    }

    public VerificationPage login(String login, String password) {
        $("[data-test-id=login] input").setValue(login);
        $("[data-test-id=password] input").setValue(password);
        $("[data-test-id=action-login]").click();
        return new VerificationPage();
    }
}
