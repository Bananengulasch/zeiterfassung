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
    private Button buttonMitarbeiter_add;
    @FXML
    private Button buttonMitarbeiter_delete;
    @FXML
    private Button buttonMitarbeiter_clear;
    @FXML
    private Button buttonProjekt_add;
    @FXML
    private Button buttonProjekt_delete;
    @FXML
    private Button buttonProjekt_clear;
    @FXML
    private Button button07;
    @FXML
    private TextField textMitarbeiter_vn;
    @FXML
    private TextField textMitarbeiter_nn;
    @FXML
    private TextField textMitarbeiter_id;
    @FXML
    private TextField textProjekt_id;
    @FXML
    private TextField textProjekt_bezeichnung;
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
    private TableView tableMitarbeiter;
    @FXML
    private TableView tableProjektMitarbeiter;
    @FXML
    private TableView tableProjekt;
    @FXML
    private ChoiceBox choiceMitarbeiter;
    @FXML
    private ChoiceBox choiceProjekt;
    
    public void initialize(URL url, ResourceBundle rb) {
    	
    	
    	 choiceMitarbeiter.getItems().clear();
		 for(Mitarbeiter m : invDAO.getAllMitarbeiter()) {
			 choiceMitarbeiter.getItems().add(m.toString());
		 }
    	
		 choiceProjekt.getItems().clear();
		 for(Projekt p : invDAO.getAllProjekte()) {
			
			choiceProjekt.getItems().add(p.toString());
		 }
		 
    	TableColumn mitarbeiterVName = new TableColumn("MITARBEITERVORNAME");
    	TableColumn mitarbeiterNName = new TableColumn("MITARBEITERNACHNAME");
    	TableColumn taetigkeit = new TableColumn("TAETIGKEIT");
    	TableColumn timestamp = new TableColumn("ZEITSTEMPEL");
    	
    	tableProjektMitarbeiter.getColumns().addAll(mitarbeiterVName, mitarbeiterNName, taetigkeit, timestamp);
    	
    	mitarbeiterVName.prefWidthProperty().bind(tableProjektMitarbeiter.widthProperty().multiply(0.3));
    	taetigkeit.prefWidthProperty().bind(tableProjektMitarbeiter.widthProperty().multiply(0.3));
    	timestamp.prefWidthProperty().bind(tableProjektMitarbeiter.widthProperty().multiply(0.3));
    	
    	ObservableList<Invoice> obslist = FXCollections.observableArrayList(invDAO.getAllInvoices());
    	
    	
    	mitarbeiterVName.setCellValueFactory(new PropertyValueFactory<Invoice, String>("Mitarbeitervorname"));
    	mitarbeiterNName.setCellValueFactory(new PropertyValueFactory<Invoice, String>("Mitarbeitername"));
    	taetigkeit.setCellValueFactory(new PropertyValueFactory<Invoice, String>("taetigkeit"));
    	timestamp.setCellValueFactory(new PropertyValueFactory<Invoice, String>(""));
    	timestamp.setCellValueFactory(new PropertyValueFactory<Invoice, String>(""));
    	
    	tableProjektMitarbeiter.setItems(obslist);
    	
    	TableColumn mitarbeiter_id = new TableColumn("MITARBEITER_ID");
    	
    	tableMitarbeiter.getColumns().addAll(mitarbeiter_id, mitarbeiterVName, mitarbeiterNName);
    	
    	mitarbeiterVName.setCellValueFactory(new PropertyValueFactory<Mitarbeiter, String>("Mitarbeiter_vn"));
    	mitarbeiterNName.setCellValueFactory(new PropertyValueFactory<Mitarbeiter, String>("Mitarbeiter_nn"));
    	mitarbeiter_id.setCellValueFactory(new PropertyValueFactory<Mitarbeiter, Integer>("mitarbeiter_id"));
    	mitarbeiter_id.prefWidthProperty().bind(tableMitarbeiter.widthProperty().multiply(0.3));
    	
    	ObservableList<Mitarbeiter> obslistMitarbeiter = FXCollections.observableArrayList(invDAO.getAllMitarbeiter());
    	    	
    	tableMitarbeiter.setItems(obslistMitarbeiter);
    	
    	TableColumn projekt_id = new TableColumn("PROJEKT_ID");
    	TableColumn projekt_bezeichnung = new TableColumn("PROJEKTBEZEICHNUNG");
    	
    	tableProjekt.getColumns().addAll(projekt_id, projekt_bezeichnung);
    	
    	projekt_id.setCellValueFactory(new PropertyValueFactory<Projekt, Integer>("projekt_id"));
    	projekt_bezeichnung.setCellValueFactory(new PropertyValueFactory<Projekt, String>("projekt_bezeichnung"));
    	
    	
    	ObservableList<Projekt> obslistProjekt= FXCollections.observableArrayList(invDAO.getAllProjekte());
    	    	
    	tableProjekt.setItems(obslistProjekt);
    	
    }
 
	
    public void buttonAddMitarbeiter() {
    	String mitarbeiter_vn = String.valueOf(textMitarbeiter_vn.getText());
        String mitarbeiter_nn = String.valueOf(textMitarbeiter_nn.getText());

		 if(textMitarbeiter_id.getLength()==0) {
           Alert alert = new Alert(AlertType.INFORMATION);
           alert.setTitle("Information");
           alert.setHeaderText("Bestätigung");
           String s ="Eintrag wurde erfolgreich gespeichert";
           alert.setContentText(s);
           alert.show();
   		invDAO.addMitarbeiter(mitarbeiter_vn, mitarbeiter_nn);	
       }else {
           int mitarbeiter_id = Integer.valueOf(textMitarbeiter_id.getText());
       	invDAO.updateMitarbeiter(mitarbeiter_id, mitarbeiter_vn, mitarbeiter_nn);
       }
		 ObservableList<Invoice> obslist = FXCollections.observableArrayList(invDAO.getAllInvoices());
		 tableMitarbeiter.setItems(obslist);
		 tableMitarbeiter.refresh();
	}
    
    
    	
    		
    	
    
    public void buttonClear() {
    	
    	

    }
    
    public void buttonMitarbeiterDelete() {
    	
	    
	    Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Information");
		String s = "Bitte bestätigen Sie das Löschen";
		alert.setContentText(s);
		Optional<ButtonType> result = alert.showAndWait();
		if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
			Invoice selectedItem2 = (Invoice) tableProjektMitarbeiter.getSelectionModel().getSelectedItem();
//			invDAO.deleteInvoice(selectedItem2.getId());
//		    table01.getItems().remove(selectedItem2);
		}
    }

		public void buttonAddProjekt() {
    	String projekt_bezeichnung = String.valueOf(textProjekt_bezeichnung.getText());
   

		 if(textProjekt_id.getLength()==0) {
           Alert alert = new Alert(AlertType.INFORMATION);
           alert.setTitle("Information");
           alert.setHeaderText("Bestätigung");
           String s ="Eintrag wurde erfolgreich gespeichert";
           alert.setContentText(s);
           alert.show();
   		invDAO.addProjekt(projekt_bezeichnung);	
       }else {
           int id = Integer.valueOf(textProjekt_id.getText());
       	invDAO.updateProjekt(id, projekt_bezeichnung);
       }
		 ObservableList<Invoice> obslistKunde = FXCollections.observableArrayList(invDAO.getAllInvoices());
		 tableProjekt.setItems(obslistKunde);
		 tableProjekt.refresh();
	}
		
		 public void buttonAddTaetigkeit() {
			
			 
		    	String mitarbeiter_vn = String.valueOf(textMitarbeiter_vn.getText());
		        String mitarbeiter_nn = String.valueOf(textMitarbeiter_nn.getText());

				 if(textMitarbeiter_id.getLength()==0) {
		           Alert alert = new Alert(AlertType.INFORMATION);
		           alert.setTitle("Information");
		           alert.setHeaderText("Bestätigung");
		           String s ="Eintrag wurde erfolgreich gespeichert";
		           alert.setContentText(s);
		           alert.show();
		   		invDAO.addMitarbeiter(mitarbeiter_vn, mitarbeiter_nn);	
		       }else {
		           int mitarbeiter_id = Integer.valueOf(textMitarbeiter_id.getText());
		       	invDAO.updateMitarbeiter(mitarbeiter_id, mitarbeiter_vn, mitarbeiter_nn);
		       }
				 ObservableList<Invoice> obslist = FXCollections.observableArrayList(invDAO.getAllInvoices());
				 tableMitarbeiter.setItems(obslist);
				 tableMitarbeiter.refresh();
			}
		 
		 
}
//    
//    public void buttonClearKunde() {
//    	
//    	textField11.setText("");
//    	textField12.setText("");
//    	textField13.setText("");
//    	textField14.setText("");
//    	textField15.setText("");
//    	textField16.setText("");
//    	textField17.setText("");
//    	datepicker01.setValue(LOCAL_DATE("2016-05-01"));
//
//    }
//    
//public void buttonDeleteKunde() {
//    	
//	    
//	    Alert alert = new Alert(AlertType.CONFIRMATION);
//		alert.setTitle("Information");
//		String s = "Bitte bestätigen Sie das Löschen";
//		alert.setContentText(s);
//		Optional<ButtonType> result = alert.showAndWait();
//		if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
//			InvoiceKunde selectedItem2 = (InvoiceKunde) table02.getSelectionModel().getSelectedItem();
//			invDAOKunde.deleteInvoice(selectedItem2.getId());
//		    table02.getItems().remove(selectedItem2);
//		}
//    }
//
//}



