package accessingdatamysql.controllers;

import com.example.accessingdatamysql.dao.repo.PersonalAccountingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/demo")
public class PersonalAccountingController {
    @Autowired
    private PersonalAccountingRepository personalAccountingRepository;

    @PostMapping(path="/personalAccounting")
    public @ResponseBody String add (@RequestParam String name) {
        return "Saved";
    }
}
