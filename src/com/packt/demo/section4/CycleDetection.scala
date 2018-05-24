package com.packt.demo.section4

import com.packt.demo.section1.Graph

case class DfsCycleResult[V](visited: Set[V], isCyclic: Boolean = false)

object CycleDetection {

  def containsCycleDfs[V](vertex: V, graph: Graph[V],
                          visited: Set[V] = Set[V](),
                          ancestors: Set[V] = Set[V]()): DfsCycleResult[V] = {
    if (ancestors.contains(vertex)) DfsCycleResult(visited, isCyclic = true)
    else if (visited.contains(vertex)) DfsCycleResult(visited)
    else
      graph.neighbours(vertex).foldLeft(DfsCycleResult(visited + vertex)) {
        case (DfsCycleResult(v, true), _) => DfsCycleResult(v, isCyclic = true)
        case (currentRes, n) => containsCycleDfs(n, graph, currentRes.visited, ancestors + vertex)
      }
  }

  def containsCycleDfs[V](graph:Graph[V]):Boolean = {
    val startNodes = graph.vertices.filter(v => graph.edges.forall(e => e._2 != v))
    startNodes.isEmpty || startNodes.exists(n =>
      CycleDetection.containsCycleDfs(n, graph).isCyclic)
  }
}
