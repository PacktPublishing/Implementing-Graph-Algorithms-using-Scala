package com.packt.demo.section1

case class WeightedEdge[V](desitination: V, weight:Int)

class WeightedGraph[V](adjList:Map[V, List[WeightedEdge[V]]]) extends Graph[V]{
  override def vertices: List[V] = adjList.keys.toList

  override def edges: List[(V, V)] = adjList.toList.flatMap { case (v, edgeList) =>
    edgeList.map(e => v -> e.desitination)
  }

  def addEdge(a: V, weightedEdge: WeightedEdge[V]): WeightedGraph[V] = {
    val aNeighbours = weightedEdge +: adjList.getOrElse(a, Nil)
    new WeightedGraph(adjList + (a -> aNeighbours))
  }

  override def addEdge(a: V, b: V): WeightedGraph[V] = addEdge(a, WeightedEdge(b, 0))

  override def neighbours(vertex: V): List[V] = adjList.getOrElse(vertex, Nil).map(_.desitination)

  def neighboursWtWeights(vertex: V): List[WeightedEdge[V]] =
    adjList.getOrElse(vertex, Nil)
}
