package com.example.demolistview.controller;

import com.example.demolistview.model.Kniha;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class KnihaController {

    @FXML
    private ListView<Kniha> knihaListView;
    @FXML
    private Label titulLabel, autorLabel, rokLabel, searchLabel;
    @FXML
    private TextField titulField, autorField, rokField, searchField;

    public void initialize() {
        try {
            knihaListView.getItems().add(new Kniha("Pepa", "Honza", 2015));
            knihaListView.getItems().add(new Kniha("Franta", "Lojza", 2022));
            knihaListView.getItems().add(new Kniha("Kot", "Sop", 1999));
        } catch (Exception e) {
            System.out.println("Chyba při načítání seznamu knih: " + e.getMessage());
        }
    }

    @FXML
    public void handleVyberKnihu() {
        try {
            Kniha vybrana = knihaListView.getSelectionModel().getSelectedItem();
            if (vybrana == null) return;
            titulLabel.setText("Titul: " + vybrana.getTitul());
            autorLabel.setText("Autor: " + vybrana.getAutor());
            rokLabel.setText("Rok: " + vybrana.getRokVydani());
        } catch (Exception e) {
            System.out.println("Chyba při výběru knihy: " + e.getMessage());
        }
    }

    @FXML
    private void handlePridejKnihu() {
        try {
            String titul = titulField.getText();
            String autor = autorField.getText();
            String rokText = rokField.getText();

            if (titul == null || titul.isBlank()) return;
            if (autor == null || autor.isBlank()) return;
            if (rokText == null || rokText.isBlank()) return;

            int rok;
            try {
                rok = Integer.parseInt(rokText);
            } catch (NumberFormatException e) {
                System.out.println("Neplatný rok!");
                return;
            }

            knihaListView.getItems().add(new Kniha(titul, autor, rok));

        } catch (Exception e) {
            System.out.println("Chyba při přidávání knihy: " + e.getMessage());
        }
    }

    @FXML
    private void handleSearchKnihu() {
        try {
            String hledanyTitul = searchField.getText();
            if (hledanyTitul == null || hledanyTitul.isBlank()) {
                searchLabel.setText("Zadej titul!");
                return;
            }

            boolean nalezeno = false;

            for (Kniha k : knihaListView.getItems()) {
                if (k != null && k.getTitul() != null &&
                        k.getTitul().equalsIgnoreCase(hledanyTitul.trim())) {
                    knihaListView.getSelectionModel().select(k);
                    handleVyberKnihu();
                    nalezeno = true;
                    break;
                }
            }

            if (!nalezeno) searchLabel.setText("Nenalezena");

        } catch (Exception e) {
            System.out.println("Chyba při hledání knihy: " + e.getMessage());
        }
    }

    @FXML
    private void handleUpravKnihu() {
        try {
            Kniha vybrana = knihaListView.getSelectionModel().getSelectedItem();
            if (vybrana == null) return;

            String titul = titulField.getText();
            String autor = autorField.getText();
            String rokText = rokField.getText();

            if (titul == null || titul.isBlank()) return;
            if (autor == null || autor.isBlank()) return;
            if (rokText == null || rokText.isBlank()) return;

            int rok;
            try {
                rok = Integer.parseInt(rokText);
            } catch (NumberFormatException e) {
                System.out.println("Neplatný rok!");
                return;
            }

            vybrana.setTitul(titul);
            vybrana.setAutor(autor);
            vybrana.setRokVydani(rok);

            knihaListView.refresh();

        } catch (Exception e) {
            System.out.println("Chyba při úpravě knihy: " + e.getMessage());
        }
    }

    @FXML
    private void handleOdeberKnihu() {
        try {
            Kniha vybrana = knihaListView.getSelectionModel().getSelectedItem();
            if (vybrana != null) knihaListView.getItems().remove(vybrana);
        } catch (Exception e) {
            System.out.println("Chyba při odebírání knihy: " + e.getMessage());
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