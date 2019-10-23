package riscv

import chisel3.iotesters.PeekPokeTester

class MemoryDTests(c: MemoryD) extends PeekPokeTester(c) {
	poke(c.io.Addr, 1)
	poke(c.io.Data, 2)
	poke(c.io.MemRead, 1)
	poke(c.io.MemWrite, 0)
	step(1)
	expect(c.io.out, 2)
}
