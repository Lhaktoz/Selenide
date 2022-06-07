package githubPageObject.widgetObjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;

public class SearchPageWithValue {
    SelenideElement firstSearchResult = $$("ul.repo-list li a").first();

    public void clickOnFirstSearchResult(){
        firstSearchResult.click();
    }
}
