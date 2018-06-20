package org.ictlab.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "CLASS")
public class Group {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "class_seq")
    @SequenceGenerator(name = "class_seq", sequenceName = "class_seq", allocationSize = 1)
    private Long id;

    @Column(name = "CLASSNAME", unique = true)
    @NotNull
    private String groupName;

    @JsonIgnore
    @JsonIgnoreProperties("groups")
    @ManyToMany(mappedBy = "groups")
    private List<SchoolSchedule> schoolSchedules;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<SchoolSchedule> getSchoolSchedules() {
        return schoolSchedules;
    }

    public void setSchoolSchedules(List<SchoolSchedule> schoolSchedules) {
        this.schoolSchedules = schoolSchedules;
    }
}