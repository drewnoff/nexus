package nexus.op

import nexus._
import nexus.algebra._
import shapeless.ops.hlist.Remove

/**
 * Computes the sum along a specific axis of a given tensor.
 * @author Tongfei Chen
 * @since 0.1.0
 */
case class SumAlong[U](parameter: U) extends ParaPolyDOp1[U, SumAlongF]
