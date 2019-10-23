package riscv

import chisel3.iotesters.PeekPokeTester

class CntrlDecodeTests(c: CntrlDecode) extends PeekPokeTester(c) {
	poke(c.io.R, 0)
	poke(c.io.Load, 0)
	poke(c.io.Store, 0)
	poke(c.io.Branch1, 1)
	poke(c.io.I, 0)
	poke(c.io.Jal, 0)
	poke(c.io.Jalr, 0)
	poke(c.io.Lui, 0)
	step(1)
//	expect(c.io.MemWrite, 0)
//	expect(c.io.Branch, 1)
//	expect(c.io.MemRead, 0)
//	expect(c.io.RegWrite, 0)
//	expect(c.io.MemtoReg, 0)
//	expect(c.io.AluOp, 2)
//	expect(c.io.OpA, 0)
//	expect(c.io.OpB, 0)
//	expect(c.io.ExtSel, 0)
	expect(c.io.NextPc, 1)
}
