package riscv

import chisel3.iotesters.PeekPokeTester

class PcTests(c: Pc) extends PeekPokeTester(c) {
        poke(c.io.input, 2)
        step(1)
}
