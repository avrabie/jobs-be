package xyz.optimized.jobs.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;


@Table("jobs")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class JobEntity {
    @Id
    private String id;

    private String title;

    private String type;

    private String description;

    private String location;

    private String salary;

    @Column("company.name")
    private String name;

    @Column("company.description")
    private String companyDescription;

    @Column("company.contactEmail")
    private String contactEmail;
    @Column("company.contactPhone")
    private String contactPhone;
}
