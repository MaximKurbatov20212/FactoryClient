package accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.Site;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class WorkshopDTO {
    @NotNull
    private Integer id;
//    @NotNull
//    private Factory factory;
//    @NotNull
//    private Personal director;
    @NotNull
    List<Site> sites = new ArrayList<>();
}
