package material_angular_dropdown;
import components.DropdownWidget;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;

public class SelectDropdown {

    @Test
    void shouldSelectFavoriteFoodPizza() {
        open("https://material.angular.io/components/select/overview");
        $(byText("Ok, Got it")).click();  //accepting cookies
        new DropdownWidget("#mat-select-0").select("Pizza");
        $("#mat-select-0 span").shouldHave(text("Pizza"));
    }

    @AfterAll
    static void closeBrowser(){
        closeWebDriver();
    }
}
