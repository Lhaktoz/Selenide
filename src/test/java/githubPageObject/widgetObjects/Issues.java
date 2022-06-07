package githubPageObject.widgetObjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Issues {
    SelenideElement sort = $("summary[title=Sort]");
    public SelenideElement sortByOldest = $(byText("Oldest"));
    public SelenideElement sortByMostCommented = $(byText("Most commented"));
    public SelenideElement vinogradoffAsignee=$(byText("vinogradoff"));

    public void clickSort(){
        sort.click();
    }

    public void Sortby(String sortBy) {
        $(byText(sortBy)).click();
    }
}
