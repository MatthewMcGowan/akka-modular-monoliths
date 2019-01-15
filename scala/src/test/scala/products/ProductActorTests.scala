package products


import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

import akka.actor.{ActorSystem, Props}
import akka.pattern.ask
import akka.testkit.TestKit
import akka.util.Timeout
import org.scalatest.FunSpecLike
import products.messages.GetProductById
import products.model.Product


class ProductActorTests extends TestKit(ActorSystem("ProductActorTests")) with FunSpecLike {
  implicit val timeout: Timeout = 10 seconds

  describe("A UserActor sent a GetUserById request") {
    it("responds with the correct user") {
      val userActor = system.actorOf(Props(new ProductActor()))
      val request = GetProductById(1)

      val response = (userActor ? request).mapTo[Product]

      response.foreach(r => assert(r.name == "HDMI Cable"))
    }
  }
}