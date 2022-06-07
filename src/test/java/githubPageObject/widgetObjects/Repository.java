package githubPageObject.widgetObjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Repository {
    public SelenideElement authorName = $("h2").$("a");
    public SelenideElement repositoryTitle = $("h2");
    SelenideElement  Issues = $("#issues-tab");


    public void clickIssues(){
        Issues.click();
    }

    public SelenideElement selectContributors(int index){
       return $("li[data-test-selector=grid-mode-element]",index);
    }

    public void hoverOverContributorsbyIndex(SelenideElement contributor){
        contributor.hover();
    }

    public SelenideElement selectContributorNamebyIndex(int index) {
        return $("a[data-octo-dimensions='link_type:profile']",index);
    }

    public void filterByAssignee(String vinogradoff) {
        ///
    }
}
