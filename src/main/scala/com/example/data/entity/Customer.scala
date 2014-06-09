package com.example.data.entity

import javax.persistence.{CascadeType, JoinColumn, OneToMany, Entity}
import scala.beans.BeanProperty
import scala.collection.JavaConversions._

/**
 * Created by abhisingh on 08/06/14.
 */

@Entity
case class Customer(
                     @BeanProperty var firstname: String,
                     @BeanProperty var lastName: String,
                     @BeanProperty var email: String
                     //                     val address_ : Set[Address]
                     ) extends AbstractEntity {

  def this() = this(null, null, null)

  @OneToMany(cascade = Array(CascadeType.ALL))
  @JoinColumn(name = "customer_id")
  @BeanProperty
  var addresses: java.util.Set[Address] = _

}
