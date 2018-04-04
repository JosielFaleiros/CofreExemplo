/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cofre;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author JosielFaleiros
 */
public class CofrePMSteps extends CofrePMTest {

    @Given("^que temos uma instancia de CofrePM com SensorPorta e uma Memoria$")
    public void que_temos_uma_instancia_de_CofrePM_com_SensorPorta_e_uma_Memoria() throws Exception {
        sensorMock = mock(SensorPorta.class);
        memoriaMock = mock(Memoria.class);
        cofrePM = new CofrePM(sensorMock, memoriaMock);

        when(sensorMock.fechada())
                .thenReturn(Boolean.TRUE);
        when(sensorMock.travada())
                .thenReturn(Boolean.TRUE);
    }

    @Given("^eu digitei a senha invalida$")
    public void eu_digitei_a_senha_invalida() throws Exception {
        when(memoriaMock.getSenha())
                .thenReturn("123456");
        cofrePM.pressButton(1);
        cofrePM.pressButton(2);
        cofrePM.pressButton(3);
        cofrePM.pressButton(4);
        cofrePM.pressButton(6);
        cofrePM.pressButton(6);
    }

    @Given("^eu digitei a senha com menos de seis$")
    public void eu_digitei_a_senha_com_menos_de_seis() throws Exception {
        when(memoriaMock.getSenha())
                .thenReturn("123456");

        cofrePM.pressButton(1);
        cofrePM.pressButton(1);
    }

    @Given("^eu digitei a senha correta$")
    public void eu_digitei_a_senha_correta() throws Exception {
        when(memoriaMock.getSenha())
                .thenReturn("123466");

        cofrePM.pressButton(1);
        cofrePM.pressButton(2);
        cofrePM.pressButton(3);
        cofrePM.pressButton(4);
        cofrePM.pressButton(6);
        cofrePM.pressButton(6);
    }

    @Given("^eu digitei uma senha com a porta aberta$")
    public void eu_digitei_uma_senha_com_a_porta_aberta() throws Exception {
        when(sensorMock.fechada())
                .thenReturn(Boolean.FALSE);

        for (int botao = 0; botao <= 9; botao++) {
            cofrePM.pressButton(botao);
        }
    }

    @Given("^eu digitei uma senha com um numero com porta fechada$")
    public void eu_digitei_uma_senha_com_um_numero_com_porta_fechada() throws Exception {
        when(sensorMock.fechada())
                .thenReturn(Boolean.TRUE);

        cofrePM.pressButton(0);
    }

    @Given("^eu digitei uma senha valida com porta fechada$")
    public void eu_digitei_uma_senha_valida_com_porta_fechada() throws Exception {
        when(sensorMock.fechada())
                .thenReturn(Boolean.TRUE);
        when(sensorMock.travada())
                .thenReturn(Boolean.FALSE);

        cofrePM.pressButton(1);
        cofrePM.pressButton(9);
        cofrePM.pressButton(3);
        cofrePM.pressButton(5);
        cofrePM.pressButton(6);
        cofrePM.pressButton(6);
    }

    @Given("^eu digitei uma senha com menos de seis$")
    public void eu_digitei_uma_senha_com_menos_de_seis() throws Exception {
        when(sensorMock.fechada())
                .thenReturn(Boolean.TRUE);
        when(sensorMock.travada())
                .thenReturn(Boolean.FALSE);
        cofrePM.pressButton(1);
        cofrePM.pressButton(1);
    }

    @Given("^eu digitei uma senha com a porta fechada$")
    public void eu_digitei_uma_senha_com_a_porta_fechada() throws Exception {
        when(sensorMock.fechada())
                .thenReturn(Boolean.TRUE);
        cofrePM.pressButton(9);
        cofrePM.pressButton(8);
    }

    @When("^eu abri a porta$")
    public void eu_abri_a_porta() throws Exception {
        when(sensorMock.fechada())
                .thenReturn(Boolean.FALSE);
        cofrePM.pressButton(7);
    }

    @When("^eu apertei ok$")
    public void eu_apertei_ok() throws Exception {
        cofrePM.ok();
    }

    @Then("^a mensagem do display deve ser \"([^\"]*)\"$")
    public void a_mensagem_do_display_deve_ser(String msg) throws Exception {
        assertEquals(msg, cofrePM.getDisplay());
    }

}
