package pageobjects.pages;

import io.qameta.allure.Step;
import pageobjects.Page;
import pageobjects.fragments.CategoriesFragment;
import pageobjects.fragments.SearchFragment;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends Page {

    @Step("open main page")
    public static MainPage open() {
        return navigate("/", MainPage.class);
    }

    @Step("click SignIn button")
    public AuthenticationPage clickSignInButton() {
        $(".login").click();
        logger.atInfo().log("click SignIn button");
        return new AuthenticationPage();
    }

    @Step("open '{0}' product category")
    public CategoryPage openCategoryPage(String category) {
        return new CategoriesFragment().getCategoryWith(category);
    }

    public ProductDetailPage openProductPageFromSearch(String query) {
        return new SearchFragment().getFirstProductFromSearch(query);
    }
}