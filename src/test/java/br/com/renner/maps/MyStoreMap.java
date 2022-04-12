package br.com.renner.maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyStoreMap {
    @FindBy(linkText = "Sign in")
    public WebElement linkSignIn;
    @FindBy(css = "#search_query_top")
    public WebElement inpPesquisa;
    @FindBy(css = "div.right-block > h5 > a")
    public List<WebElement> linkProdutos;
    @FindBy(css = " a > span.ajax_cart_quantity")
    public WebElement textQtdProdutos;
}
