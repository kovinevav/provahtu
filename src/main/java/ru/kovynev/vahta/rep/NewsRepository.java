package ru.kovynev.vahta.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kovynev.vahta.entity.News;
@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
}
