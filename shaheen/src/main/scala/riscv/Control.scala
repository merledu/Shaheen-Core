package riscv

import chisel3._
import chisel3.util._

class Control extends Module {
  val io = IO (new Bundle {
	val opcode = Input(UInt(7.W))
	val MemWrite = Output(UInt(1.W))
	val Branch = Output(UInt(1.W))
	val MemRead = Output(UInt(1.W))
	val RegWrite = Output(UInt(1.W))
	val MemtoReg = Output(UInt(1.W))
	val AluOp = Output(UInt(3.W))
	val OpA = Output(UInt(2.W))
	val OpB = Output(UInt(1.W))
	val ExtSel = Output(UInt(2.W))
	val NextPc = Output(UInt(2.W))
  })
	val c1 = Module(new InstTypeDeco())
	val c2 = Module(new CntrlDecode())

	c1.io.opcode := io.opcode

	c2.io.R := c1.io.R
	c2.io.Load := c1.io.Load
	c2.io.Store := c1.io.Store
	c2.io.Branch1 := c1.io.Branch
	c2.io.I := c1.io.I
	c2.io.Jal := c1.io.Jal
	c2.io.Jalr := c1.io.Jalr
	c2.io.Lui := c1.io.Lui

	io.MemWrite := c2.io.MemWrite
	io.Branch := c2.io.Branch
	io.MemRead := c2.io.MemRead
	io.RegWrite := c2.io.RegWrite
	io.MemtoReg := c2.io.MemtoReg
	io.AluOp := c2.io.AluOp
	io.OpA := c2.io.OpA
	io.OpB := c2.io.OpB
	io.ExtSel := c2.io.ExtSel
	io.NextPc := c2.io.NextPc
}
