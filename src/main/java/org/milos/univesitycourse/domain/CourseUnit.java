/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.domain;

import org.milos.univesitycourse.domain.*;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Milos
 */
@Entity
@Table(name = "course_unit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CourseUnit.findAll", query = "SELECT c FROM CourseUnit c")})
public class CourseUnit implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CourseUnitPK courseUnitPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Size(max = 250)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "course_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Course course;

    public CourseUnit() {
    }

    public CourseUnit(int unitNumber, String name) {
        this.courseUnitPK = new CourseUnitPK();
        this.courseUnitPK.setUnitNumber(unitNumber);
        this.name = name;
    }
    
    public CourseUnit(CourseUnitPK courseUnitPK, String name, String description) {
        this.courseUnitPK = courseUnitPK;
        this.name = name;
        this.description = description;
    }

    public CourseUnit(long courseId, int unitNumber) {
        this.courseUnitPK = new CourseUnitPK(courseId, unitNumber);
    }

    public CourseUnitPK getCourseUnitPK() {
        return courseUnitPK;
    }

    public void setCourseUnitPK(CourseUnitPK courseUnitPK) {
        this.courseUnitPK = courseUnitPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseUnitPK != null ? courseUnitPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourseUnit)) {
            return false;
        }
        CourseUnit other = (CourseUnit) object;
        if ((this.courseUnitPK == null && other.courseUnitPK != null) || (this.courseUnitPK != null && !this.courseUnitPK.equals(other.courseUnitPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return courseUnitPK + " " + name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
