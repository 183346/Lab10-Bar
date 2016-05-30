package it.polito.tdp.bar;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class BarController {
	
	Model model ;
	

    public void setModel(Model model) {
		this.model = model;
	}

	@FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtInput"
    private TextField txtInput; // Value injected by FXMLLoader

    @FXML // fx:id="btnSimula"
    private Button btnSimula; // Value injected by FXMLLoader

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader

    @FXML // fx:id="txtResul"
    private TextArea txtResul; // Value injected by FXMLLoader

    @FXML
    void doTavoli(ActionEvent event) {
    	int nPosti = Integer.parseInt(this.txtInput.getText());
    	//creo i tavoli
    	String sTavoli=model.creaTavoli(nPosti);
    	this.txtResul.appendText(sTavoli);
      }

    @FXML
    void doSimula(ActionEvent event) {
    	this.txtResul.clear();
    	
    	String result = model.simula();
    	this.txtResul.appendText(result);

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Bar.fxml'.";
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Bar.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Bar.fxml'.";
        assert txtResul != null : "fx:id=\"txtResul\" was not injected: check your FXML file 'Bar.fxml'.";

    }
}
