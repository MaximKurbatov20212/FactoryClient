package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dao.entities.ProductCategory;
import com.example.accessingdatamysql.dao.repo.ProductCategoryRepository;
import com.example.accessingdatamysql.dto.PersonalFunctionDTO;
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
@FxmlView("ProductCategories.fxml")
public class ProductCategoryController {
    @FXML
    private Button add;
    @FXML private Button edit;
    @FXML private Button drop;
    @FXML private TextField name;
    @FXML private TableView<ProductCategoryDTO> productCategoriesTable;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @PostMapping(path = "/productCategory") // Map ONLY POST Requests
    public @ResponseBody String add(@RequestParam String name) {
        return "Saved";
    }
}
