package riscv

import chisel3._
import chisel3.util._
import chisel3.core.SInt

class Practice extends Module {
  val io = IO (new Bundle {
	val instruction = Input(UInt(32.W))
	val pc = Input(UInt(32.W))
	val s_imm = Output(SInt(32.W))
	val sb_imm = Output(SInt(32.W))
	val uj_imm = Output(SInt(32.W))
	val u_imm = Output(SInt(32.W))
	val i_imm = Output(SInt(32.W))
  })
	//S
	val s_imm13 = Cat (io.instruction(31,25),io.instruction(11,7))
	io.s_imm := (Cat(Fill(20,s_imm13(11)),s_imm13)).asSInt
	//SB
	val sb_imm13 = Cat (io.instruction(31),io.instruction(7),io.instruction(30,25),io.instruction(11,8),"b0".U)
	io.sb_imm := ((Cat(Fill(19,sb_imm13(12)),sb_imm13)) + io.pc).asSInt
	//UJ
	val uj_imm21 = Cat (io.instruction(31),io.instruction(19,12),io.instruction(20),io.instruction(30,21),"b0".U)
	io.uj_imm := ((Cat(Fill(12,uj_imm21(20)),uj_imm21)) + io.pc).asSInt
	//U
	io.u_imm := ((Cat(Fill(12,io.instruction(31)),io.instruction(31,12))) << 12).asSInt
	//I
	io.i_imm := (Cat(Fill(20,io.instruction(31)),io.instruction(31,20))).asSInt
}
