package accessingdatamysql.dto;

import com.example.accessingdatamysql.dao.entities.WorkerAttributeValue;
import com.example.accessingdatamysql.dao.entities.WorkerCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class WorkerCategoryAttributeDTO {

    @NotNull
    private Integer id;

    @NotNull
    WorkerCategory category;

    @NotNull
    List<WorkerAttributeValue> workerAttributeValues = new ArrayList<>();
}
