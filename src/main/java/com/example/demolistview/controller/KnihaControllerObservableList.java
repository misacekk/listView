package com.example.demolistview.controller;

import com.example.demolistview.model.Kniha;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class KnihaControllerObservableList {
    @FXML private ListView<Kniha> knihaListView;
    @FXML Label titulLabel, autorLabel, rokLabel;
    @FXML
    TextField titulField, autorField, rokField;
    private ObservableList<Kniha> knihy = FXCollections.observableArrayList();
@FXML
public void initializace(){
    knihy.add(new Kniha("2222","geer",656));
    knihy.add(new Kniha("223","geaea",565));
    knihaListView.setItems(knihy);
}
    public void initialize() {
        Kniha kniha = new Kniha("Pepa", "Honza", 2015);
        knihaListView.getItems().add(kniha);

        Kniha kniha2 = new Kniha("Franta", "Lojza", 2022);
        knihaListView.getItems().add(kniha2);

        knihaListView.getItems().add(new Kniha("Kot", "Sop", 1999));
    }

    @FXML
    public void handleVyberKnihu() {
        Kniha vybrana = knihaListView.getSelectionModel().getSelectedItem();
        if (vybrana != null) {
            titulLabel.setText("Titul: " + vybrana.getTitul());
            autorLabel.setText("Autor: " + vybrana.getAutor());
            rokLabel.setText("Rok: " + vybrana.getRokVydani());
        }
    }

    @FXML
    private void handlePridejKnihu() {
        String titul = titulField.getText();
        String autor = autorField.getText();
        int rok = Integer.parseInt(rokField.getText());

        Kniha nova = new Kniha(titul, autor, rok);
        knihaListView.getItems().add(nova);
    }
}
/*package com.example.demolistview.controller;

import com.example.demolistview.model.Kniha;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class KnihaController {

    @FXML private ListView<Kniha> knihaListView;
    @FXML private Label titulLabel, autorLabel, rokLabel;

    public void initialize() {

        Kniha kniha = new Kniha("Pepa", "Honza", 2015);
        knihaListView.getItems().add(kniha);

        Kniha kniha2 = new Kniha("Franta", "Lojza", 2022);
        knihaListView.getItems().add(kniha2);

        knihaListView.getItems().add(new Kniha("Kot", "Sop", 1999));

        knihaListView.setOnMouseClicked(event -> zobrazVybranouKnihu());
    }

    private void zobrazVybranouKnihu() {
        Kniha vybrana = knihaListView.getSelectionModel().getSelectedItem();
        if (vybrana != null) {
            titulLabel.setText("Titul: " + vybrana.getTitul());
            autorLabel.setText("Autor: " + vybrana.getAutor());
            rokLabel.setText("Rok: " + vybrana.getRokVydani());
        }
    }

    @FXML
    public void handleVyberKnihu(ActionEvent actionEvent) {
        zobrazVybranouKnihu();
    }
}*/