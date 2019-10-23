package riscv

import chisel3._
import chisel3.util._
import chisel3.core

class Top extends Module {
  val io = IO (new Bundle {
	//val Instruction = Input(UInt(32.W))
	//val Pc = Input(UInt(32.W))
	val Reg_Out = Output(SInt(32.W))
  })
	val Alu = Module(new Alu())
	val Control = Module(new Control())
	val ImmediateGeneration = Module(new ImmGen())
	val AluControl = Module(new AluCntrl())
	val Register = Module(new Register())
	val Memory = Module(new Memory())
	val Pc = Module(new Pc())
	val Jalr = Module(new Jalr())
	val DataMemory = Module(new MemoryD())


	Memory.io.wrAddr := Pc.io.pc(11,2)
	Pc.io.input := Pc.io.pc4

	Control.io.opcode := Memory.io.rdData(6,0)
	ImmediateGeneration.io.instruction := Memory.io.rdData
	ImmediateGeneration.io.pc := Pc.io.pc

	Register.io.RegWrite := Control.io.RegWrite
	Register.io.rs1_s := Memory.io.rdData(19,15)
	Register.io.rs2_s := Memory.io.rdData(24,20)
	Register.io.rd := Memory.io.rdData(11,7)
	//Register.io.WriteData := Alu.io.out

	AluControl.io.aluOp := Control.io.AluOp
	AluControl.io.funct3 := Memory.io.rdData(14,12)
	AluControl.io.funct7 := Memory.io.rdData(30)


	//Alu.io.in1 := Register.io.rs1
	when (Control.io.ExtSel === "b00".U && Control.io.OpB === "b1".U){Alu.io.in2 := ImmediateGeneration.io.i_imm}
	.elsewhen (Control.io.ExtSel === "b01".U && Control.io.OpB === "b1".U){Alu.io.in2 := ImmediateGeneration.io.u_imm}
	.elsewhen (Control.io.ExtSel === "b10".U && Control.io.OpB === "b1".U){
		Alu.io.in2 := ImmediateGeneration.io.s_imm}
		//Alu.io.in1:=Register.io.rs1
		//Pc.io.input:=Pc.io.pc4}
	.otherwise {Alu.io.in2 := Register.io.rs2}
	Alu.io.AluControl := AluControl.io.out
	Register.io.WriteData := Alu.io.out
	io.Reg_Out := Register.io.WriteData

	when (Control.io.NextPc === "b01".U && Control.io.Branch === "b0".U && Alu.io.Branch === "b0".U){Pc.io.input := Pc.io.pc4}
	.elsewhen (Control.io.NextPc === "b01".U && Control.io.Branch === "b1".U && Alu.io.Branch === "b0".U){Pc.io.input := Pc.io.pc4}
	.elsewhen (Control.io.NextPc === "b01".U && Control.io.Branch === "b0".U && Alu.io.Branch === "b1".U){Pc.io.input := Pc.io.pc4}
	.elsewhen (Control.io.NextPc === "b01".U && Control.io.Branch === "b1".U && Alu.io.Branch === "b1".U){Pc.io.input := ImmediateGeneration.io.sb_imm.asUInt}
	.elsewhen (Control.io.NextPc === "b00".U){Pc.io.input := Pc.io.pc4}
	.elsewhen (Control.io.NextPc === "b10".U){Pc.io.input := ImmediateGeneration.io.uj_imm.asUInt}
	.elsewhen (Control.io.NextPc === "b11".U){Pc.io.input := Jalr.io.out.asUInt}
	.otherwise {Pc.io.input := DontCare}

	Jalr.io.in1 := Register.io.rs1
	Jalr.io.in2 := ImmediateGeneration.io.i_imm

	DataMemory.io.Addr := (Alu.io.out(9,2)).asUInt
	DataMemory.io.Data := Register.io.rs2
	DataMemory.io.MemWrite := Control.io.MemWrite
	DataMemory.io.MemRead := Control.io.MemRead

	when (Control.io.MemtoReg === 1.U){Register.io.WriteData := DataMemory.io.out}
	.otherwise {Register.io.WriteData := Alu.io.out}

	when (Control.io.OpA === "b00".U || Control.io.OpA === "b11".U){Alu.io.in1 := Register.io.rs1}
	.elsewhen (Control.io.OpA === "b10".U){Alu.io.in1 := Pc.io.pc4.asSInt}
	.otherwise {Alu.io.in1 := DontCare}
}
