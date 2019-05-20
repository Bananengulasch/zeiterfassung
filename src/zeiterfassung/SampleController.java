package zeiterfassung;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class SampleController implements Initializable {
	InvoiceDAO invDAO = new InvoiceDAODBImpl();

	@FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Label label5;
    @FXML
    private Label label6;
    @FXML
    private Label label7;
    @FXML
    private Label label8;
    @FXML
    private Label label9;
    @FXML
    private Label label10;
    @FXML
    private Label label11;
    @FXML
    private Label label12;
    @FXML
    private Label label13;
    @FXML
    private Label label14;
    @FXML
    private Label label15;
    @FXML
    private Label label16;
    @FXML
    private Label label17;
    @FXML
    private Label label18;
    @FXML
    private Label label19;
    @FXML
    private Button button01;
    @FXML
    private Button button02;
    @FXML
    private Button button03;
    @FXML
    private Button button04;
    @FXML
    private Button button05;
    @FXML
    private Button button06;
    @FXML
    private Button button07;
    @FXML
    private TextField textField01;
    @FXML
    private TextField textField02;
    @FXML
    private TextField textField03;
    @FXML
    private TextField textField04;
    @FXML
    private TextField textField05;
    @FXML
    private TextField textField06;
    @FXML
    private TextField textField07;
    @FXML
    private TextField textField08;
    @FXML
    private TextField textField09;
    @FXML
    private TextField textField10;
    @FXML
    private TextField textField11;
    @FXML
    private TextField textField12;
    @FXML
    private TextField textField13;
    @FXML
    private TextField textField14;
    @FXML
    private TextField textField15;
    @FXML
    private TextField textField16;
    @FXML
    private TextField textField17;
    @FXML
    private TextField textField18;
    @FXML
    private DatePicker datepicker01;
    @FXML
    private TableView table01;
    @FXML
    private TableView table02;
    @FXML
    private ChoiceBox choicebox01;
    @FXML
    private ChoiceBox choicebox02;
    
    private int umsatz;
    
    public void initialize(URL url, ResourceBundle rb) {

    	
    	TableColumn mitarbeiterName = new TableColumn("MITARBEITERNAME");
    	TableColumn taetigkeit = new TableColumn("TAETIGKEIT");
    	TableColumn timestamp = new TableColumn("ZEITSTEMPEL");
    	
    	table01.getColumns().addAll(mitarbeiterName, taetigkeit, timestamp);
    	
    	mitarbeiterName.prefWidthProperty().bind(table01.widthProperty().multiply(0.1));
    	taetigkeit.prefWidthProperty().bind(table01.widthProperty().multiply(0.1));
    	timestamp.prefWidthProperty().bind(table01.widthProperty().multiply(0.1));
    	
    	ObservableList<Invoice> obslist = FXCollections.observableArrayList(invDAO.getAllInvoices());
    	
    	
    	mitarbeiterName.setCellValueFactory(new PropertyValueFactory<Invoice, String>("Mitarbeitername"));
    	taetigkeit.setCellValueFactory(new PropertyValueFactory<Invoice, String>("taetigkeit"));
    	timestamp.setCellValueFactory(new PropertyValueFactory<Invoice, String>(""));
    	
    	table01.setItems(obslist);
    	
    }
 
	
    public void buttonAdd() {
    	String name = String.valueOf(textName.getText());
        String modell = String.valueOf(textTaetigkeit.getText());

		 if(textField01.getLength()==0) {
           Alert alert = new Alert(AlertType.INFORMATION);
           alert.setTitle("Information");
           alert.setHeaderText("Bestätigung");
           String s ="Eintrag wurde erfolgreich gespeichert";
           alert.setContentText(s);
           alert.show();
   		invDAO.addInvoice(marke, modell, aufbau, jahr, kilometer, ps,  nwgw, tueren, farbe, getriebe, preis, verkauft );	
       }else {
           int id = Integer.valueOf(textField01.getText());
       	invDAO.updateInvoice(id, marke, modell, aufbau, jahr, kilometer, ps,  nwgw, tueren, farbe, getriebe, preis, verkauft);
       }
		 ObservableList<Invoice> obslist = FXCollections.observableArrayList(invDAO.getAllInvoices());
		 table01.setItems(obslist);
	}
    
    
    	
    		
    	
    
    public void buttonClear() {
    	
    	textField01.setText("");
    	textField02.setText("");
    	textField03.setText("");
    	textField04.setText("");
    	textField05.setText("");
    	textField06.setText("");
    	textField07.setText("");
    	textField08.setText("");
    	textField09.setText("");
    	textField10.setText("");

    }
    
    public void buttonDelete() {
    	
	    
	    Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Information");
		String s = "Bitte bestätigen Sie das Löschen";
		alert.setContentText(s);
		Optional<ButtonType> result = alert.showAndWait();
		if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
			Invoice selectedItem2 = (Invoice) table01.getSelectionModel().getSelectedItem();
			invDAO.deleteInvoice(selectedItem2.getId());
		    table01.getItems().remove(selectedItem2);
		}
    }
    
    public void buttonAddKunde() {
    	String vname = String.valueOf(textField12.getText());
        String nname = String.valueOf(textField13.getText());
        Date birthdate  = Date.valueOf(datepicker01.getValue());
        String adress  = String.valueOf(textField14.getText());
        String email  = String.valueOf(textField15.getText());
        String number  = String.valueOf(textField16.getText());
        int cars = Integer.valueOf(textField17.getText());
        String besitz = "/";

		 if(textField01.getLength()==0) {
           Alert alert = new Alert(AlertType.INFORMATION);
           alert.setTitle("Information");
           alert.setHeaderText("Bestätigung");
           String s ="Eintrag wurde erfolgreich gespeichert";
           alert.setContentText(s);
           alert.show();
   		invDAOKunde.addInvoice(vname, nname, birthdate, adress, email, number, cars, besitz);	
       }else {
           int id = Integer.valueOf(textField01.getText());
       	invDAOKunde.updateInvoice(id, vname, nname, birthdate, adress, email, number, cars, besitz);
       }
		 ObservableList<Invoice> obslistKunde = FXCollections.observableArrayList(invDAO.getAllInvoices());
		 table02.setItems(obslistKunde);
	}
    
    public void buttonClearKunde() {
    	
    	textField11.setText("");
    	textField12.setText("");
    	textField13.setText("");
    	textField14.setText("");
    	textField15.setText("");
    	textField16.setText("");
    	textField17.setText("");
    	datepicker01.setValue(LOCAL_DATE("2016-05-01"));

    }
    
