package com.example.accessingdatamysql.mapper;

import com.example.accessingdatamysql.dao.entities.Site;
import com.example.accessingdatamysql.dto.SiteDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.WARN)
public interface SiteMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "director", source = "director")
    @Mapping(target = "workshop", source = "workshop")
    @Mapping(target = "brigades", source = "brigades")
    @Mapping(target = "productionCycles", source = "productionCycles")
    Site toEntity(SiteDTO siteDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "director", source = "director")
    @Mapping(target = "workshop", source = "workshop")
    @Mapping(target = "brigades", source = "brigades")
    @Mapping(target = "productionCycles", source = "productionCycles")
    SiteDTO toDTO(Site site);
}
