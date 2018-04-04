/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cofre;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author JosielFaleiros
 */
public class ValidacaoHelperSteps {
    String senha;
    @When("^que eu entrei a senha \"([^\"]*)\"$")
    public void que_eu_entrei_a_senha(String senha) throws Exception {
        this.senha = senha;
    }

    @Then("^a senha deve ser valida$")
    public void a_senha_deve_ser_valida() throws Exception {
        assertTrue( ValidacaoHelper.ehSenhaValida(senha) );
    }

    @Then("^a senha deve ser invalida$")
    public void a_senha_deve_ser_invalida() throws Exception {
        assertFalse( ValidacaoHelper.ehSenhaValida(senha) );
    }

}
