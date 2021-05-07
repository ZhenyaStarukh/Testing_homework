package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import test.TestBase;

public class StepDefinition extends TestBase {

    @Before
    public void init(){
        start();
    }

    @After
    public void teardown(){
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
    public void iReturnToTheMainPage() throws InterruptedException {
        mainPage.onMainPage();
    }

    @When("I click on services button")
    public void iClickOnServicesButton() {
        mainPage.clickServicesButton();
    }

    @And("click the {string} button")
    public void clickTheButton(String arg0) {
        servicesPage.clickServiceName(arg0);
    }

    @Then("I will be redirected to {string} page")
    public void iWillBeRedirectedToPage(String arg0) throws InterruptedException {
        servicesPage.checkRedirection(arg0);
    }

    @Given("opened site's main page in English")
    public void openedSiteSMainPageInEnglish() {
        mainPage.goTo();
    }

    @When("I click the change language button")
    public void iClickTheChangeLanguageButton() {
        mainPage.clickLanguageButton();
    }

    @And("choose Russian language")
    public void chooseRussianLanguage() {
        mainPage.chooseRussian();
    }

    @Then("I see site's main page on Russian")
    public void iSeeSiteSMainPageOnRussian() throws InterruptedException {
        mainPage.seeRussianMainPage();
    }

    @When("I click the contact us button")
    public void iClickTheContactUsButton() {
        mainPage.clickContactUsButton();
    }

    @Then("I see contact us page")
    public void iSeeContactUsPage() throws InterruptedException {
        contactUsPage.seeContactUsPage();
    }

    @Given("opened site's contact us page")
    public void openedSiteSContactUsPage() {
        contactUsPage.goTo();
    }

    @When("I didn't fill {string}")
    public void iDidnTFill(String arg0) {
        contactUsPage.fillEverythingExcept(arg0);
    }

    @Then("the form won't be submitted")
    public void theFormWonTBeSubmitted() {
        contactUsPage.clickSubmit();
    }

    @And("it will highlight the empty {string} box")
    public void itWillHighlightTheEmptyBox(String arg0) {
        contactUsPage.highlightBox(arg0);
    }


    @When("I fill the email box not with an email")
    public void iFillTheEmailBoxNotWithAnEmail() {
        contactUsPage.fillWrongEmail();
    }

    @Then("the form will tell me that I have made wrong input")
    public void theFormWillTellMeThatIHaveMadeWrongInput() {
        contactUsPage.highlightWrongEmail();
    }

    @When("I click the Europe button")
    public void iClickTheEuropeButton() {
        mainPage.clickEurope();
    }

    @And("choose Ukraine from the list")
    public void chooseUkraineFromTheList() throws InterruptedException {
        mainPage.chooseUkraine();
    }

    @And("click on map button for {string} location")
    public void clickOnMapButtonForLocation(String arg0) {
        mainPage.clickOnMapButton(arg0);
    }


    @Then("I will be redirected to the new page with map where the office {string} is shown")
    public void iWillBeRedirectedToTheNewPageWithMapWhereTheOfficeIsShown(String arg0) throws InterruptedException {
        mainPage.mapRedirect(arg0);
    }
}
