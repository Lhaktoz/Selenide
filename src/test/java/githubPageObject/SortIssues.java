package githubPageObject;


import com.codeborne.selenide.Selenide;
import components.DropdownWidget;
import githubPageObject.widgetObjects.Issues;
import githubPageObject.widgetObjects.Repository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;


public class SortIssues {

    // 5. Task2 modern dropdown
    @Test
    void shouldSortIssuesByOldest() {
        open("https://github.com/selenide/selenide");
        new Repository().clickIssues();
        new Issues().clickSort();
        new Issues().Sortby("Oldest");
        new Issues().sortByOldest.parent().shouldHave(attribute("aria-checked","true"));
    }

    // 5 task 3
    @Test
    void shouldSortIssuesByMostCommented() {
        open("https://github.com/selenide/selenide");
        new Repository().clickIssues();
        new DropdownWidget("summary[title=Sort]").select("Most commented");
        new Issues().sortByMostCommented.parent().shouldHave(attribute("aria-checked","true"));
    }

    @Test
    void shouldFilterIssuesByAsigneeVinogradoff() {
        open("https://github.com/selenide/selenide");

        new Repository().filterByAssignee("vinogradoff");
        new Repository().clickIssues();
        new DropdownWidget("summary[title=Assignees]").select("vinogradoff");
        new Issues().vinogradoffAsignee.parent().shouldHave(attribute("aria-checked","true"));
    }
    @AfterAll
    static void closeBrowser(){
        Selenide.closeWebDriver();
    }
}

