package com.example.data.datastore

import org.springframework.data.repository.CrudRepository
import com.example.data.entity.Customer
import java.lang.Long

/**
 * Created by abhisingh on 09/06/14.
 */
trait CustomerRepository extends CrudRepository[Customer, Long] {

}
