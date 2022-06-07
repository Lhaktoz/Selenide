package githubPageObject.widgetObjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SignUPWidgetOnMainPage {
    SelenideElement emailInputField = $("#user_email");
    SelenideElement signUpButton = $(".btn-signup-mktg");

    public void fillEmailInputField(String email){
        emailInputField.setValue(email);
    }

    public void clickSignUpButton(){
        signUpButton.click();
    }
}
