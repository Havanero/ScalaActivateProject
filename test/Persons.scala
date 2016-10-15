/**
  * Developed by:    cubanguy 
  * Date:            19.09.16
  * Project:         ScalaActivateProject
  */
case class Persons(var name: String, var address: String, var sex: String, var DOB: String, var CountryOfOrigin: String) {


  override def toString = {
    "Name: %s Address: %s Sex:%s DOB:%s CountryOfOrigin:%s ".format(name, address, sex, DOB, CountryOfOrigin)
  }


}
