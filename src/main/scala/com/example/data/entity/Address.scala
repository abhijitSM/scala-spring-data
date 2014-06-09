package com.example.data.entity

import javax.persistence.Entity
import scala.beans.BeanProperty

/**
 * Created by abhisingh on 08/06/14.
 */
@Entity
case class Address(@BeanProperty var street: String, @BeanProperty var city: String, @BeanProperty var country: String) extends AbstractEntity {
  def this() = this(null, null, null)
}
