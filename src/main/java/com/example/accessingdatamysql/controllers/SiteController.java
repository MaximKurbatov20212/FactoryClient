package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dao.repo.SiteRepository;
import com.example.accessingdatamysql.dto.EquipmentDTO;
import com.example.accessingdatamysql.dto.PersonalDTO;
import com.example.accessingdatamysql.dto.SiteDTO;
import com.example.accessingdatamysql.dto.WorkshopDTO;
import com.example.accessingdatamysql.exception.ItemException;
import com.example.accessingdatamysql.service.SiteService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("Sites.fxml")
public class SiteController {
    @FXML
    private Button add;
    @FXML
    private Button edit;
    @FXML
    private Button drop;
    @FXML
    private TableView<SiteDTO> sitesTable;
    @FXML
    private TableView<PersonalDTO> personalTable;
    @FXML
    private TableView<WorkshopDTO> workshopsTable;

    private final SiteService siteService;

    public SiteController(SiteService service) {
        this.siteService = service;
    }

    private void clickButton() {
        add.setOnAction(event -> addEvent());
        edit.setOnAction(event -> editEvent());
        drop.setOnAction(event -> dropEvent());
    }

    private void dropEvent() {
        SiteDTO item = sitesTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        siteService.drop(item);
        sitesTable.setItems(FXCollections.observableList(siteService.getAll()));
    }

    private void editEvent() {
        SiteDTO item = sitesTable.getSelectionModel().getSelectedItem();

        if (item == null) {
            throw new ItemException("select record");
        }

        PersonalDTO personalItem = personalTable.getSelectionModel().getSelectedItem();

        if (personalItem == null) {
            throw new ItemException("select record");
        }

        WorkshopDTO workshopItem = workshopsTable.getSelectionModel().getSelectedItem();

        if (workshopItem == null) {
            throw new ItemException("select record");
        }

        siteService.edit(SiteDTO.builder()
                .id(item.getId())
                .director(personalItem)
                .workshop(workshopItem)
                .build());

        sitesTable.setItems(FXCollections.observableList(siteService.getAll()));
    }

    private void addEvent() {
        try {
            SiteDTO item = sitesTable.getSelectionModel().getSelectedItem();

            if (item == null) {
                throw new ItemException("select record");
            }

            PersonalDTO personalItem = personalTable.getSelectionModel().getSelectedItem();

            if (personalItem == null) {
                throw new ItemException("select record");
            }

            WorkshopDTO workshopItem = workshopsTable.getSelectionModel().getSelectedItem();

            if (workshopItem == null) {
                throw new ItemException("select record");
            }

            siteService.edit(SiteDTO.builder()
                    .id(item.getId())
                    .director(personalItem)
                    .workshop(workshopItem)
                    .build());

            sitesTable.setItems(FXCollections.observableList(siteService.getAll()));
        } catch (Exception e) {
            System.err.println("site add error");
        }
    }
}
