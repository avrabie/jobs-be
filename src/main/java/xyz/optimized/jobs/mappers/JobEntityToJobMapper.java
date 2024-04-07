package xyz.optimized.jobs.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import xyz.optimized.jobs.apifirst.model.Job;
import xyz.optimized.jobs.apifirst.model.JobCompany;
import xyz.optimized.jobs.data.JobEntity;

@Mapper(componentModel = "spring")
public interface JobEntityToJobMapper {
    JobEntityToJobMapper INSTANCE = Mappers.getMapper(JobEntityToJobMapper.class);


    @Mapping(target = "company", source="jobEntity", qualifiedByName = "toJobCompany")
    Job toJob(JobEntity jobEntity);

    @Mapping(target = "companyDescription", source = "company.description")
    @Mapping(target = "name", source = "company.name")
    @Mapping(target = "contactEmail", source = "company.contactEmail")
    @Mapping(target = "contactPhone", source = "company.contactPhone")
    JobEntity toJobEntity(Job job);

    @Mapping( target = "description", source = "companyDescription")
    @Named("toJobCompany")
    JobCompany toJobCompany(JobEntity jobEntity);
}
