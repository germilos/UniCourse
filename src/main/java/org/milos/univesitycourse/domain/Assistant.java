/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import org.milos.univesitycourse.enumeration.DiplomaType;

/**
 *
 * @author Milos
 */
@Entity
@DiscriminatorValue(value = "A")
public class Assistant extends Lecturer {
    
    private static final long serialVersionUID = 1L;
    
    @Column(name = "diploma")
    @Enumerated(EnumType.STRING)
    private DiplomaType diplomaType;

    public Assistant() {
        super(null, null, null);
    }

    public Assistant(String nameSurname, String fieldOfExpertise, Department deptIdFk, DiplomaType diplomaType) {
        super(nameSurname, fieldOfExpertise, deptIdFk);
        this.diplomaType = diplomaType;
    }
    
    public DiplomaType getDiplomaType() {
        return diplomaType;
    }

    public void setDiplomaType(DiplomaType diplomaType) {
        this.diplomaType = diplomaType;
    }

    @Override
    public String toString() {
        return "Assistant{" + "diplomaType=" + diplomaType + '}';
    }
    
    
    
}
