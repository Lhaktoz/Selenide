package githubPageObject;

import githubPageObject.widgetObjects.MainMenu;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class MainMenuActions {

    @Test
    void shouldNavigateToTeamSite(){
        open("https://github.com");
        new MainMenu().clickTeamMenuItem();
        webdriver().shouldHave(url("https://github.com/team"));
    }

    @Test
    // this test is failing now expected 3 actual 6 don't know why
    void shouldSeeThreePrimaryLinkWhenHoveringProductOnGithub() {
        open("https://github.com");
        new MainMenu().productMenuItem.should(visible);
        new MainMenu().hoverOverPruductMenuItem();
        new MainMenu().filterPrimaryLinks(visible).shouldHave(size(3));
    }

    @Test
    void shouldFindAtLeastOneInvisiblePrimaryLinkWhenHoveringProductMenuItem() {
        open("https://github.com");
        new MainMenu().productMenuItem.should(visible);
        new MainMenu().hoverOverPruductMenuItem();
        new MainMenu().filterPrimaryLinks(hidden).shouldHave(sizeGreaterThanOrEqual(1));
    }

    @Test
    void mainMenuShouldContainsProductTeamEnterprise() {
        open("https://github.com");
        new MainMenu().headerMenulinks.shouldHave(exactTexts("Product", "Team", "Enterprise", "Explore", "Marketplace", "Pricing", "Sign in", "Sign up"));
        //How should I check last item in colleciton?
        new MainMenu().headerMenulinks.shouldHave(itemWithText("Sign up"));
        new MainMenu().selectHeaderMenuLinkByIndex(7).shouldHave(exactText("Sign up"));
    }


    @AfterAll
    static void closeBrowser(){
        closeWebDriver();
    }
}
