package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dao.entities.PersonalAttributeValue;
import com.example.accessingdatamysql.dao.entities.PersonalCategory;
import com.example.accessingdatamysql.dao.repo.PersonalAttributeValueRepository;
import com.example.accessingdatamysql.dto.EquipmentDTO;
import com.example.accessingdatamysql.dto.PersonalAttributeValueDTO;
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
@FxmlView("PersonalAttributeValue.fxml")
public class PersonalAttributeValueController {
    @FXML
    private Button add;
    @FXML private Button edit;
    @FXML private Button drop;
    @FXML private TextField value;
    @FXML private TableView<PersonalDTO> personalTable;
    @FXML private TableView<PersonalCategoryDTO> personalCategoryTable;
    @FXML private TableView<PersonalAttributeValueDTO> personalAttributeValueTable;

    @Autowired
    private PersonalAttributeValueRepository personalAttributeValueRepository;

    @PostMapping(path = "/personalAttributeValue")
    public @ResponseBody String add(@RequestParam String name) {
        return "Saved";
    }
}
