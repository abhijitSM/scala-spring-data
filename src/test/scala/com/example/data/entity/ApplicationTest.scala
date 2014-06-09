package com.example.data.entity

import org.specs2.mutable.{BeforeAfter, Specification}
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import com.example.data.AppConfig
import scala.collection.JavaConversions._
import org.specs2.execute.Failure
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import org.junit.runners.JUnit4
import com.example.data.datastore.CustomerRepository

/**
 * Created by abhisingh on 08/06/14.
 */

class ApplicationTest extends Specification with BeforeAfter {

  var ctx: AnnotationConfigApplicationContext = _

  "Application" should {

    "persist customer entity " in {
      var customer = Customer("Abhijit", "Singh", "abhijit.singh@edifecs.com")
      val address = Address("1st", "mohali", "india")
      customer.setAddresses(Set(address))
      val custDAO = ctx.getBean(classOf[CustomerRepository])
      custDAO must_!= (null)

      customer = custDAO.save(customer)
      customer.getId must_!= (null)
    }
  }

  override def after: Any = {
    //    ctx.close()
  }

  override def before: Any = {
    ctx = new AnnotationConfigApplicationContext(classOf[AppConfig])
    println(s"context init complete $ctx")
    ctx must_!= null
  }
}
