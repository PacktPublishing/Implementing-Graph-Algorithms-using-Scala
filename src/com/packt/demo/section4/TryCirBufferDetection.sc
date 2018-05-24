import com.packt.demo.section1.Graph
import com.packt.demo.section4.CircularBufferDetection

val g = Graph(Map("A" -> List("B"),
  "B" -> List("C"),
  "C" -> List("D"),
  "D" -> List("A")))











CircularBufferDetection.containsCycleFloyd("A", g)

