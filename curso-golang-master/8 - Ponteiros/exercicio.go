package main

import "fmt"

type pessoa struct {
	name string
	age  uint8
	sex  string
}

func main() {
	var p1 *pessoa = &pessoa{
		name: "Leonardson",
		age:  21,
		sex:  "Masculino",
	}
	var p2 *pessoa = &pessoa{
		name: "Thiago",
		age:  23,
		sex:  "Masculino",
	}

	var p3 *pessoa = p1
	// p3.name = "Joao"

	fmt.Printf("%v | %v | %v", p1, p2, *p3)
}
