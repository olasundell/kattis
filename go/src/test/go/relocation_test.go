package _go

import (
	"bufio"
	"fmt"
	"io/ioutil"
	"log"
	"os"
	"strings"
	"testing"
)

func TestRelocation(t *testing.T) {
	//dir, err := os.Open(".")
	file, err := os.Open("../../../../src/test/resources/relocation/1.in")
	//info, err := dir.Stat()
	//s, err := filepath.Abs(".")
	if err != nil {
		log.Fatal(err)
	}
	//fmt.Print(s)
	defer file.Close()


	b, err := ioutil.ReadAll(file)
	fmt.Printf("%s", b)
	bufio.NewScanner(strings.NewReader(b))
}
