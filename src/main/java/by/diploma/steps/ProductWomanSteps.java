package by.diploma.steps;

import by.diploma.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Condition.visible;


public class ProductWomanSteps {
    public ProductWomenPage productWomenPage = new ProductWomenPage();
    public AuthenticationPage authenticationPage = new AuthenticationPage();
    public OrderPage orderPage = new OrderPage();
    public HomePage homePage = new HomePage();

    @When("Open authentication page and log in with valid data")
    public void openAuthenticationPageAndLogInWithValidData() {
        authenticationPage.clickSignInButton()
                          .enterUserEmail("Foremanbariga@gmail.com")
                          .enterUserPassword("13081985");
        productWomenPage.OpenWomenPage();
    }

    @Then("User adds the product {string} to the cart")
    public void userAddToCartProduct(String productName) {
        productWomenPage.addToCartProduct(productName);
        productWomenPage.layerCart.shouldBe(visible);
    }

    @When("User press checkout button")
    public OrderPage userPressCheckoutButton() {
        productWomenPage.clickCheckoutButton();
        return new OrderPage();
    }

    @When("Open Women page")
    public ProductWomenPage openWomenPage() {
        productWomenPage.OpenWomenPage();
        return new ProductWomenPage();
    }

    @Then("User went to Order page")
    public void userWentToSoppingCartSummary() {
        orderPage.product.shouldHave(visible);
        orderPage.total.shouldHave(visible);
    }


    @When("logged in user put the product in the cart")
    public void loggedInUserPutProductInCart() {
        authenticationPage.enterUserEmail("Foremanbariga@gmail.com")
                          .enterUserPassword("13081985");
        productWomenPage.OpenWomenPage()
                        .clickNumberPage("2")
                        .addToCartProduct("Stripe Top");
    }

    @And("User goes to the order page")
    public void UserClickShoppingCartButtonAndGoesOrderPage() {
        productWomenPage.clickShoppingCartButton();

    }

    @Then("User choose the product {string}")
    public void userChooseToCartProduct(String productName) {
        productWomenPage.userChooseProduct(productName);
    }

}
