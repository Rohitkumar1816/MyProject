package com.College.CollegeP01.Repo;

import com.College.CollegeP01.Entity.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeRepo extends JpaRepository <College ,Long> {

}
