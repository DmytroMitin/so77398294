import scala.language.experimental.macros
import scala.reflect.macros.whitebox

class TupleProvider[T <: Product] {
  type Repr
  def provide(t: T): Repr = ???
}

object TupleProvider {
  type Aux[T <: Product, R] = TupleProvider[T] {type Repr = R}
  def apply[T <: Product](implicit tp: TupleProvider[T]): Aux[T, tp.Repr] = tp
  implicit def materialize[T, R]: Aux[T, R] = macro TypeProviderMacros.repr1[T, R]

  def instance[T <: Product, R <: Product]: Aux[T, R] = new TupleProvider[T] { type Repr = R }
}

class TypeProviderMacros(val c: whitebox.Context) {
  import c.universe._
  def repr1[T: WeakTypeTag, R: WeakTypeTag] = {
    q"TupleProvider.instance[${weakTypeOf[T]}, ${typeOf[Tuple2[String, Int]]}]"
  }
}