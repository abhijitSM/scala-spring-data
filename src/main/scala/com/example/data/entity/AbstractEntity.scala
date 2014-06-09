package com.example.data.entity

import javax.persistence.{GenerationType, GeneratedValue, Id, MappedSuperclass}
import scala.beans.BeanProperty

/**
 * Created by abhisingh on 08/06/14.
 */

@MappedSuperclass
trait AbstractEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @BeanProperty
  var id: Long = _
}
