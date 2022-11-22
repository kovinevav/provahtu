package ru.kovynev.provahtu.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kovynev.provahtu.entities.Resume;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {

}
