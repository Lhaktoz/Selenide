package github;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class MainMenuActions {

    @Test
    void shouldNavigateToTeamSite(){
        open("https://github.com");
        $(byText("Team")).click();
        webdriver().shouldHave(url("https://github.com/team"));
    }
//6. Selenide Collections tasks
    @Test
    // this test is failing now expected 3 actual 6 don't know why
    void shouldSeeThreePrimaryLinkWhenHoveringProductOnGithubTeamPage() {
        open("https://github.com");
        $(byText("Product")).should(visible);
        $(byText("Product")).hover();
        $("details").$$(".Link--primary").filterBy(visible).shouldHave(size(3));
    }

    @Test
    void shouldFindAtLeastOneInvisiblePrimaryLinkWhenHoveringProductMenuItem() {
        open("https://github.com");
        $(byText("Product")).should(visible);
        $(byText("Product")).hover();
        $$(".Link--primary").filterBy(hidden).shouldHave(sizeGreaterThanOrEqual(1));
    }

    @Test
    void mainMenuShouldContainsProductTeamEnterprise() {
        open("https://github.com");
        $$(".HeaderMenu-link").shouldHave(exactTexts("Product", "Team", "Enterprise", "Explore", "Marketplace", "Pricing", "Sign in", "Sign up"));
        //How should I check last item in colleciton?
        $$(".HeaderMenu-link").shouldHave(itemWithText("Sign up"));
        $$(".HeaderMenu-link").last().shouldHave(exactText("Sign up"));
    }


    @AfterAll
    static void closeBrowser(){
        closeWebDriver();
    }
}
