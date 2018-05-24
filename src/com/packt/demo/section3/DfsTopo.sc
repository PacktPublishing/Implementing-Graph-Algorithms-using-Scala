import com.packt.demo.section3.GameGraph.g

case class DfsStep(visited: Set[String] = Set(), sort: List[String] = Nil)

def topoDfsSort(node: String, dfsStep: DfsStep): DfsStep = {
  if (dfsStep.visited.contains(node)) dfsStep
  else {
    val preDfsStep = dfsStep.copy(visited = dfsStep.visited + node)
    val postDfsStep = g.neighbours(node)
      .foldLeft(preDfsStep)((step, n) => topoDfsSort(n, step))
    postDfsStep.copy(sort = node +: postDfsStep.sort)
  }
}





val result = g.vertices
  .foldLeft(DfsStep())((step, n) => topoDfsSort(n, step)).sort