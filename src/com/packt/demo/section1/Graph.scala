package com.packt.demo.section1

trait Graph[V] {

  def vertices: List[V]

  def edges: List[(V, V)]

  def addEdge(a: V, b: V): Graph[V]

  def neighbours(vertex: V): List[V]
}

object Graph {
  def apply[V](adjList:Map[V, List[V]]): Graph[V] = new DirectedGraph(adjList)

  def apply[V](): Graph[V] = new DirectedGraph(Map[V, List[V]]())
}