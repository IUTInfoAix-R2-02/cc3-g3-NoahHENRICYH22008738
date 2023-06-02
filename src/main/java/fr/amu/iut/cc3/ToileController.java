package fr.amu.iut.cc3;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ToileController implements Initializable {

    private static int rayonCercleExterieur = 200;
    private static int angleEnDegre = 60;
    private static int angleDepart = 90;
    private static int noteMaximale = 20;

    @FXML
    private TextField comp1, comp2, comp3, comp4, comp5, comp6;
    @FXML
    private Circle comp1_dot, comp2_dot, comp3_dot, comp4_dot, comp5_dot, comp6_dot;
    @FXML
    private Text erreur_texte;
    @FXML
    private Button vider, tracer;

    @FXML Line line1, line2, line3, line4, line5, line6;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    // Note: value ; Compétence : axe
    int getXRadarChart(double value, int axe ){
        return (int) (rayonCercleExterieur + Math.cos(Math.toRadians(angleDepart - (axe-1)  * angleEnDegre)) * rayonCercleExterieur
                *  (value / noteMaximale));
    }

    int getYRadarChart(double value, int axe ){
        return (int) (rayonCercleExterieur - Math.sin(Math.toRadians(angleDepart - (axe-1)  * angleEnDegre)) * rayonCercleExterieur
                *  (value / noteMaximale));
    }
    @FXML
    void handleTextFieldAction(ActionEvent e){

        if (e.getSource().equals(comp1)){
            double value = Double.parseDouble(comp1.getText());
            if(value < 0 || value > 20){            erreur_texte.setOpacity(0);
                erreur_texte.setOpacity(1);
                return;
            }
            erreur_texte.setOpacity(0);
            comp1_dot.setCenterX(getXRadarChart(value, 1));
            comp1_dot.setCenterY(getYRadarChart(value, 1));
            comp1_dot.setOpacity(1);
        } else if (e.getSource().equals(comp2)) {
            double value = Double.parseDouble(comp2.getText());
            if(value < 0 || value > 20){
                erreur_texte.setOpacity(1);
                return;
            }
            erreur_texte.setOpacity(0);
            comp2_dot.setCenterX(getXRadarChart(value, 2));
            comp2_dot.setCenterY(getYRadarChart(value, 2));
            comp2_dot.setOpacity(1);
        } else if (e.getSource().equals(comp3)) {
            double value = Double.parseDouble(comp3.getText());
            if(value < 0 || value > 20){
                erreur_texte.setOpacity(1);
                return;
            }
            erreur_texte.setOpacity(0);
            comp3_dot.setCenterX(getXRadarChart(value, 3));
            comp3_dot.setCenterY(getYRadarChart(value, 3));
            comp3_dot.setOpacity(1);
        } else if (e.getSource().equals(comp4)){
            double value = Double.parseDouble(comp4.getText());
            if(value < 0 || value > 20){
                erreur_texte.setOpacity(1);
                return;
            }
            erreur_texte.setOpacity(0);
            comp4_dot.setCenterX(getXRadarChart(value, 4));
            comp4_dot.setCenterY(getYRadarChart(value, 4));
            comp4_dot.setOpacity(1);
        } else if (e.getSource().equals(comp5)) {
            double value = Double.parseDouble(comp5.getText());
            if(value < 0 || value > 20){
                erreur_texte.setOpacity(1);
                return;
            }
            erreur_texte.setOpacity(0);
            comp5_dot.setCenterX(getXRadarChart(value, 5));
            comp5_dot.setCenterY(getYRadarChart(value, 5));
            comp5_dot.setOpacity(1);
        } else if (e.getSource().equals(comp6)) {
            double value = Double.parseDouble(comp6.getText());
            if(value < 0 || value > 20){
                erreur_texte.setOpacity(1);
                return;
            }
            erreur_texte.setOpacity(0);
            comp6_dot.setCenterX(getXRadarChart(value, 6));
            comp6_dot.setCenterY(getYRadarChart(value, 6));
            comp6_dot.setOpacity(1);

        }
    }
    @FXML
    void handleButtonAction(ActionEvent e){
        if(e.getSource().equals(vider)){
            comp1_dot.setOpacity(0);
            comp2_dot.setOpacity(0);
            comp3_dot.setOpacity(0);
            comp4_dot.setOpacity(0);
            comp5_dot.setOpacity(0);
            comp6_dot.setOpacity(0);
            comp1.setText("");
            comp2.setText("");
            comp3.setText("");
            comp4.setText("");
            comp5.setText("");
            comp6.setText("");
        } else if (e.getSource().equals(tracer)) {
            line1.setStartX(comp1_dot.getCenterX());
            line1.setStartY(comp1_dot.getCenterY());
            line1.setEndX(comp2_dot.getCenterX());
            line1.setEndY(comp2_dot.getCenterY());
            line1.setOpacity(1);

            line2.setStartX(comp2_dot.getCenterX());
            line2.setStartY(comp2_dot.getCenterY());
            line2.setEndX(comp3_dot.getCenterX());
            line2.setEndY(comp3_dot.getCenterY());
            line2.setOpacity(1);

            line3.setStartX(comp3_dot.getCenterX());
            line3.setStartY(comp3_dot.getCenterY());
            line3.setEndX(comp4_dot.getCenterX());
            line3.setEndY(comp4_dot.getCenterY());
            line3.setOpacity(1);

            line4.setStartX(comp4_dot.getCenterX());
            line4.setStartY(comp4_dot.getCenterY());
            line4.setEndX(comp5_dot.getCenterX());
            line4.setEndY(comp5_dot.getCenterY());
            line4.setOpacity(1);

            line5.setStartX(comp5_dot.getCenterX());
            line5.setStartY(comp5_dot.getCenterY());
            line5.setEndX(comp6_dot.getCenterX());
            line5.setEndY(comp6_dot.getCenterY());
            line5.setOpacity(1);

            line6.setStartX(comp6_dot.getCenterX());
            line6.setStartY(comp6_dot.getCenterY());
            line6.setEndX(comp1_dot.getCenterX());
            line6.setEndY(comp1_dot.getCenterY());
            line6.setOpacity(1);
        }
    }

}
