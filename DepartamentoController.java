package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import pacoteNegocios.Fachada;
import pacoteEntidades.Departamento;

public class DepartamentoController {

    @FXML private TextField txtNome;
    @FXML private TextField txtArea;
    @FXML private Button btnSalvar;

    @FXML
    void salvarDepartamento(ActionEvent event) {
        try {
            String nome = txtNome.getText().trim();
            String area = txtArea.getText().trim();

            if (nome.isEmpty() || area.isEmpty()) {
                throw new IllegalArgumentException("Todos os campos do departamento devem ser preenchidos.");
            }

            Departamento novoDepto = new Departamento(nome, area);
            Fachada.getInstancia().cadastrarDepartamento(novoDepto);

            exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Departamento registrado com êxito!");
            txtNome.clear();
            txtArea.clear();

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
}