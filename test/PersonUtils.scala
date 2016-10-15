import scala.reflect.runtime.universe._
/**
  * Developed by:    cubanguy 
  * Date:            20.09.16
  * Project:         ScalaActivateProject
  */
case class PersonUtils() {

  def getMethods[T: TypeTag] = typeOf[T].members.collect {
    case m: MethodSymbol if m.isCaseAccessor => m
  }.toList

}
