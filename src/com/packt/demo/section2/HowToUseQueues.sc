import scala.collection.immutable.Queue

val q = Queue("James", "Ruth", "Isabel")

val newQ = q.enqueue("Vanessa")

val (name, rest) = newQ.dequeue

