package org.example.examplefinalProject.entity;

import jakarta.persistence.*;

import java.util.List;

/**
 *
 */
@Entity
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer parentId;

    private String parentName;
    private String parentSurname;
    private String parentEmail;
    private String parentPhone;

    @ManyToMany
    @JoinTable(
            name = "student_parent",
            joinColumns = @JoinColumn(name = "parent_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    @OrderBy(value = "studentSurname, studentName")
    private List<Student> children;

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer ParentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentSurname() {
        return parentSurname;
    }

    public void setParentSurname(String parentSurname) {
        this.parentSurname = parentSurname;
    }

    public String getParentEmail() {
        return parentEmail;
    }

    public void setParentEmail(String parentEmail) {
        this.parentEmail = parentEmail;
    }

    public String getParentPhone() {
        return parentPhone;
    }

    public void setParentPhone(String parentPhone) {
        this.parentPhone = parentPhone;
    }

    public List<Student> getChildren() {
        return children;
    }

    public void setChildren(List<Student> children) {
        this.children = children;
    }

    public String getParentFullName(){
        return parentName + " " + parentSurname;
    }

    @Override
    public String toString(){
        return String.format("%s %s [%d]", parentName, parentSurname, parentId);
    }
}