package ru.unn.agile.figuresvolumecalculator.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import ru.unn.agile.figuresvolumecalculator.model.FiguresVolumeCalculator.Operation;
import ru.unn.agile.figuresvolumecalculator.viewmodel.ViewModel;

public class FiguresVolumeCalculator {
    @FXML
    private ViewModel viewModel;
    @FXML
    private TextField txtFirstParameter;
    @FXML
    private TextField txtSecondParameter;
    @FXML
    private ComboBox<Operation> comboBoxOperation;
    @FXML
    private Button buttonCalc;

    @FXML
    void initialize() {
        buttonCalc.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                viewModel.calculate();
            }
        });
        txtFirstParameter.textProperty().bindBidirectional(viewModel.firstParameterProperty());
        comboBoxOperation.valueProperty().bindBidirectional(viewModel.operationProperty());
        txtSecondParameter.textProperty().bindBidirectional(viewModel.secondParameterProperty());
    }
}
