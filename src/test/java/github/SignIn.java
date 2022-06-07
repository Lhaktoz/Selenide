package github;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.WebDriverConditions;
import githubPageObject.widgetObjects.LoginPage;
import githubPageObject.widgetObjects.MainMenu;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

public class SignIn {

    @Test
    void shouldNotSignInWithInValidCreddentials() {
        open("https://github.com/");
        new MainMenu().signInMenuItem.shouldBe(visible);
        new MainMenu().signInMenuItem.shouldBe(cssValue("color","rgba(255, 255, 255, 1)"));
        new MainMenu().clickSignInMenuItem();
        webdriver().shouldHave(WebDriverConditions.title("Sign in to GitHub · GitHub"));
        new LoginPage().fillLoginField("test@gmail.com");
        new LoginPage().fillPasswordField("asdf");
        new LoginPage().clickSignInButton();
        new LoginPage().errorSection.shouldHave(text("Incorrect username or password."));
    }


    // Selenide Assertions task 2
    @Test
    void shouldSignInWithValidCreddentials() {
        open("https://github.com/");
        new MainMenu().signInMenuItem.shouldBe(visible);
        new MainMenu().signInMenuItem.shouldBe(cssValue("color","rgba(255, 255, 255, 1)"));
        new MainMenu().clickSignInMenuItem();
        webdriver().shouldHave(WebDriverConditions.url("https://github.com/login"));
        new LoginPage().logInWithValidCredentials();
        webdriver().shouldHave(WebDriverConditions.title("GitHub"));
    }

    @AfterAll
    static void closeBrowser(){
        closeWebDriver();
    }
}
