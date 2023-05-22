package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dao.repo.WorkerRepository;
import com.example.accessingdatamysql.dto.BrigadeDTO;
import com.example.accessingdatamysql.dto.WorkerDTO;
import com.example.accessingdatamysql.dto.WorkerFunctionDTO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@FxmlView("Workers.fxml")
public class WorkerController {
    @FXML
    private Button add;
    @FXML private Button edit;
    @FXML private Button drop;
    @FXML private TableView<BrigadeDTO> brigadesTable;
    @FXML private TableView<WorkerFunctionDTO> workerFunctionsTable;
    @FXML private TableView<WorkerDTO> workersTable;

    @Autowired
    private WorkerRepository workerRepository;

    @PostMapping(path = "/worker") // Map ONLY POST Requests
    public @ResponseBody String add(@RequestParam String name) {
        return "Saved";
    }
}
