package github;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;


public class SearchGithub {

    @Test
    void shouldFindSelenideInGithub() {
        open("https://github.com/");

        $("input[data-test-selector=nav-search-input]").setValue("selenide")
                .pressEnter();

        $$("ul.repo-list li a").first().click();

        $("h2").$("a");
        $("h2 a");
        $("h2").shouldHave(text("selenide / selenide"));
    }

    @Test
    void shouldFindSeleniumInGithub() {
        open("https://github.com/");
        $("input",0).setValue("selenium")  //Selenide selector task 2/5.
                .pressEnter();
        $x("//*[@class='d-flex']/div/a/em").shouldHave(text("selenium")); //task 2/6.
        $x("//*[@class='d-flex']/div/a/em").parent().shouldHave(cssClass("v-align-middle"));  //Selenide assertion task, css class
        $x("//*[@class='d-flex']/div/a/em").parent().shouldHave(cssValue("color","rgba(9, 105, 218, 1)"));  //Selenide assertion task, color of an element
    }


    @AfterAll
    static void closeBrowser(){
        closeWebDriver();
    }

}

