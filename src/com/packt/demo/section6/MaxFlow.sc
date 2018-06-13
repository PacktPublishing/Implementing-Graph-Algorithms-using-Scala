import com.packt.demo.section6.FlowNetwork._

def maxFlow(residualGraph: Vector[Int], s: Int, t: Int, flow: Int = 0): Int = {
  val path = findPathBFS(s, t, residualGraph)

  if (path.nonEmpty) {
    val minPathFlow = path.map { case (u, v) => edgeAt(residualGraph, u, v) }.min

    val newResidualGraph = path.foldLeft(residualGraph) { case (rGraph, (eA, eB)) =>
      val flowF = edgeAt(rGraph, eA, eB)
      val flowB = edgeAt(rGraph, eB, eA)
      val forwardUpdate = update(rGraph, eA, eB, flowF - minPathFlow)
      update(forwardUpdate, eB, eA, flowB + minPathFlow)
    }
    val newFlow = flow + minPathFlow
    maxFlow(newResidualGraph, s, t, newFlow)
  }
  else flow
}

maxFlow(g, vertices.indexOf("S"), vertices.indexOf("T"))

