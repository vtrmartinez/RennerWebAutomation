package br.com.renner.steps;

import br.com.renner.core.Driver;
import br.com.renner.enums.Browser;
import br.com.renner.pages.LoginPage;
import br.com.renner.pages.MyStorePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;


import java.io.IOException;
import java.util.Map;


public class LoginSteps {
    MyStorePage myStorePage;
    LoginPage loginPage;

    @Before
    public void iniciaNavegador(Scenario cenario){
        new Driver(Browser.CHROME);
        Driver.setNomeCenario(cenario.getName());
        Driver.criaDiretorio();
    }

    @After
    public void fechaNavegador(Scenario cenario) throws IOException {
        if (cenario.isFailed()){
            Driver.printScreen("erro no cenario");
        }
        Driver.getDriver().quit();
    }

    @Dado("que esteja na My Store")
    public void queEstejaNaMyStore() {
        Driver.getDriver().get("http://automationpractice.com");
        myStorePage = new MyStorePage();
    }

    @Dado("que esteja logado")
    public void queEstejaLogado(Map<String, String> map) {
        queEstejaNaMyStore();
        acessoATelaDeLogin();
        relizoOLogin(map);
    }

    @Quando("acesso a tela de login")
    public void acessoATelaDeLogin() {
        myStorePage.clickSignIn();
        loginPage = new LoginPage();
    }

    @Quando("relizo o login")
    public void relizoOLogin(Map<String, String> map) {
        loginPage.setEmail(map.get("email"))
                .setPassword(map.get("password"))
                .clickSignIn();
    }

    @Entao("exibe o nome do usuario {string}")
    public void exibeONomeDoUsuario(String nome) {
        Assert.assertEquals(nome,loginPage.getLogado());
    }
}
