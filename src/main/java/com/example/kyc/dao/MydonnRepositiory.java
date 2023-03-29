package com.example.kyc.dao;

import com.example.kyc.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MydonnRepositiory extends JpaRepository<Question,Long> {
}
