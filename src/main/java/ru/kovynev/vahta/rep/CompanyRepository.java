package ru.kovynev.vahta.rep;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kovynev.vahta.entity.Company;
@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {
    Company findById(Company company);
}
