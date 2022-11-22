package ru.kovynev.provahtu.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kovynev.provahtu.entities.Vacancy;

import java.util.List;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Long> {

    List<Vacancy> findAllByName(String name);
    List<Vacancy> findAll();
}
