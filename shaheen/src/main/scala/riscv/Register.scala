package riscv

import chisel3._
import chisel3.util._

class Register extends Module {
  val io = IO (new Bundle {
	val RegWrite = Input(UInt(1.W))
	val rs1_s = Input(UInt(5.W))
	val rs2_s = Input(UInt(5.W))
	val rd = Input(UInt(5.W))
	val WriteData = Input(SInt(32.W))
	val rs1 = Output(SInt(32.W))
	val rs2 = Output(SInt(32.W))
  })
	val register = Reg(Vec(32,SInt(32.W)))
	register(0) := 0.S
	io.rs1 := register(io.rs1_s)
	io.rs2 := register(io.rs2_s)
	when(io.RegWrite === 1.U){
		when(io.rd === "b00000".U){register(io.rd) := 0.S}
		.otherwise {register(io.rd) := io.WriteData}
	}
}
