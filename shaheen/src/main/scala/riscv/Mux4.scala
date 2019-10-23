package riscv

import chisel3._

class Mux4 extends Module {
  val io = IO(new Bundle {
        val a = Input(UInt(1.W))
        val b = Input(UInt(1.W))
	val c = Input(UInt(1.W))
        val d = Input(UInt(1.W))
	val s0=Input(UInt(1.W))
	val s1=Input(UInt(1.W))
        val output = Output(UInt(1.W))
  })
	val mux1 = Module(new Mux())
	val mux2 = Module(new Mux())
	val mux3 = Module(new Mux())
	
	mux1.io.a := io.a
	mux1.io.b := io.b

	mux2.io.a := io.c
	mux2.io.b := io.d

	mux1.io.sel := io.s0
	mux2.io.sel := io.s0

	mux3.io.a := mux1.io.output
	mux3.io.b := mux2.io.output
	
	mux3.io.sel := io.s1

	io.output := mux3.io.output
}
