package br.com.renner.pages;

import br.com.renner.core.Driver;
import br.com.renner.maps.LoginMap;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    LoginMap loginMap;
    public LoginPage(){
        loginMap = new LoginMap();
        PageFactory.initElements(Driver.getDriver(), loginMap);
    }

    public LoginPage setEmail(String email){
        loginMap.inpEmail.sendKeys(email);
        return this;
    }
    public LoginPage setPassword(String password){
        loginMap.inpPassword.sendKeys(password);
        return this;
    }
    public LoginPage clickSignIn(){
        loginMap.btnSignIn.click();
        return this;
    }
    public LoginPage clickPaginaPrincipal(){
        loginMap.linkPaginaPrincipal.click();
        return this;
    }
    public String getLogado(){
        return loginMap.textLogado.getText();
    }
    public LoginPage setEmailCreate(String emailCreate){
        loginMap.inpEmailCreate.sendKeys(emailCreate);
        return this;
    }
    public LoginPage setSubmitCreate(String submitCreate){
        loginMap.inpSubmitCreate.sendKeys(submitCreate);
        return this;
    }
}
