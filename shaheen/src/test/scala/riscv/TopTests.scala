package riscv

import chisel3.iotesters.PeekPokeTester

class TopTests(c: Top) extends PeekPokeTester(c) {
	step(6)
}
