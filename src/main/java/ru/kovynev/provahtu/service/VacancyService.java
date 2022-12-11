package ru.kovynev.provahtu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kovynev.provahtu.entities.Vacancy;
import ru.kovynev.provahtu.rep.VacancyRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VacancyService {
    final VacancyRepository vacancyRepository;

    @Autowired
    public VacancyService(VacancyRepository vacancyRepository) {
        this.vacancyRepository = vacancyRepository;
    }

    public void addVacancy(Vacancy vacancy) {
        vacancyRepository.save(vacancy);
    }

    public List<Vacancy> findAllByName(String name) {
        if (!name.isEmpty()) {
            return vacancyRepository.findAllByName(name);
        }
        return new ArrayList<Vacancy>();
    }

    public List<Vacancy> findAll() {
        return vacancyRepository.findAll();
    }

    public Vacancy findById(Long id) {
        Optional<Vacancy> vacancy = vacancyRepository.findById(id);
        if(!vacancy.isEmpty()) return vacancy.get();
        else return new Vacancy();
    }
}
