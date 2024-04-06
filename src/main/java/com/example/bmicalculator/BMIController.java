package com.example.bmicalculator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/bmi")
public class BMIController
{
  private final BMIRepository bmiRepository;

  @Autowired
  public BMIController(BMIRepository bmiRepository) {
    this.bmiRepository = bmiRepository;
  }

  @PostMapping("/calculate")
  public BMIRecord calculateBMI(@RequestBody BMIRecord bmiRecord) {
    bmiRecord.setBmi(bmiRecord.getWeight() / Math.pow(bmiRecord.getHeight(), 2));
    return bmiRepository.save(bmiRecord);
  }

  @GetMapping("/history")
  public List<BMIRecord> getBMIHistory() {
    return bmiRepository.findAll();
  }
}
