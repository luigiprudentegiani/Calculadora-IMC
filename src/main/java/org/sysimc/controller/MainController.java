package org.sysimc.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.sysimc.model.Pessoa;
import org.sysimc.utils.ArquivoUtil;

import java.text.DecimalFormat;
import java.util.List;

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

    @FXML
    private TableView<Pessoa> tabelaPessoas;

    Pessoa pessoa = new Pessoa();
    @FXML
    protected void onCalcularIMCClick() {
        DecimalFormat df = new DecimalFormat();
        Pessoa novaPessoa = new Pessoa();
        novaPessoa.setNome(this.txtNome.getText());
        novaPessoa.setAltura(Float.parseFloat(this.txtAltura.getText()));
        novaPessoa.setPeso(Float.parseFloat(this.txtPeso.getText()));

        df.applyPattern("#0.00");
        this.lbIMC.setText(df.format(novaPessoa.calcularIMC()));
        this.lbClassificacao.setText(novaPessoa.classificacaoIMC());
        tabelaPessoas.getItems().add(novaPessoa);
    }

    @FXML
    private void acaoBotaoSalvar() {
        List<Pessoa> listaParaSalvar = tabelaPessoas.getItems();
        ArquivoUtil.salvarPessoas(listaParaSalvar);
    }

    @FXML
    private void acaoBotaoCarregar() {
        List<Pessoa> listaCarregada = ArquivoUtil.carregarPessoas();
        tabelaPessoas.getItems().setAll(listaCarregada);
    }
}