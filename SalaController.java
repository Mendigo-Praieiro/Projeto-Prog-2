package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import pacoteNegocios.Fachada;
import pacoteEntidades.Sala;

public class SalaController {

    @FXML private TextField txtNumero;
    @FXML private TextField txtBloco;
    @FXML private TextField txtCapacidade;
    @FXML private Button btnSalvar;

    @FXML
    void salvarSala(ActionEvent event) {
        try {
            int numero = Integer.parseInt(txtNumero.getText().trim());
            String bloco = txtBloco.getText().trim();
            int capacidade = Integer.parseInt(txtCapacidade.getText().trim());

            if (bloco.isEmpty()) {
                throw new IllegalArgumentException("O campo Bloco não pode estar vazio.");
            }

            Sala novaSala = new Sala(numero, bloco, capacidade);
            Fachada.getInstancia().cadastrarSala(novaSala);

            exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Sala cadastrada com sucesso!");
            limparCampos();

        } catch (NumberFormatException e) {
            exibirAlerta(Alert.AlertType.ERROR, "Erro de Tipo", "Número e Capacidade devem ser valores inteiros.");
        } catch (Exception e) {
            exibirAlerta(Alert.AlertType.ERROR, "Erro no Cadastro", e.getMessage());
        }
    }

    private void exibirAlerta(Alert.AlertType tipo, String titulo, String mensagem) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    private void limparCampos() {
        txtNumero.clear();
        txtBloco.clear();
        txtCapacidade.clear();
    }
}