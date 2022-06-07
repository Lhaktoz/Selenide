package github;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverConditions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;


public class SignupForGitHub {

    @Test
    void shouldNotSignUpWithWrongEmailAddress() {
        open("https://github.com/");
        $("#user_email").setValue("asdf");
        //$(".btn-mktg width-full width-sm-auto btn-signup-mktg").click(); working that way: $(".btn-mktg.width-full.width-sm-auto.btn-signup-mktg")
        $(".btn-signup-mktg").click();
        sleep(5000);
        webdriver().shouldHave(WebDriverConditions.title("GitHub: Where the world builds software · GitHub"));
    }

    @Test
    void shouldGoToSignUpWindowWithRightEmail(){
        open("https://github.com/");
        $("#user_email").setValue("test@test.com");
        $(".btn-signup-mktg").click();
        webdriver().shouldHave(WebDriverConditions.title("Join GitHub · GitHub"));
    }

    @AfterAll
    static void closeBrowser(){
        Selenide.closeWebDriver();
    }
}
