package main

import "fmt"

type person struct {
  heigth float32
  weight float32
  name string
}

func create_person (name string, height float32, weight float32) person {
  var newPerson person
  newPerson.name = name
  newPerson.heigth = height
  newPerson.weight = weight

  return newPerson
}

func calc_imc (person person) float64 {
  var imc float64 = float64(person.weight / (person.heigth * person.heigth))
  return imc
}

func main() {
  myPerson := create_person("Leonardson", 1.71, 60) 
  var imc float64 = calc_imc(myPerson)
  var result string

  if imc < 18.5 {
    result = "%s abaixo do peso %f"
  } else if imc < 25 {
    result = "%s normal %f"
  } else if imc < 30 {
    result = "%s sobrepeso %f"
  } else if imc < 40 {
    result = "%s obesidade %f"
  } else if imc >= 40 {
    result = "%s obesidade grave %f"
  }


  fmt.Println(fmt.Sprintf(result, myPerson.name, imc))
}
