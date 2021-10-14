package cc.leonardson.uc.sistemas_distribuidos.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Matricula {

    @EmbeddedId
    MatriculaPK id;

    String semester;

    public MatriculaPK getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matricula matricula = (Matricula) o;
        return Objects.equals(id, matricula.id) && Objects.equals(semester, matricula.semester);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, semester);
    }

    public void setId(MatriculaPK id) {
        this.id = id;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}
