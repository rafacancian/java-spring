package springdata.company.specification;

import org.springframework.data.jpa.domain.Specification;
import springdata.company.entities.Employee;

import java.math.BigDecimal;

public class EmployeeSpecification {

    public static Specification<Employee> name(String name) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }

    public static Specification<Employee> cpf(String cpf) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("cpf"), cpf);
    }

    public static Specification<Employee> salary(BigDecimal salary) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("salary"), salary);
    }

}
