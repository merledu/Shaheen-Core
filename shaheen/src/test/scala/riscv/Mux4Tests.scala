package riscv

import chisel3.iotesters.PeekPokeTester

class Mux4Tests(c: Mux4) extends PeekPokeTester(c) {
        poke(c.io.a,0)
        poke(c.io.b, 0)
	poke(c.io.c,1)
        poke(c.io.d, 0)
	poke(c.io.s0, 0)
	poke(c.io.s1, 1)
        step(1)
        expect(c.io.output, 1)
}
