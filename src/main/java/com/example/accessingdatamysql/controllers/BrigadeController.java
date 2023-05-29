package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dao.repo.BrigadeRepository;
import com.example.accessingdatamysql.dto.BrigadeDTO;
import com.example.accessingdatamysql.dto.BrigadeDTO;
import com.example.accessingdatamysql.dto.SiteDTO;
import com.example.accessingdatamysql.exception.ItemException;
import com.example.accessingdatamysql.service.BrigadeService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@FxmlView("Brigades.fxml")
public class BrigadeController {
    @FXML
    private Button add;
    @FXML
    private Button edit;
    @FXML
    private Button drop;
    @FXML
    private TableView<BrigadeDTO> brigadesTable;
    @FXML
    private TableView<SiteDTO> sitesTable;
    private final BrigadeService brigadeService;

    public BrigadeController(BrigadeService service) {
        this.brigadeService = service;
    }

    private void clickButton() {
        add.setOnAction(event -> addEvent());
        edit.setOnAction(event -> editEvent());
        drop.setOnAction(event -> dropEvent());
    }

    private void dropEvent() {
        BrigadeDTO item = brigadesTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        brigadeService.drop(item);
        brigadesTable.setItems(FXCollections.observableList(brigadeService.getAll()));
    }

    private void editEvent() {
        BrigadeDTO item = brigadesTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }
        SiteDTO siteItem = sitesTable.getSelectionModel().getSelectedItem();
        if (siteItem == null) {
            throw new ItemException("select record");
        }

        brigadeService.edit(BrigadeDTO.builder().id(item.getId()).site(siteItem).build());
        brigadesTable.setItems(FXCollections.observableList(brigadeService.getAll()));
    }

    private void addEvent() {
        try {
            BrigadeDTO item = brigadesTable.getSelectionModel().getSelectedItem();
            if (item == null) {
                throw new ItemException("select record");
            }
            SiteDTO siteItem = sitesTable.getSelectionModel().getSelectedItem();
            if (siteItem == null) {
                throw new ItemException("select record");
            }
            brigadeService.edit(BrigadeDTO.builder().site(siteItem).build());
            brigadesTable.setItems(FXCollections.observableList(brigadeService.getAll()));
        } catch (Exception e) {
            System.err.println("brigade add error");
        }

    }
}
