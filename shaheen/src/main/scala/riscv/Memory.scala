package riscv

import chisel3._
import chisel3.util.experimental.loadMemoryFromFile

class Memory extends Module {
  val io = IO (new Bundle {
	val wrAddr = Input(UInt(10.W))
	val rdData = Output(UInt(32.W))
  })
	val mem = Mem(1024,UInt(32.W))
	io.rdData := mem(io.wrAddr)
	loadMemoryFromFile(mem,"/home/talha/riscv/shaheen/abc.txt")
}
