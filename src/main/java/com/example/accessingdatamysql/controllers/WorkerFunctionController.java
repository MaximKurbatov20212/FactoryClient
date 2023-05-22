package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dao.entities.WorkerFunction;
import com.example.accessingdatamysql.dao.repo.WorkerFunctionRepository;
import com.example.accessingdatamysql.dto.EquipmentDTO;
import com.example.accessingdatamysql.dto.WorkerFunctionDTO;
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
@FxmlView("WorkerFunctions.fxml")
public class WorkerFunctionController {
    @FXML
    private Button add;
    @FXML private Button edit;
    @FXML private Button drop;
    @FXML private TextField name;
    @FXML private TableView<WorkerFunctionDTO> workerFunctionsTable;
    @Autowired
    private WorkerFunctionRepository workerFunctionRepository;

    @PostMapping(path = "/workerFunction") // Map ONLY POST Requests
    public @ResponseBody String add(@RequestParam String name) {
        return "Saved";
    }
}
