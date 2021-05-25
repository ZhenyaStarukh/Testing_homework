package steps;

import enums.FormField;
import enums.Language;
import enums.Services;
import enums.UkraineLocations;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import test.TestBase;

public class StepDefinition extends TestBase {

    @Before
    public void init() {
        start();
    }

    @After
    public void teardown() {
        finish();
    }

    @Given("opened site's main page")
    public void openedSiteSMainPage() {
        mainPage.goTo();
    }

    @When("I click the accept button")
    public void iClickTheAcceptButton() {
        mainPage.clickAcceptCookies();
    }

    @Then("the cookie window close")
    public void theCookieWindowClose() {
        mainPage.checkVanishedCookieWindow();
    }


    @Given("opened site's services page")
    public void openedSiteSServicesPage() {
        servicesPage.goTo();
    }

    @When("I click on the company's logo")
    public void iClickOnTheCompanySLogo() {
        servicesPage.clickLogo();
    }

    @Then("I return to the main page")
    public void iReturnToTheMainPage() {
        mainPage.onMainPage();
    }

    @When("I click on services button")
    public void iClickOnServicesButton() {
        mainPage.clickServicesButton();
    }

    @And("^click the \"([^\"]*)\" button$")
    public void clickTheButton(Services service) {
        servicesPage.clickServiceName(service);
    }

    @Then("^I will be redirected to \"([^\"]*)\" page$")
    public void iWillBeRedirectedToPage(Services service) {
        try{
            servicesPage.checkRedirection(service);
        } catch (InterruptedException exception){
            exception.printStackTrace();
        }
    }

    @Given("opened site's main page in English")
    public void openedSiteSMainPageInEnglish() {
        mainPage.goTo();
    }

    @When("I click the change language button")
    public void iClickTheChangeLanguageButton() {
        mainPage.clickLanguageButton();
    }


    @And("^choose \"([^\"]*)\" language$")
    public void chooseAnotherLanguage(Language language) {
        mainPage.chooseLanguage(language);
    }

    @Then("^I see site's main page on \"([^\"]*)\"$")
    public void iSeeSiteSMainPageOnAnotherLanguage(Language language) {
        mainPage.seeOtherMainPage(language);
    }

    @When("I click the contact us button")
    public void iClickTheContactUsButton() {
        mainPage.clickContactUsButton();
    }

    @Then("I see contact us page")
    public void iSeeContactUsPage() {
        contactUsPage.seeContactUsPage();
    }

    @Given("opened site's contact us page")
    public void openedSiteSContactUsPage() {
        contactUsPage.goTo();
    }

    @When("I didn't fill \"([^\"]*)\"$")
    public void iDidnTFill(FormField field) {
        contactUsPage.fillEverythingExcept(field);
    }

    @Then("the form won't be submitted")
    public void theFormWonTBeSubmitted() {
        contactUsPage.clickSubmit();
    }

    @And("^it will highlight the empty \"([^\"]*)\" box$")
    public void checkHighlightOfEmptyBox(FormField field) {
        contactUsPage.highlightBox(field);
    }


    @When("I fill the email box not with an email")
    public void fillTheEmailBoxNotWithAnEmail() {
        contactUsPage.fillEmail("wrongEmail");
    }

    @Then("the form will tell me that I have made wrong input")
    public void informAboutWrongInput() {
        contactUsPage.highlightWrongEmail();
    }

    @When("I click the Europe button")
    public void clickTheEuropeButton() {
        mainPage.clickEurope();
    }

    @And("choose Ukraine from the list")
    public void chooseUkraineFromTheList() {
        mainPage.chooseUkraine();
    }

    @And("^click on map button for \"([^\"]*)\" location$")
    public void clickOnMapButtonForLocation(UkraineLocations location) {
        mainPage.clickOnMapButton(location);
    }


    @Then("^I will be redirected to the map page with the office \"([^\"]*)\"$")
    public void redirectToMapPage(UkraineLocations location) {
        try{
            mainPage.mapRedirect(location);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }
}
