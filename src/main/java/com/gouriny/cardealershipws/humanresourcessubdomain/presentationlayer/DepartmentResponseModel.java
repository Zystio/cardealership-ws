package com.gouriny.cardealershipws.humanresourcessubdomain.presentationlayer;

import com.gouriny.cardealershipws.humanresourcessubdomain.datalayer.department.Position;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentResponseModel {
    public String departmentId;
    public String name;
    public Integer headCount;
    public List<Position> positions;
}
