package accessingdatamysql.controllers;

import com.example.accessingdatamysql.dao.repo.WorkerCategoryAttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class WorkerCategoryAttributeController {
    @Autowired
    private WorkerCategoryAttributeRepository workerCategoryAttributeRepository;

    @PostMapping(path = "/workerCategory") // Map ONLY POST Requests
    public @ResponseBody String add(@RequestParam String name) {
        return "Saved";
    }
}
