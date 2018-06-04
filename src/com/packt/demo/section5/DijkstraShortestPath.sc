import com.packt.demo.section1.WeightedEdge
import com.packt.demo.section5.TravelGraph.g
import scala.util.Try

case class ShortStep(parents: Map[String, String],
                     unProcessed: Set[String],
                     dists: Map[String, Int]) {
  def extractMin(): Option[(String, Int)] =
    Try(unProcessed.minBy(n => dists(n))).toOption
      .map(n => (n, dists(n)))
}

val sDistances = g.vertices.map(_ -> Int.MaxValue).toMap + ("Mumbai" -> 0)

def shortestPath(step: ShortStep): ShortStep = {
  step.extractMin().map { case (n, currentD) =>
    val newDists = g.neighboursWtWeights(n).collect {
      case WeightedEdge(m, w) if step.dists.get(m).exists(_ > currentD + w) =>
        m -> (currentD + w)
    }
    val newParents = newDists.map { case (m, _) => m -> n }
    shortestPath(ShortStep(step.parents ++ newParents,
      step.unProcessed - n,
      step.dists ++ newDists))
  }.getOrElse(step)
}

def extractSPaths(node: String, parents: Map[String, String]): List[String] =
  parents.get(node).map(p => node +: extractSPaths(p, parents))
    .getOrElse(List(node))

val result = shortestPath(ShortStep(Map(), g.vertices.toSet, sDistances))
result.dists
g.vertices.foreach(n => println(extractSPaths(n, result.parents).reverse))
