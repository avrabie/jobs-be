package xyz.optimized.jobs.mappers;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import xyz.optimized.jobs.apifirst.model.Job;
import xyz.optimized.jobs.apifirst.model.JobCompany;
import xyz.optimized.jobs.data.JobEntity;

import static org.junit.jupiter.api.Assertions.*;

class JobEntityToJobMapperTest {
    private final JobEntityToJobMapper mapper = JobEntityToJobMapper.INSTANCE;

    /**
     * Tests JobEntityToJobMapper's toJobEntity method for correct job to jobEntity conversion
     */
    @Test
    void toJobEntity() {
        //Setup
        Job job = new Job();
        job.setId("test-id");
        job.setTitle("test-title");
        job.setType("test-type");
        job.setDescription("test-description");
        job.setLocation("test-location");
        job.setSalary("test-salary");
        JobCompany company = new JobCompany();
        company.setName("test-company-name");
        company.setDescription("test-description");
        company.setContactEmail("test-email");
        company.setContactPhone("test-phone");
        job.setCompany(company);
        //Execution
        JobEntity result = mapper.toJobEntity(job);
        //Assertions
        assertNotNull(result, "Expected non-null job entity");
        assertEquals(job.getId(), result.getId(), "Expected matching ID");
        assertEquals(job.getTitle(), result.getTitle(), "Expected matching title");
        assertEquals(job.getType(), result.getType(), "Expected matching type");
        assertEquals(job.getDescription(), result.getDescription(), "Expected matching description");
        assertEquals(job.getLocation(), result.getLocation(), "Expected matching location");
        assertEquals(job.getSalary(), result.getSalary(), "Expected matching salary");
        assertNotNull(job.getCompany(), "Expected non-null company");
        assertEquals(job.getCompany().getName(), result.getName(), "Expected matching company name");
        assertEquals(job.getCompany().getDescription(), result.getCompanyDescription(), "Expected matching company description");
        assertEquals(job.getCompany().getContactEmail(), result.getContactEmail(), "Expected matching company contact email");
        assertEquals(job.getCompany().getContactPhone(), result.getContactPhone(), "Expected matching company contact phone");
    }
}