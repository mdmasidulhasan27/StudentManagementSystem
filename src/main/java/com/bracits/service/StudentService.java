package com.bracits.service;

import java.util.List;
import java.util.Optional;

import com.bracits.domain.Student;
import com.bracits.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repo;

    public List<Student> getStudents() {
        return repo.findAll();
    }

    public Student getStudent(long id) {
        return repo.findById(id).get();
    }

    public void setStudent(Student std) {
        repo.save(std);
    }

    public void updateStudent(Student std) {
        //repo.deleteById(std.getId());
        Optional<Student> student = repo.findById(std.getId());
        student.get().setBirthdate(std.getBirthdate());
        student.get().setGender(std.getGender());
        student.get().setName(std.getName());
        student.get().setNote(std.getNote());
        repo.save(student.get());
    }

    public void deleteStudent(long id) {
        repo.deleteById(id);
    }

}