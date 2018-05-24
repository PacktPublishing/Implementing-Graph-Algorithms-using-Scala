import com.packt.demo.section1.Graph
import com.packt.demo.section4.CycleDetection
val g1 = Graph(Map("A" -> List("B", "C"),
  "B" -> List("A", "C"),
  "C" -> List("A")))










val startNodes = g1.vertices.filter(v =>
  g1.edges.forall(e => e._2 != v))
startNodes.isEmpty || startNodes.exists(n =>
  CycleDetection.containsCycleDfs(n, g1).isCyclic)

g1.vertices.exists(v => CycleDetection.containsCycleDfs(v, g1).isCyclic)
