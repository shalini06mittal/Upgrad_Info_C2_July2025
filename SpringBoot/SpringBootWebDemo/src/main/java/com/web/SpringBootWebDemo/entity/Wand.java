package com.web.SpringBootWebDemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "wand")
@Data
@AllArgsConstructor 
@NoArgsConstructor
public class Wand {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String wood;
    private String core;
    private String length;
    
    @JsonIgnoreProperties("wand")
    @OneToOne(mappedBy = "wand")
    private FictionalCharacter fictionalCharacter;


    /**
     * 
     * api/characters
     * fc.getWand().getCharacter().getWand().getChar
     * 
     * 
     */
}
