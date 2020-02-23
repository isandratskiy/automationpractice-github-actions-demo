package pageobjects.pages;

import io.qameta.allure.Step;
import pageobjects.AbstractPage;
import pageobjects.fragments.CategoriesFragment;
import pageobjects.fragments.SearchFragment;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends AbstractPage {

    @Step
    public AuthenticationPage clickSignInButton() {
        $(".login").click();
        return new AuthenticationPage();
    }

    @Step
    public CategoryPage openCategoryPage(String category) {
        return new CategoriesFragment().getCategoryWith(category);
    }

    @Step
    public ProductDetailPage openProductPageFromSearch(String query) {
        return new SearchFragment().getFirstProductFromSearch(query);
    }
}