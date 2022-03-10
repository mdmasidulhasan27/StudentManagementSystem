package com.bracits.controller;

import com.bracits.domain.Student;
import com.bracits.service.StudentService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.swing.text.html.HTML;
import java.util.*;

@Controller
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Student> studentList = service.getStudents();
        model.addAttribute("students", studentList);
        return "home.html";
    }

    @GetMapping("/new")
    public String addNewStudentPage(Model model) {
        model.addAttribute("student", new Student());
        return "new.html";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") Student std, Model model) {
        service.setStudent(std);
        return "redirect:/";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateStudent(@ModelAttribute("student") Student std) {
        service.updateStudent(std);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public String showEditStudentPage(@PathVariable(name = "id") Long id, Model model) {
        Student std = service.getStudent(id);
        model.addAttribute("student", std);
        return "update.html";
    }

    @RequestMapping("/delete/{id}")
    public String deletestudent(@PathVariable(name = "id") Long id) {
        service.deleteStudent(id);
        return "redirect:/";
    }

     /*@RequestMapping("/edit/{id}")
    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("update.html");
        Student std = service.getAStudent(id);
        mav.addObject("students", std);
        return mav;
    }*/

    /*@GetMapping("/test")
    public List<Student> testing(Model model) {
        //List<Student> studentList = service.listAll();
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1L,"Masidul", "31 dec", 1, "Good"));
        studentList.add(new Student(2L,"Masidul", "31 dec", 1, "Good"));
        //model.addAttribute("studentList", studentList);
        return studentList;
    }*/

    /*@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") Student std, Model model) {
        List<Student> studentList = new LinkedList<>();
        studentList.add(std);
        model.addAttribute("students", studentList);
        //service.save(std);
        //System.out.println(std.getName());
        return "home.html";
    }*/

    /*@GetMapping("/")
    public ModelAndView viewHomePage(Model model) {
        List<Student> studentList = service.listAll();
        //List<Student> studentList = new LinkedList<>();
        studentList.add(new Student(1L,"Masidul", "31 dec", 1, "Good"));
        studentList.add(new Student(2L,"Masidul", "31 dec", 1, "Good"));
        model.addAttribute("studentList", studentList);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject(model);
        modelAndView.setViewName("home.html");
        return modelAndView;
    }*/
}
