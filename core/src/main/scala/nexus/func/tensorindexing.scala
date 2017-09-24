package nexus.func

import nexus._
import nexus.algebra._
import nexus.algebra.typelevel._
import shapeless._

@implicitNotFound("Cannot apply WrapScalar to ${X}.")
trait WrapScalarF[X, Y] extends DOp1[X, Y] {
  def name = "WrapScalar"
}

object WrapScalarF {

  implicit def scalar[T[_ <: $$], R](implicit T: IsTypedRealTensor[T, R]): WrapScalarF[R, T[$]] =
    new WrapScalarF[R, T[$]] {
      def tag = T.ground[$]
      def backward(dy: T[$], y: T[$], x: R) = T.unwrapScalar(dy)
      def forward(x: R) = T.wrapScalar(x)
    }

}


@implicitNotFound("Cannot apply UnwrapScalar to ${X}.")
trait UnwrapScalarF[X, Y] extends DOp1[X, Y] {
  def name = "UnwrapScalar"
}

object UnwrapScalarF {

  implicit def scalar[T[_ <: $$], R](implicit T: IsTypedRealTensor[T, R]): UnwrapScalarF[T[$], R] =
    new UnwrapScalarF[T[$], R] {
      def tag = T.R
      def backward(dy: R, y: R, x: T[$]) = T.wrapScalar(dy)
      def forward(x: T[$]) = T.unwrapScalar(x)
    }

}


trait OneHotF[P, X, Y] extends (P => Op1[X, Y])

object OneHotF {

  //implicit def tensor[TI[_ <: $$], TR[_ <: $$], A <: $$, U] = new OneHotF[U, TI[A], TR[A::U::$]]

}


trait SliceAlongF[P, X, Y] extends (P => DOp1[X, Y])

object SliceAlongF {

  implicit def tensor[T[_ <: $$], R, A <: $$, U, N <: Nat, B <: $$]
  (implicit T: IsTypedRealTensor[T, R], ui: IndexOf.Aux[A, U, N], ur: RemoveAt.Aux[A, N, B]) = new SliceAlongF[(U, Int), T[A], T[B]] {
    def apply(p: (U, Int)) = new DOp1[T[A], T[B]] {
      import T._
      def tag = T.ground[B]
      val (axis, i) = p
      def name = s"SliceAlong[${axis.getClass.getSimpleName}->$i]"
      def forward(x: T[A]) = ???
      def backward(dy: T[B], y: T[B], x: T[A]) = ???
    }
  }
}