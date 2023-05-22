package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.dao.repo.BrigadeRepository;
import com.example.accessingdatamysql.dto.BrigadeDTO;
import com.example.accessingdatamysql.dto.SiteDTO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
//@RequestMapping(path="/demo")
//
@Component
@FxmlView("Brigades.fxml")
public class BrigadeController {
    @FXML
    private Button add;
    @FXML private Button edit;
    @FXML private Button drop;
    @FXML private TableView<BrigadeDTO> brigadesTable;
    @FXML private TableView<SiteDTO> sitesTable;
    @Autowired
    private BrigadeRepository brigadeRepository;

    @PostMapping(path="/brigade")
    public @ResponseBody String add (@RequestParam String name) {
        return "Saved";
    }
}
