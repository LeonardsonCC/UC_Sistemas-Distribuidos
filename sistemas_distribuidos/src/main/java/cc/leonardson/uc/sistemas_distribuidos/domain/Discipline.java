package cc.leonardson.uc.sistemas_distribuidos.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @ManyToOne
    private Professor professor;

    @Override
    public String toString() {
        return "Discipline{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", professor=" + professor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discipline that = (Discipline) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(professor, that.professor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, professor);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
