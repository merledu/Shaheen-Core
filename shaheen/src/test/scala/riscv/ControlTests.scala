package riscv

import chisel3.iotesters.PeekPokeTester

class ControlTests(c: Control) extends PeekPokeTester(c) {
	poke(c.io.opcode, 99)
	step(1)
	expect(c.io.MemWrite, 0)
	expect(c.io.Branch, 1)
	expect(c.io.MemRead, 0)
	expect(c.io.RegWrite, 0)
	expect(c.io.MemtoReg, 0)
	expect(c.io.AluOp, 2)
	expect(c.io.OpA, 0)
	expect(c.io.OpB, 0)
	expect(c.io.ExtSel, 0)
	expect(c.io.NextPc, 1)
}
