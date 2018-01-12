package nexus.optimizer

import nexus._

/**
 * @author Tongfei Chen
 */
abstract class TwoStepFirstOrderOptimizer {

  protected var t = 0

  def iteration = t

  def updateParamStep1[X](px: Param[X], x: X): Unit
  def updateParamStep2[X](px: Param[X], x: X): Unit

  def updateStep1(gradients: ExprValueMap): Unit = {
    t += 1
    for (item <- gradients) {
      item.expr match {
        case param: Param[item.Data] =>
          updateParamStep1(param, item.value)
        case _ =>
      }
    }
  }

  def updateStep2(gradients: ExprValueMap): Unit = {
    for (item <- gradients) {
      item.expr match {
        case param: Param[item.Data] =>
          updateParamStep2(param, item.value)
        case _ =>
      }
    }
  }

}
