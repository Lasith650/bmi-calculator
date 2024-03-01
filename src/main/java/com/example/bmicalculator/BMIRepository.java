package com.example.bmicalculator;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BMIRepository extends JpaRepository<BMIRecord, Long>
{
}
