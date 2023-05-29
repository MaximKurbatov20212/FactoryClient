package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dao.repo.ProductionCycleRepository;
import com.example.accessingdatamysql.dto.*;
import com.example.accessingdatamysql.exception.ItemException;
import com.example.accessingdatamysql.service.PersonalCategoryAttributeService;
import com.example.accessingdatamysql.service.ProductionCycleService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
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

import java.sql.Date;
import java.time.ZoneId;

@Component
@FxmlView("ProductionCycles.fxml")
public class ProductionCycleController {
    @FXML
    private Button add;
    @FXML private Button edit;
    @FXML private Button drop;
    @FXML private DatePicker date;
    @FXML private TableView<ProductDTO> productsTable;
    @FXML private TableView<BrigadeDTO> brigadesTable;
    @FXML private TableView<SiteDTO> sitesTable;
    @FXML private TableView<ProductionCycleDTO> productionCyclesTable;

    private final ProductionCycleService productionCycleService;

    public ProductionCycleController(ProductionCycleService service) {
        this.productionCycleService = service;
    }

    private void clickButton() {
        add.setOnAction(event -> addEvent());
        edit.setOnAction(event -> editEvent());
        drop.setOnAction(event -> dropEvent());
    }

    private void dropEvent() {
        ProductionCycleDTO item = productionCyclesTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        productionCycleService.drop(item);
        productionCyclesTable.setItems(FXCollections.observableList(productionCycleService.getAll()));
    }

    private void editEvent() {

        ProductionCycleDTO item = productionCyclesTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        ProductDTO productDTO = productsTable.getSelectionModel().getSelectedItem();
        if (productDTO == null) {
            throw new ItemException("select record");
        }

        BrigadeDTO brigadeDTO = brigadesTable.getSelectionModel().getSelectedItem();
        if (brigadeDTO == null) {
            throw new ItemException("select record");
        }

        SiteDTO siteDTO = sitesTable.getSelectionModel().getSelectedItem();
        if (siteDTO == null) {
            throw new ItemException("select record");
        }

        productionCycleService.edit(ProductionCycleDTO.builder()
                .id(item.getId())
                .product(productDTO)
                .site(siteDTO)
                .build()
        );

        productionCyclesTable.setItems(FXCollections.observableList(productionCycleService.getAll()));
    }

    private void addEvent() {
        try {
            ProductionCycleDTO item = productionCyclesTable.getSelectionModel().getSelectedItem();
            if (item == null) {
                throw new ItemException("select record");
            }

            ProductDTO productDTO = productsTable.getSelectionModel().getSelectedItem();
            if (productDTO == null) {
                throw new ItemException("select record");
            }

            BrigadeDTO brigadeDTO = brigadesTable.getSelectionModel().getSelectedItem();
            if (brigadeDTO == null) {
                throw new ItemException("select record");
            }

            SiteDTO siteDTO = sitesTable.getSelectionModel().getSelectedItem();
            if (siteDTO == null) {
                throw new ItemException("select record");
            }

            productionCycleService.add(ProductionCycleDTO.builder()
                    .product(productDTO)
                    .site(siteDTO)
                    .build()
            );

            productionCyclesTable.setItems(FXCollections.observableList(productionCycleService.getAll()));
        } catch (Exception e) {
            System.err.println("factory add error");
        }
    }

}
