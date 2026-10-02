package org.sysimc.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.sysimc.model.Pessoa;

import java.text.DecimalFormat;

public class MainController {
    @FXML
    public TextField txtNome;
    @FXML
    public TextField txtAltura;
    @FXML
    public TextField txtPeso;
    @FXML
    public Label lbIMC;
    @FXML
    public Label lbClassificacao;

    Pessoa pessoa = new Pessoa();

    @FXML
    protected void onCalcularIMCClick() {
        DecimalFormat df = new DecimalFormat();
        this.pessoa.setNome(this.txtNome.getText());
        this.pessoa.setAltura(Float.parseFloat(this.txtAltura.getText()));
        this.pessoa.setPeso(Float.parseFloat(this.txtPeso.getText()));

        df.applyPattern("#0.00");
        this.lbIMC.setText(df.format(this.pessoa.calcularIMC()));
        System.out.println("Nome: " + txtNome.getText());
        System.out.println("Altura: " + txtAltura.getText());
        System.out.println("Peso: " + txtPeso.getText());
        this.lbClassificacao.setText(this.pessoa.classificacaoIMC());
    }
    
}
