package riscv

import chisel3.iotesters.PeekPokeTester

class ImmGenTests(c: ImmGen) extends PeekPokeTester(c) {
	poke(c.io.instruction, 7342080)
	poke(c.io.pc, 1)
	step(1)
	//expect(c.io.s_imm, 16)
	expect(c.io.sb_imm, 17)
	//expect(c.io.uj_imm, 2055)
	//expect(c.io.u_imm, 7340032)
	//expect(c.io.i_imm, 7)
}
