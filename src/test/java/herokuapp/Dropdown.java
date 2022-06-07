package herokuapp;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

class Dropdown {

    //5. task 3
    @Test
    void shouldFindContributors() {
        open("http://the-internet.herokuapp.com/dropdown");
        $("#dropdown").selectOption("Option 2");
        $(withText("Option 2")).shouldHave(attribute("selected"));
    }

    @AfterAll
    static void closeBrowser(){
        closeWebDriver();
    }
}
