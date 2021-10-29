package main

import "fmt"

type user struct {
  name string
}

func main() {
  var newUser user

  newUser.name = "a"

  fmt.Println(newUser)
}

