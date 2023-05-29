package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dto.EventWithPeopleDTO;
import com.example.accessingdatamysql.dto.WorkerAccountingDTO;
import com.example.accessingdatamysql.dto.WorkerDTO;
import com.example.accessingdatamysql.exception.ItemException;
import com.example.accessingdatamysql.service.WorkerAccountingService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;
import java.time.ZoneId;
import java.sql.Date;

@Component
@FxmlView("WorkerAccounting.fxml")
public class WorkerAccountingController {
    @FXML
    private Button add;
    @FXML private Button edit;
    @FXML private Button drop;

    @FXML private DatePicker date;
    @FXML private TableView<WorkerAccountingDTO> workerAccountingTable;
    @FXML private TableView<WorkerDTO> workersTable;
    @FXML private TableView<EventWithPeopleDTO> eventWithPeopleTable;

    private final WorkerAccountingService workerAccountingService;

    public WorkerAccountingController(WorkerAccountingService service) {
        this.workerAccountingService = service;
    }

    private void clickButton() {
        add.setOnAction(event -> addEvent());
        edit.setOnAction(event -> editEvent());
        drop.setOnAction(event -> dropEvent());
    }

    private void dropEvent() {
        WorkerAccountingDTO item = workerAccountingTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        workerAccountingService.drop(item);
        workerAccountingTable.setItems(FXCollections.observableList(workerAccountingService.getAll()));
    }

    private void editEvent() {
        WorkerAccountingDTO item = workerAccountingTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        WorkerDTO personalItem = workersTable.getSelectionModel().getSelectedItem();
        if (personalItem == null) {
            throw new ItemException("select record");
        }

        EventWithPeopleDTO eventItem = eventWithPeopleTable.getSelectionModel().getSelectedItem();
        if (eventItem == null) {
            throw new ItemException("select record");
        }

        workerAccountingService.edit(WorkerAccountingDTO.builder()
                .id(personalItem.getId())
                .person(personalItem)
                .event(eventItem)
                .data(Date.from(date.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()))
                .build()
        );

        workerAccountingTable.setItems(FXCollections.observableList(workerAccountingService.getAll()));
    }

    private void addEvent() {
        try {
            WorkerAccountingDTO item = workerAccountingTable.getSelectionModel().getSelectedItem();
            if (item == null) {
                throw new ItemException("select record");
            }

            WorkerDTO personalItem = workersTable.getSelectionModel().getSelectedItem();
            if (personalItem == null) {
                throw new ItemException("select record");
            }

            EventWithPeopleDTO eventItem = eventWithPeopleTable.getSelectionModel().getSelectedItem();
            if (eventItem == null) {
                throw new ItemException("select record");
            }

            workerAccountingService.edit(WorkerAccountingDTO.builder()
                    .person(personalItem)
                    .event(eventItem)
                    .data(Date.from(date.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()))
                    .build()
            );

            workerAccountingTable.setItems(FXCollections.observableList(workerAccountingService.getAll()));
        } catch (Exception e) {
            System.err.println("factory add error");
        }
    }
}
