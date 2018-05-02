/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Milos
 */
@Embeddable
public class CourseUnitPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "course_id")
    private long courseId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unit_number")
    private int unitNumber;

    public CourseUnitPK() {
    }

    public CourseUnitPK(long courseId, int unitNumber) {
        this.courseId = courseId;
        this.unitNumber = unitNumber;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public int getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(int unitNumber) {
        this.unitNumber = unitNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) courseId;
        hash += (int) unitNumber;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourseUnitPK)) {
            return false;
        }
        CourseUnitPK other = (CourseUnitPK) object;
        if (this.courseId != other.courseId) {
            return false;
        }
        if (this.unitNumber != other.unitNumber) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return courseId + " " + unitNumber;
    }
    
}
