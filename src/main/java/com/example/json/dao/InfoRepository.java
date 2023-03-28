package com.example.json.dao;
import com.example.json.entity.ParentForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface InfoRepository extends JpaRepository<ParentForm,Long> {

}

