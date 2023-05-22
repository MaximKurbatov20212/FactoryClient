package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dao.repo.ExpertRepository;
import com.example.accessingdatamysql.dto.ExpertDTO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@FxmlView("Experts.fxml")
public class ExpertController {
    @FXML
    private Button add;
    @FXML private Button edit;
    @FXML private Button drop;
    @FXML private TextField name;
    @FXML private TableView<ExpertDTO> expertsTable;
    @Autowired
    private ExpertRepository expertRepository;

    @PostMapping(path="/expert")
    public @ResponseBody String add (@RequestParam String name) {
        return "Saved";
    }
}
