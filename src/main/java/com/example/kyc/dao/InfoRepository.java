package com.example.kyc.dao;
import com.example.kyc.entity.ParentForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface InfoRepository extends JpaRepository<ParentForm,Long> {

}

