package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dao.entities.PersonalAccounting;
import com.example.accessingdatamysql.dao.repo.PersonalAccountingRepository;
import com.example.accessingdatamysql.dto.EquipmentDTO;
import com.example.accessingdatamysql.dto.EventWithPeopleDTO;
import com.example.accessingdatamysql.dto.PersonalAccountingDTO;
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
@FxmlView("PersonalAccounting.fxml")
public class PersonalAccountingController {
    @FXML
    private Button add;
    @FXML private Button edit;
    @FXML private Button drop;
    @FXML private TextField date;
    @FXML private TableView<PersonalAccountingDTO> personalAccountingTable;
    @FXML private TableView<PersonalDTO> personalTable;
    @FXML private TableView<EventWithPeopleDTO> eventWithPeopleTable;

    @Autowired
    private PersonalAccountingRepository personalAccountingRepository;

    @PostMapping(path="/personalAccounting")
    public @ResponseBody String add (@RequestParam String name) {
        return "Saved";
    }
}
