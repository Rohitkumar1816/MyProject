package com.College.CollegeP01.Controller;

import com.College.CollegeP01.Entity.College;
import com.College.CollegeP01.Repo.CollegeRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/College")
public class CollegeController {
    private  final CollegeRepo collegeRepo;

    public CollegeController(CollegeRepo collegeRepo) {
        this.collegeRepo = collegeRepo;

    }
    @PostMapping
    public College CreatCollege(@RequestBody College college){
        return  collegeRepo.save(college);

    }
    @GetMapping
    public List<College> GetAllCollege(){
        return  collegeRepo.findAll();
    }
}
