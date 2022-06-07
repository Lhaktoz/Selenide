package components;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;

public class DropdownWidget {
    private String cssSelector;

    public DropdownWidget(String cssSelector){
        this.cssSelector = cssSelector;
    }

    public void select(String option){
        $(cssSelector).click();
        $(byText(option)).click();
    }
}
