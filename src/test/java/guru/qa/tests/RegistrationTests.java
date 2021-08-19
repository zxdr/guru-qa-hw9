package guru.qa.tests;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.util.Locale;

public class RegistrationTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    Faker faker = new Faker();
    FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-GB"), new RandomService());

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String gender = "Other";
    String userNumber = fakeValuesService.numerify("89#########");
    String dateOfBirth = "15 January,2001";
    String subject = "Arts";
    String hobby = "Reading";
    String picture = "pepe.png";
    String address = faker.address().fullAddress();
    String state = "Uttar Pradesh";
    String city = "Agra";

    @Test
    void successfulSubmitFormTest() {

        registrationPage.openPage();
        registrationPage.checkFormHeader();

        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.typeEmail(userEmail);
        registrationPage.typeGender(gender);
        registrationPage.typeMobilePhone(userNumber);
        registrationPage.setDateOfBirth("15", "January", "2001");
        registrationPage.typeSubject(subject);
        registrationPage.typeHobby(hobby);
        registrationPage.addFile(picture);
        registrationPage.typeAddress(address);
        registrationPage.typeState(state);
        registrationPage.typeCity(city);
        registrationPage.clickSubmitButton();

        registrationPage.checkResultsFormHeader();
        registrationPage.checkResultsValue(firstName + " " + lastName);
        registrationPage.checkResultsValue(userEmail);
        registrationPage.checkResultsValue(gender);
        registrationPage.checkResultsValue(dateOfBirth);
        registrationPage.checkResultsValue(subject);
        registrationPage.checkResultsValue(hobby);
        registrationPage.checkResultsValue(picture);
        registrationPage.checkResultsValue(address);
        registrationPage.checkResultsValue(state + " " + city);

        registrationPage.clickCloseButton();
        registrationPage.checkFormHeader();
    }
}