package com.packt.demo.section4

import com.packt.demo.section1.Graph

object CircularBufferDetection {

  private def moveOnce[V](stack: List[V], graph: Graph[V]): List[V] =
    stack.headOption.map(v => graph.neighbours(v) ++ stack.tail).getOrElse(Nil)

  def containsCycleFloyd[V](startVertex: V, graph: Graph[V]): Boolean = {
    val tortoise = Stream.iterate(List(startVertex))(vList => moveOnce(vList, graph))
      .map(_.headOption)
    val hare = Stream.iterate(List(startVertex))(vList => moveOnce(moveOnce(vList, graph), graph))
      .map(_.headOption)

    val hareVsTortoise = hare.tail.zip(tortoise.tail)
    val endOfRace = hareVsTortoise.takeWhile { case (h, t) => h.isDefined && h != t }.size
    val result = hareVsTortoise(endOfRace)

    result._1.isDefined && result._1 == result._2
  }
}
