package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dao.entities.Product;
import com.example.accessingdatamysql.dao.repo.ProductRepository;
import com.example.accessingdatamysql.dto.ProductCategoryDTO;
import com.example.accessingdatamysql.dto.ProductDTO;
import com.example.accessingdatamysql.dto.ProductTypeDTO;
import com.example.accessingdatamysql.dto.WorkshopDTO;
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
@FxmlView("Products.fxml")
public class ProductController {
    @FXML
    private Button add;
    @FXML private Button edit;
    @FXML private Button drop;
    @FXML private TableView<ProductCategoryDTO> productCategoriesTable;
    @FXML private TableView<ProductTypeDTO> productTypesTable;
    @FXML private TableView<WorkshopDTO> workshopsTable;
    @FXML private TableView<ProductDTO> productsTable;
    @Autowired
    private ProductRepository productRepository;

    @PostMapping(path = "/product") // Map ONLY POST Requests
    public @ResponseBody String add(@RequestParam String name) {
        return "Saved";
    }
}
