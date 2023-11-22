package ru.kovynev.vahta.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kovynev.vahta.entity.Company;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findById(Company company);




}
