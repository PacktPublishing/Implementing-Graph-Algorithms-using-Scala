package com.packt.demo.section5

import com.packt.demo.section1.{WeightedEdge, WeightedGraph}

object TravelGraph {
  val g = new WeightedGraph(Map("Mumbai" -> Nil))
    .addEdge("Mumbai", WeightedEdge("Goa", 60))
    .addEdge("Mumbai", WeightedEdge("Colombo", 160))
    .addEdge("Mumbai", WeightedEdge("Dubai", 170))
    .addEdge("Mumbai", WeightedEdge("Jammu", 50))
    .addEdge("Mumbai", WeightedEdge("Bangkok", 250))
    .addEdge("Mumbai", WeightedEdge("Dhaka", 360))
    .addEdge("Goa", WeightedEdge("Chennai", 20))
    .addEdge("Chennai", WeightedEdge("Colombo", 40))
    .addEdge("Colombo", WeightedEdge("Bangkok", 210))
    .addEdge("Dubai", WeightedEdge("Singapore", 320))
    .addEdge("Singapore", WeightedEdge("Bangkok", 210))
    .addEdge("Bangkok", WeightedEdge("Singapore", 260))
    .addEdge("Bangkok", WeightedEdge("Dhaka", 90))
    .addEdge("Dhaka", WeightedEdge("Bangkok", 140))
    .addEdge("Jammu", WeightedEdge("Dubai", 110))
    .addEdge("Jammu", WeightedEdge("Kathmandu", 190))
    .addEdge("Kathmandu", WeightedEdge("Jammu", 160))
    .addEdge("Kathmandu", WeightedEdge("Dhaka", 90))
}
