package com.packt.demo.section6

import scala.collection.immutable.Queue


object FlowNetwork {
  val vertices = List("S", "A", "B", "C", "D", "T")

  val g = Vector(
    /*    S  A  B  C  D  T */
    /*S*/ 0, 4, 8, 0, 0, 0,
    /*A*/ 0, 0, 0, 6, 0, 0,
    /*B*/ 0, 3, 0, 6, 2, 0,
    /*C*/ 0, 0, 0, 0, 3, 11,
    /*D*/ 0, 0, 0, 0, 0, 2,
    /*T*/ 0, 0, 0, 0, 0, 0)

  val n: Int = vertices.size

  def neighbours(graph: Vector[Int], u: Int): Vector[Int] = graph.slice(u * n, u * n + n)

  def edgeAt(graph: Vector[Int], u: Int, v: Int): Int = graph(u * n + v)

  def update(graph: Vector[Int], u: Int, v: Int, w: Int):Vector[Int] = graph.updated(u * n + v, w)

  private def buildPath(child: Int, parents: Map[Int, Int]): List[(Int, Int)] = {
    parents.get(child).map(p => (p, child) +: buildPath(p, parents))
      .getOrElse(Nil)
  }

  def findPathBFS(s: Int, t: Int, graph: Vector[Int]): List[(Int, Int)] = {
    val sq = Stream.iterate((Queue(s), Set(s), Map[Int, Int]())) {
      case (q, visited, parents) =>
        val (vertex, tail) = q.dequeue
        val nbours = neighbours(graph, vertex).zipWithIndex
          .collect { case (f, id) if f > 0 => id }.toSet -- visited
        val newQueue = tail ++ nbours
        val newVisited = nbours ++ visited
        val newParents = parents ++ nbours.map(_ -> vertex)
        (newQueue, newVisited, newParents)
    }
    val parentsMap = sq.takeWhile(q => q._1.nonEmpty).last._3
    buildPath(t, parentsMap).reverse
  }
}
