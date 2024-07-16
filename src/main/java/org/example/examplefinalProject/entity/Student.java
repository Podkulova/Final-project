package org.example.examplefinalProject.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    private String studentName;
    private String studentSurname;

    @ManyToOne
    private ClassRoom classRoom;
    @ManyToMany(mappedBy = "children")
    @OrderBy(value = "parentSurname, parentName")
    private List<Parent> parents;

        public Integer getStudentId() {
                return studentId;
        }

        public void setStudentId(Integer id) {
                this.studentId = id;
        }

        public String getStudentName() {
                return studentName;
        }

        public void setStudentName(String name) {
                this.studentName = name;
        }

        public String getStudentSurname() {
                return studentSurname;
        }

        public void setStudentSurname(String surname) {
                this.studentSurname = surname;
        }

        public ClassRoom getClassRoom() {
                return classRoom;
        }

        public void setClassRoom(ClassRoom classRoom) {
                this.classRoom = classRoom;
        }

        public List<Parent> getParents() {
                return parents;
        }

        public void setParents(List<Parent> parents) {
                this.parents = parents;
        }

        public String getFullName(){
                return studentName + " "  + studentSurname;
        }

        @Override
    public String toString() {
        return String.format("%s %s [%d]", studentName, studentSurname, studentId);
    }
}


