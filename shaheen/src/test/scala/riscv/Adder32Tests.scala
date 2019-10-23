package riscv

import chisel3.iotesters.PeekPokeTester

class Adder32Tests(c: Adder32) extends PeekPokeTester(c) {
        poke(c.io.a, 19)
        poke(c.io.b, 10)
        step(1)
	expect(c.io.out, 29)
}
