package githubPageObject.widgetObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainMenu {

    //elements
    public SelenideElement productMenuItem = $(byText("Product"));
    SelenideElement teamMenuItem = $(byText("Team"));
    ElementsCollection primaryLinks =  $$(".Link--primary");
    public ElementsCollection headerMenulinks = $$(".HeaderMenu-link");
    SelenideElement searchGithub = $("input[data-test-selector=nav-search-input]");
    public SelenideElement signInMenuItem = $(byText("Sign in"));

    //actions
    public void hoverOverPruductMenuItem() {
        productMenuItem.hover();
    }
    public void clickTeamMenuItem() { teamMenuItem.click();}
    public void clickSignInMenuItem() { signInMenuItem.click();}
    public void fillSearchGithubInputFieldAndPressEnter(String searchPhrase){
        searchGithub.setValue(searchPhrase).pressEnter();
    }

    //methods for selecting elements

    public ElementsCollection filterPrimaryLinks(Condition filteredBy) {
        return primaryLinks.filterBy(filteredBy);
    }

    public SelenideElement selectClickableMenuItem(String clickableMenuItemName){
        return $$("a").findBy(Condition.text(clickableMenuItemName));
    }

    public SelenideElement selectHeaderMenuLinkByIndex(int index){
       return $(".HeaderMenu-link",index);
    }
}

