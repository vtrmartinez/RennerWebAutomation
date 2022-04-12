package br.com.renner.pages;

import br.com.renner.core.Driver;
import br.com.renner.maps.ProdutoMap;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProdutoPage {
    ProdutoMap produtoMap;
    public ProdutoPage(){
        produtoMap = new ProdutoMap();
        PageFactory.initElements(Driver.getDriver(), produtoMap);
    }

    public ProdutoPage setQuantidade(String quantidade){
        if (quantidade == null){
            return this;
        }
        produtoMap.inpQuantidade.clear();
        produtoMap.inpQuantidade.sendKeys(quantidade);
        return this;
    }
    public ProdutoPage selectTamanho(String tamanho){
        if (tamanho == null){
            return this;
        }
        Select select = new Select(produtoMap.slcTamanho);
        select.selectByVisibleText(tamanho);
        return this;
    }
    public ProdutoPage linkCor(String cor) throws Exception {
        if (cor == null){
            return this;
        }
        if (cor.equals("verde")){
            produtoMap.linkCorVerde.click();
        }else if (cor.equals("azul")){
            produtoMap.linkCorAzul.click();
        }else{
            throw new Exception("Cor nao encontrada!");
        }


        return this;
    }
    public ProdutoPage clickCarrinho(){
        produtoMap.btnCarrinho.click();
        return this;
    }

    public void clickContinue(){
        Driver.visibilityOf(produtoMap.btnContinue);
        produtoMap.btnContinue.click();
    }
}
