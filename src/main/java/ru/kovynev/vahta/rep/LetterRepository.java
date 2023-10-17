package ru.kovynev.vahta.rep;

import org.springframework.data.repository.CrudRepository;
import ru.kovynev.vahta.entity.Letter;

public interface LetterRepository extends CrudRepository<Letter, Long> {

}
