import com.packt.demo.section3.GameGraph.g

//GAME -> 5, MATH -> 1 ...

val zeroMap = g.vertices.map(n => n -> 0).toMap

val inDegreeMap = zeroMap ++ g.edges.groupBy(e => e._2)
.map{case (n, eList) => n -> eList.size}

val startNodes = inDegreeMap.filter(_._2 == 0).keys.toList

def topologicalSort(sNodes:List[String],
                    inDegMap:Map[String, Int]):List[String] = {
  sNodes.headOption.map { s =>
    val nodeMs = g.neighbours(s)
    val newMCounts = nodeMs.map(n => n -> (inDegMap(n) - 1)).toMap
    val newSNodes = sNodes.tail ::: nodeMs.filter(newMCounts(_) == 0)
    s +: topologicalSort(newSNodes, inDegMap ++ newMCounts)
  }.getOrElse(Nil)
}


topologicalSort(startNodes, inDegreeMap)