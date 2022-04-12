package br.com.renner.maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdutoMap {
    @FindBy(css = "#quantity_wanted")
    public WebElement inpQuantidade;
    @FindBy(css = "#group_1")
    public WebElement slcTamanho;
    @FindBy(name = "Green")
    public WebElement linkCorVerde;
    @FindBy(name = "Blue")
    public WebElement linkCorAzul;
    @FindBy(css = "#add_to_cart > button")
    public WebElement btnCarrinho;
    @FindBy(css = ".continue")
    public WebElement btnContinue;
}
