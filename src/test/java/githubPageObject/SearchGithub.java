package githubPageObject;

import githubPageObject.widgetObjects.MainMenu;
import githubPageObject.widgetObjects.Repository;
import githubPageObject.widgetObjects.SearchPageWithValue;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SearchGithub {

    @Test
    void shouldFindSelenideInGithub() {
        open("https://github.com/");
        new MainMenu().fillSearchGithubInputFieldAndPressEnter("selenide");
        new SearchPageWithValue().clickOnFirstSearchResult();
        new Repository().repositoryTitle.shouldHave(text("selenide / selenide"));
    }

    @Test
    void shouldFindSeleniumInGithub() {
        open("https://github.com/");
        new MainMenu().fillSearchGithubInputFieldAndPressEnter("selenium");
        new Repository().repositoryTitle.shouldHave(text("selenium")); //task 2/6.
        $x("//*[@class='d-flex']/div/a/em").parent().shouldHave(cssClass("v-align-middle"));  //Selenide assertion task, css class
        $x("//*[@class='d-flex']/div/a/em").parent().shouldHave(cssValue("color","rgba(9, 105, 218, 1)"));  //Selenide assertion task, color of an element
    }


    @AfterAll
    static void closeBrowser(){
        closeWebDriver();
    }
}
