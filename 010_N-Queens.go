package main

import (
	"fmt"
	"math"
)

var (
	a     [30]int
	count int = 0
)

func place(pos int) bool {
	for i := 1; i < pos; i++ {
		if a[i] == a[pos] || (math.Abs(float64(a[i]-a[pos])) == math.Abs(float64(i-pos))) {
			return false
		}
	}
	return true
}

func print_sol(n int) {
	count++
	fmt.Println("\nSolution #", count, ":")
	for i := 1; i <= n; i++ {
		for j := 1; j <= n; j++ {
			if a[i] == a[j] {
				fmt.Print("Q\t")
			} else {
				fmt.Print("*\t")
			}
		}
		fmt.Println()
	}
}

func queen(n int) {
	k := 1
	a[k] = 0
	for k != 0 {
		a[k] = a[k] + 1
		for (a[k] <= n) && !place(k) {
			a[k]++
		}
		if a[k] <= n {
			if k == n {
				print_sol(n)
			} else {
				k++
				a[k] = 0
			}
		} else {
			k--
		}
	}
}

func main() {
	var n int
	fmt.Println("Enter the number of queen")
	fmt.Scan(&n)
	queen(n)
	fmt.Println("\nTotal solutions:", count)
}
