package githubPageObject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverConditions;
import githubPageObject.widgetObjects.SignUPWidgetOnMainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class SignUpForGitHub {


    @Test
    void shouldNotSignUpWithWrongEmailAddress() {
        open("https://github.com/");
        new SignUPWidgetOnMainPage().fillEmailInputField("asdf");
        new SignUPWidgetOnMainPage().clickSignUpButton();
        webdriver().shouldHave(WebDriverConditions.title("GitHub: Where the world builds software · GitHub"));
    }

    @Test
    void shouldGoToSignUpWindowWithRightEmail(){
        open("https://github.com/");
        new SignUPWidgetOnMainPage().fillEmailInputField("test@test.com");
        new SignUPWidgetOnMainPage().clickSignUpButton();
        webdriver().shouldHave(WebDriverConditions.title("Join GitHub · GitHub"));
    }

    @AfterAll
    static void closeBrowser(){
        Selenide.closeWebDriver();
    }
}
