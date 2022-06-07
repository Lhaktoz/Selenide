import com.codeborne.selenide.WebDriverConditions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class task1test {

    @Test
    void task1() {
        open("file:///C:/Users/andrea.a.horvath/IdeaProjects/WebAutomation tutoring/src/Task1_different_result.html");
   // $("div a").click();
      $("div").$("a").click();
        sleep(5000);
    }
}
