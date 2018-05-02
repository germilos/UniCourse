/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Milos
 */
@Entity
@Table(name = "department")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d")})
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dept_chair_fk")
    private int deptChairFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "secretary_fk")
    private int secretaryFk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departmentFk")
    private List<Course> courseList;

    public Department() {
    }

    public Department(Long id) {
        this.id = id;
    }

    public Department(Long id, String name, int deptChairFk, int secretaryFk) {
        this.id = id;
        this.name = name;
        this.deptChairFk = deptChairFk;
        this.secretaryFk = secretaryFk;
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

    public int getDeptChairFk() {
        return deptChairFk;
    }

    public void setDeptChairFk(int deptChairFk) {
        this.deptChairFk = deptChairFk;
    }

    public int getSecretaryFk() {
        return secretaryFk;
    }

    public void setSecretaryFk(int secretaryFk) {
        this.secretaryFk = secretaryFk;
    }

    @XmlTransient
    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
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
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.milos.univesitycourse.domain.Department[ id=" + id + " ]";
    }
    
}
