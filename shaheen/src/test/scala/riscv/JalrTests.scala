package riscv

import chisel3.iotesters.PeekPokeTester

class JalrTests(c: Jalr) extends PeekPokeTester(c) {
        poke(c.io.in1,1)
        poke(c.io.in2, 1)
	step(1)
	expect(c.io.out, 2)
}
