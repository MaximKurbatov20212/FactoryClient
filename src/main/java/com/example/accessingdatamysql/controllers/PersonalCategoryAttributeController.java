package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dao.entities.Personal;
import com.example.accessingdatamysql.dao.entities.PersonalCategory;
import com.example.accessingdatamysql.dao.entities.PersonalCategoryAttribute;
import com.example.accessingdatamysql.dao.repo.PersonalCategoryAttributeRepository;
import com.example.accessingdatamysql.dto.EquipmentDTO;
import com.example.accessingdatamysql.dto.PersonalCategoryAttributeDTO;
import com.example.accessingdatamysql.dto.PersonalCategoryDTO;
import com.example.accessingdatamysql.dto.PersonalDTO;
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
@FxmlView("PersonalCategoryAttributes.fxml")

public class PersonalCategoryAttributeController {
    @FXML
    private Button add;
    @FXML private Button edit;
    @FXML private Button drop;
    @FXML private TextField attrName;
    @FXML private TableView<PersonalCategoryDTO> personalCategoryTable;
    @FXML private TableView<PersonalCategoryAttributeDTO> personalCategoryAttributeTable;

    @Autowired
    private PersonalCategoryAttributeRepository personalCategoryAttributeRepository;

    @PostMapping(path = "/personalCategoryAttribute") // Map ONLY POST Requests
    public @ResponseBody String add(@RequestParam String name) {
        return "Saved";
    }
}
