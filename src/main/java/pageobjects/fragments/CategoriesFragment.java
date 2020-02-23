package pageobjects.fragments;

import com.codeborne.selenide.SelenideElement;
import pageobjects.pages.CategoryPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CategoriesFragment {
    private SelenideElement container;

    public CategoriesFragment() {
        this.container = $("ul[class*='sf-menu clearfix menu-content']");
    }

    public CategoryPage getCategoryWith(String category) {
        this.container.$$("li").findBy(text(category)).click();
        return new CategoryPage();
    }
}
