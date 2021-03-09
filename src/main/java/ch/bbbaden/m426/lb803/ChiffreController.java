package ch.bbbaden.m426.lb803;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Manuel Bachofner
 */
public class ChiffreController implements Initializable {
    
    @FXML
    private AnchorPane txtKey;
    @FXML
    private Button btnVerschluesseln;
    @FXML
    private Button btnKamasutra;
    
    private final Chiffrierer chiffrierer = new Chiffrierer();
    @FXML
    private Button btnBack;
    @FXML
    private Button btnTransposition;
    @FXML
    private Label lblError;
    @FXML
    private Label lblLog;
    @FXML
    private TextArea txtText;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtText.textProperty().bindBidirectional(chiffrierer.getEingabe());
        lblLog.textProperty().bind(chiffrierer.getLog());
    }
    
    @FXML
    private void speichereCaesar(ActionEvent event) {
        if (isValid()) {
            chiffrierer.fuehreAus(Chiffriermethode.Caesar);
        }
    }
    
    @FXML
    private void speichereTransposition(ActionEvent event) {
        if (isValid()) {
            chiffrierer.fuehreAus(Chiffriermethode.Transposition);
        }
    }
    
    @FXML
    private void speichereKamasutra(ActionEvent event) {
        if (isValid()) {
            chiffrierer.fuehreAus(Chiffriermethode.Kamasutra);
        }
    }
    
    @FXML
    private void rueckgaengig(ActionEvent event) {
        chiffrierer.macheRueckgaenig();
    }
    
    private boolean isValid() {
        Pattern p = Pattern.compile("[^a-zA-Z0-9]");
        if (txtText.getText().length() > 2 && p.matcher(txtText.getText()).find()) {
            lblError.setText("Bitte geben Sie einen alphanumerischen Text mit mindestens 3 Buchstaben ein");
            return false;
        }
        lblError.setText("");
        return true;
    }
    
    @FXML
    private void loescheLog(KeyEvent event) {
        chiffrierer.leereLog();
    }
}
