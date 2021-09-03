package cc.leonardson.uc.sistemas_distribuidos.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cc.leonardson.uc.sistemas_distribuidos.domain.Student;

@Service
public class StudentService {
  
  public List<Student> listAll() {
    List<Student> list = new ArrayList<Student>();

    Student s1 = new Student(1, "Joao", 10.0, 10.0, 10.0);
    Student s2 = new Student(2, "Maria", 7.0, 9.0, 8.0);
    Student s3 = new Student(3, "Pedro", 3.0, 5.0, 1.0);

    list.add(s1);
    list.add(s2);
    list.add(s3);

    return list;
  }
  
}
