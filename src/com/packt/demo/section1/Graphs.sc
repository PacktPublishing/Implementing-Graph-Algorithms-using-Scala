import com.packt.demo.section1.Graph

val g = Graph[String]()
  .addEdge("London", "Lisbon")
  .addEdge("Lisbon", "Madrid")
  .addEdge("Madrid", "London")
  .addEdge("Madrid", "Rome")
  .addEdge("Rome", "London")
  .addEdge("Paris", "Rome")









g.vertices
g.neighbours("Madrid")


