package pageobjects.fragments;

import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;
import pageobjects.pages.CategoryPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

@AllArgsConstructor
public class CategoriesFragment {
    private final SelenideElement container;

    public CategoriesFragment() {
        this.container = $("ul[class*='sf-menu clearfix menu-content']");
    }

    public CategoryPage getCategoryWith(String category) {
        this.container.$$("li").findBy(text(category)).click();
        return new CategoryPage();
    }
}
