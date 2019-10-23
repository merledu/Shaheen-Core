package riscv
import chisel3._
import chisel3.util.Cat
class AluCntrl extends Module {
  val io = IO(new Bundle {
        val aluOp = Input(UInt(3.W))
        val funct3 = Input(UInt(3.W))
        val funct7 = Input(UInt(1.W))
	val out = Output(UInt(5.W))
  })
	when (io.aluOp === "b000".U || io.aluOp === "b001".U){io.out := Cat("b0".U,io.funct7,io.funct3)}  //R and I
	.elsewhen (io.aluOp === "b101".U || io.aluOp === "b100".U){io.out := Cat("b00000".U)}  //S and I (SW and LW)
	.elsewhen (io.aluOp === "b011".U){io.out := Cat("b11111".U)}  //UJ and I (JALR AND JAL)
	.elsewhen (io.aluOp === "b010".U){io.out := Cat("b10".U,io.funct3)}  //SB
	.elsewhen (io.aluOp === "b110".U){io.out := Cat("b00000".U)}  //U
	.otherwise {io.out := DontCare}
}
