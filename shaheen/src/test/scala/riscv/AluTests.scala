package riscv

import chisel3.iotesters.PeekPokeTester

class AluTests(c: Alu) extends PeekPokeTester(c) {
        poke(c.io.AluControl,0)
        poke(c.io.in1, 0)
	poke(c.io.in2, 8192)
        step(1)
        expect(c.io.out, 8192)
	expect(c.io.Branch, 0)
}
