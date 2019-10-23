package riscv

import chisel3._
import chisel3.util._
import chisel3.core

class MemoryD extends Module {
  val io = IO (new Bundle {
	val Addr = Input(UInt(8.W))
	val Data = Input(SInt(32.W))
	val MemWrite = Input(UInt(1.W))
	val MemRead = Input(UInt(1.W))
	val out = Output(SInt(32.W))
  })
	val mem = Mem(1024,SInt(32.W))
	when (io.MemWrite === 1.U){
		mem.write(io.Addr , io.Data )
		}

	//mem(io.Addr) := (io.Data).asUInt
	when(io.MemRead === 1.U){
		io.out := mem.read(io.Addr)
		}
	.otherwise {io.out := DontCare}
}
