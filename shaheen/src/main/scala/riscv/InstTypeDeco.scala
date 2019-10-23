package riscv

import chisel3._
import chisel3.util._

class InstTypeDeco extends Module {
  val io = IO (new Bundle {
	val opcode = Input(UInt(7.W))
	val R = Output(UInt(1.W))
	val Load = Output(UInt(1.W))
	val Store = Output(UInt(1.W))
	val Branch = Output(UInt(1.W))
	val I = Output(UInt(1.W))
	val Jal = Output(UInt(1.W))
	val Jalr = Output(UInt(1.W))
	val Lui = Output(UInt(1.W))
  })
	when (io.opcode === "h33".U){
		io.R := "b1".U
		io.Load := "b0".U
		io.Store := "b0".U
		io.Branch := "b0".U
		io.I := "b0".U
		io.Jal := "b0".U
		io.Jalr := "b0".U
		io.Lui := "b0".U
	}
	.elsewhen (io.opcode === "h3".U){
		io.R := "b0".U 
		io.Load := "b1".U
		io.Store := "b0".U
		io.Branch := "b0".U
		io.I := "b0".U
		io.Jal := "b0".U
		io.Jalr := "b0".U
		io.Lui := "b0".U	
	}
	.elsewhen (io.opcode === "h23".U){
		io.R := "b0".U 
		io.Load := "b0".U
		io.Store := "b1".U
		io.Branch := "b0".U
		io.I := "b0".U
		io.Jal := "b0".U
		io.Jalr := "b0".U
		io.Lui := "b0".U	
	}
	.elsewhen (io.opcode === "h63".U){
		io.R := "b0".U 
		io.Load := "b0".U
		io.Store := "b0".U
		io.Branch := "b1".U
		io.I := "b0".U
		io.Jal := "b0".U
		io.Jalr := "b0".U
		io.Lui := "b0".U	
	}
	.elsewhen (io.opcode === "h13".U){
		io.R := "b0".U 
		io.Load := "b0".U
		io.Store := "b0".U
		io.Branch := "b0".U
		io.I := "b1".U
		io.Jal := "b0".U
		io.Jalr := "b0".U
		io.Lui := "b0".U	
	}
	.elsewhen (io.opcode === "h67".U){
		io.R := "b0".U 
		io.Load := "b0".U
		io.Store := "b0".U
		io.Branch := "b0".U
		io.I := "b0".U
		io.Jal := "b0".U
		io.Jalr := "b1".U
		io.Lui := "b0".U	
	}
	.elsewhen (io.opcode === "h6f".U){
		io.R := "b0".U 
		io.Load := "b0".U
		io.Store := "b0".U
		io.Branch := "b0".U
		io.I := "b0".U
		io.Jal := "b1".U
		io.Jalr := "b0".U
		io.Lui := "b0".U	
	}
	.elsewhen (io.opcode === "h37".U){
		io.R := "b0".U 
		io.Load := "b0".U
		io.Store := "b0".U
		io.Branch := "b0".U
		io.I := "b0".U
		io.Jal := "b0".U
		io.Jalr := "b0".U
		io.Lui := "b1".U	
	}
	.otherwise {
		io.R := "b0".U
		io.Load := "b0".U
		io.Store := "b0".U
		io.Branch := "b0".U
		io.I := "b0".U
		io.Jal := "b0".U
		io.Jalr := "b0".U
		io.Lui := "b0".U
	}
}
