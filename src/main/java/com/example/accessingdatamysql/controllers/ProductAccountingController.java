package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dto.*;
import com.example.accessingdatamysql.exception.ItemException;
import com.example.accessingdatamysql.service.ProductAccountingService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.util.Date;

@Component
@FxmlView("ProductAccounting.fxml")
public class ProductAccountingController {
    @FXML
    private Button add;
    @FXML private Button edit;
    @FXML private Button drop;
    @FXML private DatePicker date;
    @FXML private TableView<ProductAccountingDTO> productAccountingTable;
    @FXML private TableView<ProductDTO> productsTable;
    @FXML private TableView<EventWithProductDTO> eventsWithProductTable;
    private final ProductAccountingService productAccountingService;

    public ProductAccountingController(ProductAccountingService service) {
        this.productAccountingService = service;
    }

    private void clickButton() {
        add.setOnAction(event -> addEvent());
        edit.setOnAction(event -> editEvent());
        drop.setOnAction(event -> dropEvent());
    }

    private void dropEvent() {
        ProductAccountingDTO item = productAccountingTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        productAccountingService.drop(item);
        productAccountingTable.setItems(FXCollections.observableList(productAccountingService.getAll()));
    }

    private void editEvent() {
        ProductAccountingDTO item = productAccountingTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            throw new ItemException("select record");
        }

        ProductDTO productItem = productsTable.getSelectionModel().getSelectedItem();
        if (productItem == null) {
            throw new ItemException("select record");
        }

        EventWithProductDTO eventItem = eventsWithProductTable.getSelectionModel().getSelectedItem();
        if (eventItem == null) {
            throw new ItemException("select record");
        }

        productAccountingService.edit(ProductAccountingDTO.builder()
                .id(productItem.getId())
                        .person(productItem)
                .event(eventItem)
                .data(Date.from(date.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()))
                .build()
        );

        productAccountingTable.setItems(FXCollections.observableList(productAccountingService.getAll()));
    }

    private void addEvent() {
        try {
            ProductAccountingDTO item = productAccountingTable.getSelectionModel().getSelectedItem();
            if (item == null) {
                throw new ItemException("select record");
            }

            ProductDTO productItem = productsTable.getSelectionModel().getSelectedItem();
            if (productItem == null) {
                throw new ItemException("select record");
            }

            EventWithProductDTO eventItem = eventsWithProductTable.getSelectionModel().getSelectedItem();
            if (eventItem == null) {
                throw new ItemException("select record");
            }

            productAccountingService.edit(ProductAccountingDTO.builder()
                    .person(productItem)
                    .event(eventItem)
                    .data(Date.from(date.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()))
                    .build()
            );

            productAccountingTable.setItems(FXCollections.observableList(productAccountingService.getAll()));
        } catch (Exception e) {
            System.err.println("factory add error");
        }
    }
}
