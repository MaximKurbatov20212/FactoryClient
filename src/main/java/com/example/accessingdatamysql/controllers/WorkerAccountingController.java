package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dao.repo.WorkerAccountingRepository;
import com.example.accessingdatamysql.dto.EventWithPeopleDTO;
import com.example.accessingdatamysql.dto.WorkerAccountingDTO;
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
@FxmlView("WorkerAccounting.fxml")
public class WorkerAccountingController {
    @FXML
    private Button add;
    @FXML private Button edit;
    @FXML private Button drop;

    @FXML private TextField date;
    @FXML private TableView<WorkerAccountingDTO> workerAccountingTable;
    @FXML private TableView<WorkerDTO> workersTable;
    @FXML private TableView<EventWithPeopleDTO> eventWithPeopleTable;

    @Autowired
    private WorkerAccountingRepository workerAccountingRepository;

    @PostMapping(path = "/workerAccounting") // Map ONLY POST Requests
    public @ResponseBody String add(@RequestParam String name) {
        return "Saved";
    }
}
