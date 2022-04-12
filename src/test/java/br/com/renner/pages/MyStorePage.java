package br.com.renner.pages;

import br.com.renner.core.Driver;
import br.com.renner.maps.MyStoreMap;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MyStorePage {
    MyStoreMap myStoreMap;
    public MyStorePage(){
        myStoreMap = new MyStoreMap();
        PageFactory.initElements(Driver.getDriver(), myStoreMap);
    }

    public MyStorePage clickSignIn(){
        myStoreMap.linkSignIn.click();
        return this;
    }

    public MyStorePage clickProduto(String nomeProduto) throws Exception {
        for (WebElement produto:
            myStoreMap.linkProdutos ) {
            if (produto.getText().equals(nomeProduto)){
                produto.click();
                return this;
            }
        }
        throw new Exception("Produto "+nomeProduto+" não encontrado");
    }

    public MyStorePage setPesquisa(String pesquisa){
        myStoreMap.inpPesquisa.clear();
        myStoreMap.inpPesquisa.sendKeys(pesquisa + Keys.ENTER);
        return this;
    }

    public String getQtdProduto(){
        return myStoreMap.textQtdProdutos.getText();
    }
}
