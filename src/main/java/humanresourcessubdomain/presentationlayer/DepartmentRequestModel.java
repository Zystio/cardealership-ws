package humanresourcessubdomain.presentationlayer;

import humanresourcessubdomain.datalayer.department.Position;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentRequestModel {

    private String name;
    private Integer headCount;
    private List<Position> positions;
}