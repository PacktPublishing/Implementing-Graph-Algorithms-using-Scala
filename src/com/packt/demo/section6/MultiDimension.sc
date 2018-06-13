val arr = Array.ofDim[Int](2, 2)
arr(0)(1) = 10
arr(0)(1)

val vec1 = Vector.fill(2, 2)(10)
val vec2 = Vector.tabulate(2, 2)((i, j) => i + j)

vec2(1)(1)
//vec2(1)(1) = 10

vec2.updated(1, vec2(1).updated(1, 10))

val matrix = Vector(
  /*    A  B*/
  /*A*/ 0, 1,
  /*B*/ 2, 3
)

val n = 2

val (u, v) = (1, 1)

matrix(u * n + v)
matrix.updated(u * n + v, 10)
matrix.slice(u * n, u * n + n)

import com.packt.demo.section6.FlowNetwork._
val a = vertices.indexOf("A")
val c = vertices.indexOf("C")

edgeAt(g, a, c)
neighbours(g, a)
update(g, a, c, 10)
