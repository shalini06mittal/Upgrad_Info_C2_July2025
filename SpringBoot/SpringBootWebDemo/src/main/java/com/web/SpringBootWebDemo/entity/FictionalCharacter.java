package com.web.SpringBootWebDemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "fictional_character")
@Data
@AllArgsConstructor 
@NoArgsConstructor
public class FictionalCharacter {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(length = 150, unique = true)
  private String name;
  @Column(length = 150, nullable = false)
  private String house;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name="wandid")// tablename_primarykey
  @JsonIgnoreProperties("fictionalCharacter")
  private Wand wand;
  
  @Column(length = 150, nullable = false)
  private String bio;
  
  private String imageurl;

}
