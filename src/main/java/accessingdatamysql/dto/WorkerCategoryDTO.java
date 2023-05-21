package accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.Worker;
import com.example.accessingdatamysql.dao.entities.WorkerCategoryAttribute;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class WorkerCategoryDTO {

    @NotNull
    private Integer id;
    @NotNull
    private String name;
    @NotNull

    List<Worker> products = new ArrayList<>();
    @NotNull

    List<WorkerCategoryAttribute> productCategoryAttributes = new ArrayList<>();
}
