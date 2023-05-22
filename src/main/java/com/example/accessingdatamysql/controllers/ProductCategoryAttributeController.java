package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dao.repo.ProductCategoryAttributeRepository;
import com.example.accessingdatamysql.dto.ProductCategoryAttributeDTO;
import com.example.accessingdatamysql.dto.ProductCategoryDTO;
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
@FxmlView("ProductCategoryAttributes.fxml")
public class ProductCategoryAttributeController {
    @FXML
    private Button add;
    @FXML private Button edit;
    @FXML private Button drop;
    @FXML private TextField attrName;
    @FXML private TableView<ProductCategoryDTO> productCategoryTable;
    @FXML private TableView<ProductCategoryAttributeDTO> productCategoryAttributeTable;

    @Autowired
    private ProductCategoryAttributeRepository productCategoryAttributeRepository;

    @PostMapping(path = "/productCategoryAttribute") // Map ONLY POST Requests
    public @ResponseBody String add(@RequestParam String name) {
        return "Saved";
    }
}
