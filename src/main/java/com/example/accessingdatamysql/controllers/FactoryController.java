package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dao.repo.FactoryRepository;
import com.example.accessingdatamysql.dto.EquipmentDTO;
import com.example.accessingdatamysql.dto.FactoryDTO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@FxmlView("Factories.fxml")
public class FactoryController {
	@FXML
	private Button add;
	@FXML private Button edit;
	@FXML private Button drop;
	@FXML private TextField name;
	@FXML private TableView<FactoryDTO> factoriesTable;

	@Autowired
	private FactoryRepository factoryRepository;

	@PostMapping(path="/factory")
	public @ResponseBody String addNewFactory (@RequestParam String name) {
		return "Saved";
	}
}
