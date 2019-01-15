package products

import akka.actor.{Actor, Props}
import akka.routing.RoundRobinPool
import products.messages.{DoSomethingElse, ProductGet}

class ProductActor extends Actor {
//  val dbReader = context.actorOf(Props(new ProductDbReaderActor()))
  val dbReader = context.actorOf(RoundRobinPool(5).props(Props(new ProductDbReaderActor())))

  override def receive: Receive = {
    case msg: ProductGet => dbReader.forward(msg)
    case msg: DoSomethingElse => otherThing()
  }

  private def otherThing() = {
    ???
  }
}
