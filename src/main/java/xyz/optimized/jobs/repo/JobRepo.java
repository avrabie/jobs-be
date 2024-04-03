package xyz.optimized.jobs.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import xyz.optimized.jobs.data.JobEntity;

@Repository
public interface JobRepo extends ReactiveCrudRepository<JobEntity, String> {

}
