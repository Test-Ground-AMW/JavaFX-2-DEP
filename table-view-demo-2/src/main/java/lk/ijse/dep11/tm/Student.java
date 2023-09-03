package lk.ijse.dep11.tm;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;
    private String programme;
    private String contactNo;

    public Student() {
    }

    public Student(int id, String name, String programme, String contactNo) {
        this.setId(id);
        this.setName(name);
        this.setProgramme(programme);
        this.setContactNo(contactNo);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
}
