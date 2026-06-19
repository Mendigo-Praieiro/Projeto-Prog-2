package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import pacoteNegocios.Fachada;
import pacoteEntidades.Cadeira;
import pacoteEntidades.TipoDisciplina; // Certifique-se do caminho do enum do seu projeto

public class CadeiraController {

    @FXML private TextField txtCodigo;
    @FXML private TextField txtNome;
    @FXML private TextField txtCargaHoraria;
    @FXML private TextField txtTipo;
    @FXML private Button btnSalvar;

    @FXML
    void salvarCadeira(ActionEvent event) {
        try {
            int codigo = Integer.parseInt(txtCodigo.getText().trim());
            String nome = txtNome.getText().trim();
            int cargaHoraria = Integer.parseInt(txtCargaHoraria.getText().trim());
            String tipoStr = txtTipo.getText().trim().toUpperCase();

            if (nome.isEmpty() || tipoStr.isEmpty()) {
                throw new IllegalArgumentException("Nome e Tipo de Disciplina devem ser informados.");
            }

            // Realiza o parse seguro para o Enum mapeado na camada de Entidades
            TipoDisciplina tipoEnum;
            try {
                tipoEnum = TipoDisciplina.valueOf(tipoStr);
            } catch (IllegalArgumentException e) {
                throw new Exception("Tipo inválido! Use apenas: OBRIGATORIA ou ELETIVA.");
            }

            Cadeira novaCadeira = new Cadeira(codigo, nome, cargaHoraria, tipoEnum);
            Fachada.getInstancia().cadastrarCadeira(novaCadeira);

            exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Disciplina '" + nome + "' integrada ao catálogo.");
            limparCampos();

        } catch (NumberFormatException e) {
            exibirAlerta(Alert.AlertType.ERROR, "Erro de Formato", "Código e Carga Horária aceitam apenas números inteiros.");
        } catch (Exception e) {
            exibirAlerta(Alert.AlertType.ERROR, "Falha Operacional", e.getMessage());
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
        txtCodigo.clear();
        txtNome.clear();
        txtCargaHoraria.clear();
        txtTipo.clear();
    }
}