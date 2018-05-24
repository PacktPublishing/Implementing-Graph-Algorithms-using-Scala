val list0 = List[Int]()
val list1 = List[Int](1,2,3,4,5)

list1.exists(n => n > 3)
list1.forall(n => n > 0)

list0.exists(n => n > 3)
list0.forall(n => n > 3)
