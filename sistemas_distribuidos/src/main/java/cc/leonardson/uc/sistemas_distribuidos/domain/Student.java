package cc.leonardson.uc.sistemas_distribuidos.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  @Column
  private Double grade1;

  @Column
  private Double grade2;

  @Column
  private Double grade3;

  public Student(Integer id, String name, Double grade1, Double grade2, Double grade3) {
    this.id = id;
    this.name = name;
    this.grade1 = grade1;
    this.grade2 = grade2;
    this.grade3 = grade3;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getGrade1() {
    return grade1;
  }

  public void setGrade1(Double grade1) {
    this.grade1 = grade1;
  }

  public Double getGrade2() {
    return grade2;
  }

  public void setGrade2(Double grade2) {
    this.grade2 = grade2;
  }

  public Double getGrade3() {
    return grade3;
  }

  public void setGrade3(Double grade3) {
    this.grade3 = grade3;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, grade1, grade2, grade3, name);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Student other = (Student) obj;
    return Objects.equals(id, other.id) && Objects.equals(grade1, other.grade1) && Objects.equals(grade2, other.grade2)
        && Objects.equals(grade3, other.grade3) && Objects.equals(name, other.name);
  }

  @Override
  public String toString() {
    return "Student [grade1=" + grade1 + ", grade2=" + grade2 + ", grade3=" + grade3 + ", id=" + id + ", name=" + name
        + "]";
  }
}
