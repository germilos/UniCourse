/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.domain;

import java.util.jar.Attributes;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import org.milos.univesitycourse.enumeration.ProfessorType;

/**
 *
 * @author Milos
 */
@Entity
@DiscriminatorValue(value = "P")
public class Professor extends Lecturer {
    
    private static final long serialVersionUID = 1L;
    
    @Column(name = "position")
    @Enumerated(EnumType.STRING)
    private ProfessorType position;
    @Column(name = "numOfResearch")
    private int numOfResearch;

    public ProfessorType getPosition() {
        return position;
    }

    public void setPosition(ProfessorType position) {
        this.position = position;
    }

    public int getNumOfResearch() {
        return numOfResearch;
    }

    public void setNumOfResearch(int numOfResearch) {
        this.numOfResearch = numOfResearch;
    }
    
    
    
}
