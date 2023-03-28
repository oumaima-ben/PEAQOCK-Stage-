package com.example.json.dao;

import com.example.json.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MydonnRepositiory extends JpaRepository<Question,Long> {
}
