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
public class JobEntity {
    @Id
    @Column("ID")
    private Integer id;

    private String title;

    private String type;

    private String description;

    private String location;

    private String salary;

    @Column("COMPANY_NAME")
    private String name;

    @Column("COMPANY_DESCRIPTION")
    private String companyDescription;

    @Column("COMPANY_CONTACT_EMAIL")
    private String contactEmail;
    @Column("COMPANY_CONTACT_PHONE")
    private String contactPhone;
}
