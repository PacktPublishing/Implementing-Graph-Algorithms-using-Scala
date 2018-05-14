import com.packt.demo.section1.Graph
import com.packt.demo.section2.Traversal

val g = Graph[String]()
  .addEdge("A", "B")
  .addEdge("B", "C")
  .addEdge("C", "E")
  .addEdge("C", "D")
  .addEdge("A", "G")
  .addEdge("G", "H")
  .addEdge("H", "F")
  .addEdge("F", "A")
  .addEdge("D", "E")





Traversal.traversalDFS("A", g, println)

Traversal.traversalBFS("A", g, println)