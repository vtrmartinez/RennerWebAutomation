package br.com.renner.steps;

import br.com.renner.pages.LoginPage;
import br.com.renner.pages.MyStorePage;
import br.com.renner.pages.ProdutoPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class MyStoreSteps {

    LoginPage loginPage;
    MyStorePage myStorePage;
    ProdutoPage produtoPage;

    @Dado("que esteja na pagina principal")
    public void queEstejaNaPaginaPrincipal() {
        loginPage = new LoginPage();
        loginPage.clickPaginaPrincipal();
    }

    @Quando("seleciono o produto {string} pelo resultado da busca")
    public void selecionoOProdutoPeloResultadoDaBusca(String nomeProduto) throws Exception {
        myStorePage = new MyStorePage();
        myStorePage.setPesquisa(nomeProduto);
        myStorePage.clickProduto(nomeProduto);
    }

    @Quando("altero as opcoes do produto")
    public void alteroAsOpcoeesDoProduto(Map<String, String> map) throws Exception {
        produtoPage = new ProdutoPage();
        produtoPage.setQuantidade(map.get("quantidade"))
                .selectTamanho(map.get("tamanho"))
                .linkCor(map.get("cor"));
    }

    @Quando("adiciono no carrinho")
    public void adicionoNoCarrinho() {
        produtoPage.clickCarrinho();
        produtoPage.clickContinue();
    }

    @Quando("seleciono o produto")
    public void selecionoOProduto(List<Map<String, String>> listMap) throws Exception {
        for (Map<String, String> map:
            listMap ) {
            myStorePage = new MyStorePage();
            produtoPage = new ProdutoPage();
            myStorePage.setPesquisa(map.get("nome"))
                    .clickProduto(map.get("nome"));
            produtoPage.setQuantidade(map.get("quantidade"))
                    .selectTamanho(map.get("tamanho"))
                    .linkCor(map.get("cor"))
                    .clickCarrinho()
                    .clickContinue();
        }
    }

    @Entao("valido os {string} itens no carrinho")
    public void validoQueOsItensNoCarrinho(String qtdProduto) {
        Assert.assertEquals(qtdProduto, myStorePage.getQtdProduto());
    }
}
