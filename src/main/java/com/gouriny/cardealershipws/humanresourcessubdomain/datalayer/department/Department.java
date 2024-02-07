package com.gouriny.cardealershipws.humanresourcessubdomain.datalayer.department;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Entity
@Table(name = "departments")
@Data
@Getter
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private DepartmentIdentifier departmentIdentifier;

    private String name;
    private Integer headCount;


    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "department_positions", joinColumns = @JoinColumn(name = "department_id"))
    private List<Position> positions;

    public Department() {

    }

    public Department(@NotNull String name, @NotNull Integer headCount, @NotNull List<Position> positions) {
        this.departmentIdentifier = new DepartmentIdentifier();
        this.name = name;
        this.headCount = headCount;
        this.positions = positions;
    }
}
