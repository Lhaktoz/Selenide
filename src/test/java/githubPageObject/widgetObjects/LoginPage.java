package githubPageObject.widgetObjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    SelenideElement loginField = $("input#login_field");
    SelenideElement passwordField = $("label[for='password']").sibling(0);
    SelenideElement signInButton = $("input[value='Sign in']");
    public SelenideElement errorSection = $(".js-flash-close").parent();

    public void fillLoginField(String value) {
        loginField.setValue(value);
    }

    public void fillPasswordField(String value) {
        passwordField.setValue(value);
    }

    public void clickSignInButton(){
        signInButton.click();
    }

    public void logInWithValidCredentials(){
        var email = System.getProperty("test.email");
        fillLoginField(email);

        var password = System.getProperty("test.password");
        fillPasswordField(password);
        clickSignInButton();
    }
}
