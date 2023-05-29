package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.TableStatus;
import com.example.accessingdatamysql.dto.FactoryDTO;
import com.example.accessingdatamysql.exception.ItemException;
import com.example.accessingdatamysql.service.FactoryService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("Factories.fxml")
public class FactoryController {
	@FXML
	private Button add;
	@FXML private Button edit;
	@FXML private Button drop;
	@FXML private TextField name;
	@FXML private TableView<FactoryDTO> factoriesTable;

	private final FactoryService factoryService;

	public FactoryController(FactoryService service) {
		this.factoryService = service;
	}

	private void clickButton() {
		add.setOnAction(event -> addEvent());
		edit.setOnAction(event -> editEvent());
		drop.setOnAction(event -> dropEvent());
	}

	private void dropEvent() {
		FactoryDTO item =  factoriesTable.getSelectionModel().getSelectedItem();
		if (item == null) {
			throw new ItemException("select record");
		}

		factoryService.drop(item);
		factoriesTable.setItems(FXCollections.observableList(factoryService.getAll()));
	}

	private void editEvent() {
		FactoryDTO item =  factoriesTable.getSelectionModel().getSelectedItem();
		if (item == null) {
			throw new ItemException("select record");
		}

		factoryService.edit(FactoryDTO.builder().name(name.getText()).build());
		factoriesTable.setItems(FXCollections.observableList(factoryService.getAll()));
	}

	private void addEvent() {
		try {
			FactoryDTO item = FactoryDTO.builder().name(name.getText()).build();
			factoryService.add(item);
			factoriesTable.setItems(FXCollections.observableList(factoryService.getAll()));
		}
		catch (Exception e) {
			System.err.println("factory add error");
		}
	}
}
