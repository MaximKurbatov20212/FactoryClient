package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dao.repo.ProductAccountingRepository;
import com.example.accessingdatamysql.dto.*;
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
@FxmlView("ProductAccounting.fxml")
public class ProductAccountingController {
    @FXML
    private Button add;
    @FXML private Button edit;
    @FXML private Button drop;
    @FXML private TextField date;
    @FXML private TableView<ProductAccountingDTO> productAccountingTable;
    @FXML private TableView<ProductDTO> productsTable;
    @FXML private TableView<EventWithProductDTO> eventsWithProductTable;
    @Autowired
    private ProductAccountingRepository productAccountingRepository;

    @PostMapping(path = "/productAccounting") // Map ONLY POST Requests
    public @ResponseBody String add(@RequestParam String name) {
        return "Saved";
    }
}
