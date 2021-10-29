package main

import (
	"fmt"
	"math/rand"
	"time"
)

type worker struct {
	product     string
	time        int
	alreadyDone int
}

func (worker *worker) doWork() {
	timeToProduce := time.Duration(worker.time * rand.Intn(5))
	fmt.Println("Working on", worker.product, " in ", timeToProduce, "seconds")
	time.Sleep(time.Second * timeToProduce * time.Duration(worker.time))
	worker.alreadyDone++
	fmt.Println("Finished working on", worker.product, ", currently did ", worker.alreadyDone, " products")
	worker.doWork()
}

func main() {
	var workers [3]*worker
	workers[0] = &worker{"Chinelo", 1, 0}
	workers[1] = &worker{"Calça", 2, 0}
	workers[2] = &worker{"Camiseta", 3, 0}

	for _, worker := range workers {
		go worker.doWork()
	}

	for {
		time.Sleep(time.Second * 5)
	}
}
