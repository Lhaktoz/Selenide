package github;

import com.codeborne.selenide.Configuration;
import githubPageObject.widgetObjects.Repository;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class FindContributors {
    // 5. Task1
    @Test
    void shouldFindContributors() {
       Configuration.remote="http://sdet-jenkins.webhop.me:15444/wd/hub/";
       Configuration.browser="firefox"; //failing with firefox:MoveTargetOutOfBoundsException: (1045, 753) is out of bounds of viewport width (1366) and height (683)
        //Configuration.browserSize="1900x1200";

        open("https://github.com/selenide/selenide");
        $("li[data-test-selector=grid-mode-element]",1).hover();
        $("a[data-octo-dimensions='link_type:profile']",1).shouldHave(text("Vinogradov"));
    }
}
