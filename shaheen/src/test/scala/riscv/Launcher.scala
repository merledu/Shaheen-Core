// See LICENSE.txt for license details.
package riscv

import chisel3.iotesters.{Driver, TesterOptionsManager}
import utils.TutorialRunner

object Launcher {
  val examples = Map(
	"MainControl" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new MainControl(), manager) {
          (c) => new MainControlTests(c)
        }
      },
	"Practice" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Practice(), manager) {
          (c) => new PracticeTests(c)
        }
      },
	"MemoryD" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new MemoryD(), manager) {
          (c) => new MemoryDTests(c)
        }
      },
	"Memory" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Memory(), manager) {
          (c) => new MemoryTests(c)
        }
      },
	"Pc" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Pc(), manager) {
          (c) => new PcTests(c)
        }
      },
	"Jalr" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Jalr(), manager) {
          (c) => new JalrTests(c)
        }
      },
	"Top" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Top(), manager) {
          (c) => new TopTests(c)
        }
      },
	"Register" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Register(), manager) {
          (c) => new RegisterTests(c)
        }
      },
	"Alu" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Alu(), manager) {
          (c) => new AluTests(c)
        }
      },
	"Control" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Control(), manager) {
          (c) => new ControlTests(c)
        }
      },
	"CntrlDecode" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new CntrlDecode(), manager) {
          (c) => new CntrlDecodeTests(c)
        }
      },
	"InstTypeDeco" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new InstTypeDeco(), manager) {
          (c) => new InstTypeDecoTests(c)
        }
      },
	"AluCntrl" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new AluCntrl(), manager) {
          (c) => new AluCntrlTests(c)
        }
      },
	"ImmGen" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new ImmGen(), manager) {
          (c) => new ImmGenTests(c)
        }
      },
	"Adder32" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Adder32(), manager) {
          (c) => new Adder32Tests(c)
        }
      },
	"adder" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new adder(), manager) {
          (c) => new adderTests(c)
        }
      },
	"Mux4" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Mux4(), manager) {
          (c) => new Mux4Tests(c)
        }
      },
	"Mux" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Mux(), manager) {
          (c) => new MuxTests(c)
        }
      },
	"Nor" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Nor(), manager) {
          (c) => new NorTests(c)
        }
      }
  )
  def main(args: Array[String]): Unit = {
    TutorialRunner("examples", examples, args)
  }
}

