package pages;

import com.codeborne.selenide.SelenideElement;
import components.Calendar;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.format;

public class RegistrationPage {

    private final static String FORM_HEADER = "Student Registration Form";
    private final static String RESULT_FORM_HEADER = "Thanks for submitting the form";

    private SelenideElement modal = $("[role=dialog]");

    private Calendar calendar = new Calendar();

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
    }

    public void checkFormHeader() {
        $("div h5").shouldHave(text(FORM_HEADER));
    }

    public void typeFirstName(String firstName) {
        $("#firstName").setValue(firstName);
    }

    public void typeLastName(String lastName) {
        $("#lastName").setValue(lastName);
    }

    public void typeEmail(String userEmail) {
        $("#userEmail").setValue(userEmail);
    }

    public RegistrationPage typeGender(String gender) {
        $(format("[name=gender][value=%s]", gender)).parent().click();
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendar.setDate(day, month, year);
        return this;
    }

    public void typeMobilePhone(String userNumber) {
        $("#userNumber").setValue(userNumber);
    }

    public void typeSubject(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();
    }

    public void typeHobby(String hobby) {
        $(byText(hobby)).click();
    }

    public void addFile(String picture) {
        $("#uploadPicture").uploadFromClasspath(picture);
    }

    public void typeAddress(String address) {
        $("#currentAddress").setValue(address);
    }

    public void typeState(String state) {
        $("#react-select-3-input").setValue(state).pressEnter();
    }

    public void typeCity(String city) {
        $("#react-select-4-input").setValue(city).pressEnter();
    }

    public void clickSubmitButton() {
        $("#submit").click();
    }

    public void clickCloseButton() {
        $("#closeLargeModal").click();
    }

    public void checkResultsFormHeader() {
        modal.$(".h4").shouldHave(text(RESULT_FORM_HEADER));
    }

    public void checkResultsValue(String value) {
        modal.$(".table-responsive").shouldHave(text(value));
    }

}