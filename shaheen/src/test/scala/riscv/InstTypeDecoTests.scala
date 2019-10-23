package riscv

import chisel3.iotesters.PeekPokeTester

class InstTypeDecoTests(c: InstTypeDeco) extends PeekPokeTester(c) {
	poke(c.io.opcode, 55)
	step(1)
	expect(c.io.R, 0)
	expect(c.io.Load, 0)
	expect(c.io.Store, 0)
	expect(c.io.Branch, 0)
	expect(c.io.I, 0)
	expect(c.io.Jal, 0)
	expect(c.io.Jalr, 0)
	expect(c.io.Lui, 1)
}
