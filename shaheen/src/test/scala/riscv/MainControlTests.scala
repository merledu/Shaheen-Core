package riscv

import chisel3.iotesters.PeekPokeTester

class MainControlTests(c: MainControl) extends PeekPokeTester(c) {
	poke(c.io.opcode, 0)
	step(1)
	expect(c.io.MemWrite, 0)
	expect(c.io.Branch, 0)
	expect(c.io.MemRead, 0)
	expect(c.io.RegWrite, 0)
	expect(c.io.MemtoReg, 0)
	expect(c.io.AluOp, 7)
	expect(c.io.OpA, 0)
	expect(c.io.OpB, 0)
	expect(c.io.ExtSel, 0)
	expect(c.io.NextPc, 0)
}
