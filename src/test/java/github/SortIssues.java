package github;

import com.codeborne.selenide.Selenide;
import components.DropdownWidget;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SortIssues {

    // 5. Task2 modern dropdown
    @Test
    void shouldSortIssuesByOldest() {
        open("https://github.com/selenide/selenide");
        $("#issues-tab").click();
        $("summary[title=Sort]").click();
        $(byText("Oldest")).click();
        $(byText("Oldest")).parent().shouldHave(attribute("aria-checked","true"));
    }

    // 5 task 3
    @Test
    void shouldSortIssuesByMostCommented() {
        open("https://github.com/selenide/selenide");
        $("#issues-tab").click();
        new DropdownWidget("summary[title=Sort]").select("Most commented");
        $(byText("Most commented")).parent().shouldHave(attribute("aria-checked","true"));
    }

    @Test
    void shouldFilterIssuesByAsigneeVinogradoff() {
        open("https://github.com/selenide/selenide");
        $("#issues-tab").click();
        new DropdownWidget("summary[title=Assignees]").select("vinogradoff");
        $(byText("vinogradoff")).parent().shouldHave(attribute("aria-checked","true"));
    }
    @AfterAll
    static void closeBrowser(){
        Selenide.closeWebDriver();
    }
}
