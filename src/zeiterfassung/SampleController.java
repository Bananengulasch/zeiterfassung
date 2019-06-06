package zeiterfassung;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
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
    private Button buttonTaetigkeit_add;
    @FXML
    private Button buttonTaetigkeit_delete;
    @FXML
    private Button buttonTaetigkeit_clear;
    @FXML
    private Button buttonEvaluation;
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
    private TextArea textTaetigkeit;
    @FXML
    private TextField texttaetigkeit_dauer;
    @FXML
    private TextField texttaetigkeit_id;
    @FXML
    private TextField textAuswertung_id;
    @FXML
    private TextField StundenMitarbeiter;
    @FXML
    private DatePicker dateTaetigkeit;
    @FXML
    private TableView tableMitarbeiter;
    @FXML
    private TableView tableProjektMitarbeiter;
    @FXML
    private TableView tableProjekt;
    @FXML
    private TableView tableAuswertung;
    @FXML
    private ChoiceBox choiceMitarbeiter;
    @FXML
    private ChoiceBox choiceProjekt;
    @FXML
    private ChoiceBox choiceMitarbeiterAuswertung;
    @FXML
    private ChoiceBox choiceMonth;
    
    public void initialize(URL url, ResourceBundle rb) {
    	
    			//////////////////////////
    			/// TABELLE TÄETIGKEIT ///
    			//////////////////////////
    	
		 
		TableColumn projektposition_id_column = new TableColumn("EINTRAG-ID");
    	TableColumn mitarbeiter_id_column = new TableColumn("MITARBEITER-ID");
    	TableColumn projekt_id_column = new TableColumn("PROJEKT-ID");
    	TableColumn projektposition_bezeichnung_column = new TableColumn("TAETIGKEIT");
    	TableColumn projektposition_datum_column = new TableColumn("DATUM");
    	TableColumn projektposition_dauer_column = new TableColumn("DAUER");
    	
    	tableProjektMitarbeiter.getColumns().addAll(projektposition_id_column, mitarbeiter_id_column, projekt_id_column, projektposition_bezeichnung_column, projektposition_datum_column, projektposition_dauer_column);
    	
    	projektposition_id_column.prefWidthProperty().bind(tableProjektMitarbeiter.widthProperty().multiply(0.2));
    	mitarbeiter_id_column.prefWidthProperty().bind(tableProjektMitarbeiter.widthProperty().multiply(0.2));
    	projektposition_bezeichnung_column.prefWidthProperty().bind(tableProjektMitarbeiter.widthProperty().multiply(0.2));
    	projektposition_datum_column.prefWidthProperty().bind(tableProjektMitarbeiter.widthProperty().multiply(0.2));
    	projektposition_dauer_column.prefWidthProperty().bind(tableProjektMitarbeiter.widthProperty().multiply(0.2));
    	
    	ObservableList<Invoice> obslist = FXCollections.observableArrayList(invDAO.getAllInvoices());
    	
    	
    	projektposition_id_column.setCellValueFactory(new PropertyValueFactory<Invoice, Integer>("id"));
    	mitarbeiter_id_column.setCellValueFactory(new PropertyValueFactory<Invoice, Integer>("mitarbeiter_id"));
    	projekt_id_column.setCellValueFactory(new PropertyValueFactory<Invoice, Integer>("projekt_id"));
    	projektposition_bezeichnung_column.setCellValueFactory(new PropertyValueFactory<Invoice, String>("taetigkeit"));
    	projektposition_datum_column.setCellValueFactory(new PropertyValueFactory<Invoice, String>("timestamp"));
    	projektposition_dauer_column.setCellValueFactory(new PropertyValueFactory<Invoice, String>("dauer"));
    	
    	tableProjektMitarbeiter.setItems(obslist);
    	
    					//////////////////////////
    					/// TABELLE Mitarbeiter ///
    					//////////////////////////
    	
    	TableColumn mitarbeiterVName = new TableColumn("MITARBEITERVORNAME");
    	TableColumn mitarbeiterNName = new TableColumn("MITARBEITERNACHNAME");
    	TableColumn mitarbeiter_id = new TableColumn("MITARBEITER_ID");
    	
    	tableMitarbeiter.getColumns().addAll(mitarbeiter_id, mitarbeiterVName, mitarbeiterNName);
    	
    	mitarbeiterVName.setCellValueFactory(new PropertyValueFactory<Mitarbeiter, String>("Mitarbeiter_vn"));
    	mitarbeiterNName.setCellValueFactory(new PropertyValueFactory<Mitarbeiter, String>("Mitarbeiter_nn"));
    	mitarbeiter_id.setCellValueFactory(new PropertyValueFactory<Mitarbeiter, Integer>("mitarbeiter_id"));
    	
    	mitarbeiter_id.prefWidthProperty().bind(tableMitarbeiter.widthProperty().multiply(0.3));
    	mitarbeiter_id.prefWidthProperty().bind(tableMitarbeiter.widthProperty().multiply(0.3));
    	mitarbeiter_id.prefWidthProperty().bind(tableMitarbeiter.widthProperty().multiply(0.3));
    	
    	ObservableList<Mitarbeiter> obslistMitarbeiter = FXCollections.observableArrayList(invDAO.getAllMitarbeiter());
    	    	
    	tableMitarbeiter.setItems(obslistMitarbeiter);
    	
    			//////////////////////////
				/// TABELLE Projekt ///
				//////////////////////////
    	updateCheckbox();
    	
    	TableColumn projekt_id = new TableColumn("PROJEKT_ID");
    	TableColumn projekt_bezeichnung = new TableColumn("PROJEKTBEZEICHNUNG");
    	
    	tableProjekt.getColumns().addAll(projekt_id, projekt_bezeichnung);
    	
    	projekt_id.setCellValueFactory(new PropertyValueFactory<Projekt, Integer>("projekt_id"));
    	projekt_bezeichnung.setCellValueFactory(new PropertyValueFactory<Projekt, String>("projekt_bezeichnung"));
    	
    	
    	ObservableList<Projekt> obslistProjekt= FXCollections.observableArrayList(invDAO.getAllProjekte());
    	    	
    	tableProjekt.setItems(obslistProjekt);
    	
    			//////////////////////////
    			/// TABELLE Auswertung ///
    			//////////////////////////

    	TableColumn projektposition_id_column_ev = new TableColumn("PROJEKTPOSITION-ID");
    	TableColumn mitarbeiter_id_column_ev = new TableColumn("MITARBEITER-ID");
    	TableColumn projekt_id_column_ev = new TableColumn("PROJEKT-ID");
    	TableColumn projektposition_bezeichnung_column_ev = new TableColumn("TAETIGKEIT");
    	TableColumn projektposition_datum_column_ev = new TableColumn("DATUM");
    	TableColumn projektposition_dauer_column_ev = new TableColumn("DAUER");
		
		tableAuswertung.getColumns().addAll(projektposition_id_column_ev, mitarbeiter_id_column_ev, projekt_id_column_ev, projektposition_bezeichnung_column_ev, projektposition_datum_column_ev, projektposition_dauer_column_ev);
		
		projektposition_id_column_ev.setCellValueFactory(new PropertyValueFactory<Invoice, Integer>("id"));
    	mitarbeiter_id_column_ev.setCellValueFactory(new PropertyValueFactory<Invoice, Integer>("mitarbeiter_id"));
    	projekt_id_column_ev.setCellValueFactory(new PropertyValueFactory<Invoice, Integer>("projekt_id"));
    	projektposition_bezeichnung_column_ev.setCellValueFactory(new PropertyValueFactory<Invoice, String>("taetigkeit"));
    	projektposition_datum_column_ev.setCellValueFactory(new PropertyValueFactory<Invoice, String>("timestamp"));
    	projektposition_dauer_column_ev.setCellValueFactory(new PropertyValueFactory<Invoice, String>("dauer"));
    	
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
		 ObservableList<Mitarbeiter> obslistMitarbeiter = FXCollections.observableArrayList(invDAO.getAllMitarbeiter());
		 tableMitarbeiter.setItems(obslistMitarbeiter);
		 tableMitarbeiter.refresh();
		 updateCheckbox();
	}
    
    
    public void buttonClearMitarbeiter() {
    	
	textMitarbeiter_vn.setText("");
	textMitarbeiter_nn.setText("");
	textMitarbeiter_id.setText("");
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
		 ObservableList<Projekt> obslistProjekt = FXCollections.observableArrayList(invDAO.getAllProjekte());
		 tableProjekt.setItems(obslistProjekt);
		 tableProjekt.refresh();
		 updateCheckbox();
	}
		
	    public void buttonClearProjekt() {
	    	
	    	textProjekt_id.setText("");
	    	textProjekt_bezeichnung.setText("");
	        }
		
		 public void buttonAddTaetigkeit() {
			
			 
		    	String taetigkeit_bezeichnung = String.valueOf(textTaetigkeit.getText());
		        String taetigkeit_dauer = String.valueOf(texttaetigkeit_dauer.getText());
		        Date d = convertToDateViaSqlDate(dateTaetigkeit.getValue());
		        int mitarbeiter_id = invDAO.getSpecificId(choiceMitarbeiter.getValue().toString());
		        int projekt_id = invDAO.getSpecificProjektId(choiceProjekt.getValue().toString());
		        if(texttaetigkeit_id.getLength()==0) {
		           Alert alert = new Alert(AlertType.INFORMATION);
		           alert.setTitle("Information");
		           alert.setHeaderText("Bestätigung");
		           String s ="Eintrag wurde erfolgreich gespeichert";
		           alert.setContentText(s);
		           alert.show();
		           
				 
				
		   		invDAO.addInvoice(mitarbeiter_id, projekt_id, taetigkeit_bezeichnung, d, taetigkeit_dauer);	
		       }else {
		           int taetigkeit_id = Integer.valueOf(texttaetigkeit_id.getText());
		       	invDAO.updateInvoice(taetigkeit_id, mitarbeiter_id, projekt_id, taetigkeit_bezeichnung, d, taetigkeit_dauer);
		       }
				 ObservableList<Invoice> obslist = FXCollections.observableArrayList(invDAO.getAllInvoices());
				 tableProjektMitarbeiter.setItems(obslist);
				 tableProjektMitarbeiter.refresh();
			}
		 
		    public void buttonClearTaetigkeit() {
		    	textTaetigkeit.setText("");
		    	texttaetigkeit_id.setText("");
		    	texttaetigkeit_dauer.setText("");
		    	choiceMitarbeiter.setValue(null);
		    	choiceProjekt.setValue(null);
		        }
		 	
		 public void buttonEvaluation() {

			 
		    	int mitarbeiter_id_ev = invDAO.getSpecificId(choiceMitarbeiterAuswertung.getValue().toString());
		    	int mitarbeiter_hours = invDAO.getMitarbeiterHours(mitarbeiter_id_ev);
		    	StundenMitarbeiter.setText(Integer.toString(mitarbeiter_hours));
		    	String month = choiceMonth.getValue().toString();
		    	int intmonth = getMonth(month);
		        
				 ObservableList<Invoice> obslistAuswertung = FXCollections.observableArrayList(invDAO.getSpecificMitarbeiterId(mitarbeiter_id_ev, intmonth));
				 if(texttaetigkeit_id.getLength()==0 && !obslistAuswertung.isEmpty()) {
			           Alert alert = new Alert(AlertType.INFORMATION);
			           alert.setTitle("Information");
			           alert.setHeaderText("Bestätigung");
			           String s ="Auswertung erfolgreich";
			           alert.setContentText(s);
			           alert.show();
				 }
			           else{ if(obslistAuswertung.isEmpty()) {
					 Alert warning = new Alert(AlertType.WARNING);
			           warning.setTitle("WARNUNG");
			           warning.setHeaderText("WARNUNG");
			           String w ="Keine Daten vorhanden!";
			           warning.setContentText(w);
			           warning.show();
				 }
			           }
				 tableAuswertung.setItems(obslistAuswertung);
				 tableAuswertung.refresh();
			
		 }
		 
		 public Date convertToDateViaSqlDate(LocalDate dateToConvert) {
			    return java.sql.Date.valueOf(dateToConvert);
			}
		 
		 private Integer getMonth(String month) {
			 
			 switch (month) {
	            case "January" :  month = "1";       break;
	            case "February":  month = "2";      break;
	            case "March":  month = "3";         break;
	            case "April":  month = "4";         break;
	            case "May":  month = "5";           break;
	            case "June":  month = "6";          break;
	            case "July":  month = "7";          break;
	            case "August":  month = "8";        break;
	            case "September":  month = "9";     break;
	            case "October": month = "10";       break;
	            case "November": month = "11";      break;
	            case  "December": month = "12";      break;
	            default: month = "Invalid month"; break;
	        }
	        return Integer.valueOf(month);
		 }
		 
		 private void updateCheckbox() {
			 choiceMonth.getItems().clear();
			 choiceMonth.getItems().addAll("January", "February", "March", "April", "May","June","July","August","September","October","November","December");
			 
			 choiceMitarbeiter.getItems().clear();
			 for(Mitarbeiter m : invDAO.getAllMitarbeiter()) {
				 choiceMitarbeiter.getItems().add(m.toString());
			 }
	    	
			 choiceProjekt.getItems().clear();
			 for(Projekt p : invDAO.getAllProjekte()) {
				
				choiceProjekt.getItems().add(p.toString());
			 }
			 
			 choiceMitarbeiterAuswertung.getItems().clear();
			 for(Mitarbeiter m : invDAO.getAllMitarbeiter()) {
				 choiceMitarbeiterAuswertung.getItems().add(m.toString());
			 }
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



