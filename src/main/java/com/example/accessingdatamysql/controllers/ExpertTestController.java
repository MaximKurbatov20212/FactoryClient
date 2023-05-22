package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dao.repo.ExpertTestRepository;
import com.example.accessingdatamysql.dto.EquipmentDTO;
import com.example.accessingdatamysql.dto.ExpertDTO;
import com.example.accessingdatamysql.dto.ExpertTestDTO;
import com.example.accessingdatamysql.dto.ProductTestDTO;
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
@FxmlView("ExpertsTests.fxml")
public class ExpertTestController {
    @FXML
    private Button add;
    @FXML private Button edit;
    @FXML private Button drop;
    @FXML private TableView<ProductTestDTO> productTestsTable;
    @FXML private TableView<ExpertDTO> expertsTable;
    @FXML private TableView<ExpertTestDTO> expertTestTable;

    @Autowired
    private ExpertTestRepository expertTestRepository;

    @PostMapping(path="/expertTest")
    public @ResponseBody String add (@RequestParam String name) {
        return "Saved";
    }
}
