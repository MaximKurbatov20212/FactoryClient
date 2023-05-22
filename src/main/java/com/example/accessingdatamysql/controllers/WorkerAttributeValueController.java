package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dao.repo.WorkerAttributeValueRepository;
import com.example.accessingdatamysql.dto.WorkerAttributeValueDTO;
import com.example.accessingdatamysql.dto.WorkerCategoryDTO;
import com.example.accessingdatamysql.dto.WorkerDTO;
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
@FxmlView("WorkerAttributeValue.fxml")
public class WorkerAttributeValueController {
    @FXML
    private Button add;
    @FXML private Button edit;
    @FXML private Button drop;

    @FXML private TextField value;
    @FXML private TableView<WorkerDTO> workersTable;
    @FXML private TableView<WorkerCategoryDTO> workerCategoriesTable;
    @FXML private TableView<WorkerAttributeValueDTO> workerAttributeValuesTable;

    @Autowired
    private WorkerAttributeValueRepository workerAttributeValueRepository;

    @PostMapping(path = "/workerAttribute") // Map ONLY POST Requests
    public @ResponseBody String add(@RequestParam String name) {
        return "Saved";
    }
}
