object App {
  case class Foo(x: Int, y: String)
  val p:  TupleProvider.Aux[Foo, (String, Int)] = TupleProvider[Foo]
}
