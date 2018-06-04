/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.milos.univesitycourse.enumeration.Status;

/**
 *
 * @author Milos
 */
@Entity
@Table(name = "course")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c")})
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Size(min = 1, max = 200)
    @Column(name = "goal")
    private String goal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESPB")
    private int espb;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course",
            fetch = FetchType.EAGER, orphanRemoval = true)
    private List<CourseUnit> courseUnits;

    @ManyToMany(cascade = {
        CascadeType.DETACH,
        CascadeType.MERGE,
        CascadeType.REFRESH,
        CascadeType.PERSIST
    })
    @JoinTable(name = "role",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "lecturer_id")
    )
    private List<Lecturer> lecturers;
    @JoinColumn(name = "stud_prog_id_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StudyProgramme studProgIdFk;
    @JoinColumn(name = "department_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Department departmentFk;

    public Course() {
    }

    public Course(Long id) {
        this.id = id;
    }

    public void addLecturer(Lecturer lecturer) {
        lecturers.add(lecturer);
        lecturer.getCourses().add(this);
    }

    public void removeLecturer(Lecturer lecturer) {
        lecturers.remove(lecturer);
        lecturer.getCourses().remove(this);
    }

    public Course(String name, String goal, Status status, int espb, StudyProgramme studProgIdFk, Department departmentFk) {
        this.name = name;
        this.goal = goal;
        this.status = status;
        this.espb = espb;
        this.studProgIdFk = studProgIdFk;
        this.departmentFk = departmentFk;
        courseUnits = new ArrayList<>();
        lecturers = new ArrayList<>();
    }

    public Course(Long id, String name, String goal, Status status, int espb) {
        this.id = id;
        this.name = name;
        this.goal = goal;
        this.status = status;
        this.espb = espb;
    }

    public void addCourseUnit(CourseUnit cu) {
//        cu.setCourse(this);
        courseUnits.add(cu);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getEspb() {
        return espb;
    }

    public void setEspb(int espb) {
        this.espb = espb;
    }

    public List<CourseUnit> getCourseUnits() {
        return courseUnits;
    }

    public void setCourseUnits(List<CourseUnit> courseUnits) {
        this.courseUnits = courseUnits;
    }

    public StudyProgramme getStudProgIdFk() {
        return studProgIdFk;
    }

    public void setStudProgIdFk(StudyProgramme studProgIdFk) {
        this.studProgIdFk = studProgIdFk;
    }

    public Department getDepartmentFk() {
        return departmentFk;
    }

    public void setDepartmentFk(Department departmentFk) {
        this.departmentFk = departmentFk;
    }

    public List<Lecturer> getLecturers() {
        return lecturers;
    }

    public void setLecturers(List<Lecturer> lecturers) {
        this.lecturers = lecturers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.milos.univesitycourse.domain.Course[ id=" + id + " ]";
    }

}
