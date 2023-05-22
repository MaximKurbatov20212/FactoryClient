package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dao.entities.Factory;
import com.example.accessingdatamysql.dao.entities.Workshop;
import com.example.accessingdatamysql.dao.repo.WorkshopRepository;
import com.example.accessingdatamysql.dto.FactoryDTO;
import com.example.accessingdatamysql.dto.PersonalDTO;
import com.example.accessingdatamysql.dto.WorkerFunctionDTO;
import com.example.accessingdatamysql.dto.WorkshopDTO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FxmlView("Workshops.fxml")
public class WorkshopController {
    @FXML
    private Button add;
    @FXML private Button edit;
    @FXML private Button drop;
    @FXML private TableView<WorkshopDTO> workshopsTable;
    @FXML private TableView<FactoryDTO> factoriesTable;
    @FXML private TableView<PersonalDTO> personalTable;

    @Autowired
    private WorkshopRepository workshopRepository;

    @PostMapping(path="/workshop") // Map ONLY POST Requests
    public @ResponseBody String addNewWorkshop (@RequestParam Integer factoryID) {
        Factory factory = new Factory();
        Workshop w1 = new Workshop(factory);
        Workshop w2 = new Workshop(factory);
        Workshop w3 = new Workshop(factory);
        workshopRepository.save(w1);
        workshopRepository.save(w2);
        workshopRepository.save(w3);
        return "Saved";
    }
}