public void buttonDeleteKunde() {
    	
	    
	    Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Information");
		String s = "Bitte bestätigen Sie das Löschen";
		alert.setContentText(s);
		Optional<ButtonType> result = alert.showAndWait();
		if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
			InvoiceKunde selectedItem2 = (InvoiceKunde) table02.getSelectionModel().getSelectedItem();
			invDAOKunde.deleteInvoice(selectedItem2.getId());
		    table02.getItems().remove(selectedItem2);
		}
    }

public void buttonBuy() {
	
	Invoice selectedItem1 = (Invoice) table01.getSelectionModel().getSelectedItem();
	if(selectedItem1.getVerkauft().equals("NEIN")) {
		InvoiceKunde selectedItem2 = (InvoiceKunde) table02.getSelectionModel().getSelectedItem();
		int cars = selectedItem2.getCars();
		cars++;
		
		String besitz = selectedItem2.getBesitz();
		invDAOKunde.updateInvoice(selectedItem2.getId(), selectedItem2.getVname(), selectedItem2.getNname(), selectedItem2.getBirthdate(), selectedItem2.getAdress(), selectedItem2.getEmail(), selectedItem2.getNumber(), cars, besitz + " | " + selectedItem1.getId());
		invDAO.updateInvoice(selectedItem1.getId(), selectedItem1.getMarke(), selectedItem1.getModell(), selectedItem1.getAufbau(), selectedItem1.getJahr(), selectedItem1.getKilometer(), selectedItem1.getPs(), selectedItem1.getNwgw(), selectedItem1.getTueren(), selectedItem1.getFarbe(), selectedItem1.getGetriebe(), selectedItem1.getPreis(), "JA");
		selectedItem2.setCars(cars);
		selectedItem1.setVerkauft("JA");
		umsatz = umsatz + selectedItem1.getPreis();
		textField18.setText(String.valueOf(umsatz) + " " + "Euro");
		
		table02.refresh();
		table01.refresh();
	} else {
		
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("ACHTUNG");
		String s = "Dieses Fahrzeug wurde bereits verkauft!";
		alert.setContentText(s);
		Optional<ButtonType> result = alert.showAndWait();
		table02.refresh();
	}
	
}
    public static final LocalDate LOCAL_DATE (String dateString){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(dateString, formatter);
        return localDate;
    }
}



