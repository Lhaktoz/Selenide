package githubPageObject;

import githubPageObject.widgetObjects.Repository;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class FindContributors {
    // 5. Task1
    @Test
    void shouldFindContributors() {
        open("https://github.com/selenide/selenide");

        // new Repository().highlightContributerByIndex(1);
        new Repository().hoverOverContributorsbyIndex(new Repository().selectContributors(1));
        new Repository().selectContributorNamebyIndex(1).shouldHave(text("Vinogradov"));
    }
}
