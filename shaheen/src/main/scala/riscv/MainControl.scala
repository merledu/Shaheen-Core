package riscv

import chisel3._
import chisel3.util._

class MainControl extends Module {
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
	when (io.opcode === "h33".U){
		io.MemWrite := "b0".U
		io.Branch := "b0".U
		io.MemRead := "b0".U
		io.RegWrite := "b1".U
		io.MemtoReg := "b0".U
		io.AluOp := "b000".U
		io.OpA := "b00".U
		io.OpB := "b0".U
		io.ExtSel := "b00".U
		io.NextPc := "b00".U
	}
	.elsewhen (io.opcode === "h3".U){
		io.MemWrite := "b0".U
		io.Branch := "b0".U
		io.MemRead := "b1".U
		io.RegWrite := "b1".U
		io.MemtoReg := "b1".U
		io.AluOp := "b100".U
		io.OpA := "b00".U
		io.OpB := "b1".U
		io.ExtSel := "b00".U
		io.NextPc := "b00".U	
	}
	.elsewhen (io.opcode === "h23".U){
		io.MemWrite := "b1".U
		io.Branch := "b0".U
		io.MemRead := "b0".U
		io.RegWrite := "b0".U
		io.MemtoReg := "b0".U
		io.AluOp := "b101".U
		io.OpA := "b00".U
		io.OpB := "b1".U
		io.ExtSel := "b10".U
		io.NextPc := "b00".U	
	}
	.elsewhen (io.opcode === "h63".U){
		io.MemWrite := "b0".U
		io.Branch := "b1".U
		io.MemRead := "b0".U
		io.RegWrite := "b0".U
		io.MemtoReg := "b0".U
		io.AluOp := "b010".U
		io.OpA := "b00".U
		io.OpB := "b0".U
		io.ExtSel := "b00".U
		io.NextPc := "b01".U	
	}
	.elsewhen (io.opcode === "h13".U){
		io.MemWrite := "b0".U
		io.Branch := "b0".U
		io.MemRead := "b0".U
		io.RegWrite := "b1".U
		io.MemtoReg := "b0".U
		io.AluOp := "b001".U
		io.OpA := "b00".U
		io.OpB := "b1".U
		io.ExtSel := "b00".U
		io.NextPc := "b00".U	
	}
	.elsewhen (io.opcode === "h67".U){
		io.MemWrite := "b0".U
		io.Branch := "b0".U
		io.MemRead := "b0".U
		io.RegWrite := "b1".U
		io.MemtoReg := "b0".U
		io.AluOp := "b011".U
		io.OpA := "b10".U
		io.OpB := "b0".U
		io.ExtSel := "b00".U
		io.NextPc := "b11".U	
	}
	.elsewhen (io.opcode === "h6f".U){
		io.MemWrite := "b0".U
		io.Branch := "b0".U
		io.MemRead := "b0".U
		io.RegWrite := "b1".U
		io.MemtoReg := "b0".U
		io.AluOp := "b011".U
		io.OpA := "b00".U
		io.OpB := "b0".U
		io.ExtSel := "b00".U
		io.NextPc := "b10".U	
	}
	.elsewhen (io.opcode === "h37".U){
		io.MemWrite := "b0".U
		io.Branch := "b0".U
		io.MemRead := "b0".U
		io.RegWrite := "b1".U
		io.MemtoReg := "b0".U
		io.AluOp := "b110".U
		io.OpA := "b11".U
		io.OpB := "b1".U
		io.ExtSel := "b01".U
		io.NextPc := "b00".U	
	}
	.otherwise {
		io.MemWrite := "b0".U
		io.Branch := "b0".U
		io.MemRead := "b0".U
		io.RegWrite := "b0".U
		io.MemtoReg := "b0".U
		io.AluOp := "b111".U
		io.OpA := "b00".U
		io.OpB := "b0".U
		io.ExtSel := "b00".U
		io.NextPc := "b00".U
	}
}
