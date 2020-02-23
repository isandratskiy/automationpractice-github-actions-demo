package pageobjects.pages;

import com.codeborne.selenide.ElementsCollection;
import lombok.val;
import pageobjects.AbstractPage;
import pageobjects.fragments.ProductFragment;

import static com.codeborne.selenide.Selenide.*;

public class CategoryPage extends AbstractPage {

    public ProductFragment getFirstProduct() {
        return new ProductFragment(
                this.getProductsList().first().hover()
        );
    }

    private ElementsCollection getProductsList() {
        val list = $("ul[class='product_list grid row']").scrollTo();
        return list.$$("div[class='product-container']");
    }
}
