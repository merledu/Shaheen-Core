package riscv

import chisel3.iotesters.PeekPokeTester

class MemoryTests(c: Memory) extends PeekPokeTester(c) {
        poke(c.io.wrAddr,2)
	step(1)
}
