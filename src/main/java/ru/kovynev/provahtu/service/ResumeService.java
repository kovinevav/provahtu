package ru.kovynev.provahtu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kovynev.provahtu.entities.Resume;
import ru.kovynev.provahtu.rep.ResumeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResumeService {
    @Autowired
    ResumeRepository resumeRepository;

    public void addResume(Resume resume) {
        resumeRepository.save(resume);
    }

    public List<Resume> findAll() {
        return resumeRepository.findAll();
    }
}

