package products

import akka.actor.Actor
import products.db.FakeDb
import products.messages.{GetProductById, GetProducts}

class ProductDbReaderActor extends Actor {

  override def receive: Receive = {
    case msg: GetProductById => sender() ! getProductById(msg.id)
    case msg: GetProducts => sender() ! getProducts()
  }

  private def getProductById(id: Int) = {
    FakeDb.Products.filter(_.id == id).head
  }

  private def getProducts() = {
    FakeDb.Products
  }
}
