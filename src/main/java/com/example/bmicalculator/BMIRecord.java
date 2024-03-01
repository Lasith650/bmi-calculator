package com.example.bmicalculator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BMIRecord
{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private double height;
  private double weight;
  private double bmi;

  public String getName()
  {
    return name;
  }

  public double getHeight()
  {
    return height;
  }

  public double getWeight()
  {
    return weight;
  }

  public double getBmi()
  {
    return bmi;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setHeight(double height)
  {
    this.height = height;
  }

  public void setWeight(double weight)
  {
    this.weight = weight;
  }

  public void setBmi(double bmi)
  {
    this.bmi = bmi;
  }

  public Long getId()
  {
    return id;
  }
}
