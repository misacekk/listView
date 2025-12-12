package com.example.demolistview.controller;

import com.example.demolistview.model.Kniha;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class KnihaController {

    @FXML
    private ListView<Kniha> knihaListView;
    @FXML
    Label titulLabel, autorLabel, rokLabel, searchLabel;
    @FXML
    TextField titulField, autorField, rokField, searchField;

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

    @FXML
    private void handleSearchKnihu() {
        String hledanyTitul = searchField.getText().trim();

        if (hledanyTitul.isEmpty()) {
            searchLabel.setText("Zadej titul!");
            return;
        }

        for (Kniha k : knihaListView.getItems()) {
            if (k.getTitul().equalsIgnoreCase(hledanyTitul)) {
                knihaListView.getSelectionModel().select(k);
                handleVyberKnihu();
                break;
            }
        }
    }

    @FXML
    private void handleUpravKnihu() {
        Kniha vybrana = knihaListView.getSelectionModel().getSelectedItem();
        if (vybrana != null) {
            vybrana.setTitul(titulField.getText());
            vybrana.setAutor(autorField.getText());
            vybrana.setRokVydani(Integer.parseInt(rokField.getText()));
            knihaListView.refresh();
        }
    }

    @FXML
    private void handleOdeberKnihu() {
        Kniha vybrana = knihaListView.getSelectionModel().getSelectedItem();
        if (vybrana != null) {
            knihaListView.getItems().remove(vybrana);
        }
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