package users

import scala.concurrent.duration._
import akka.actor.{ActorSystem, Props}
import akka.pattern.ask
import akka.testkit.TestKit
import akka.util.Timeout
import org.scalatest.{AsyncFunSpecLike, FunSpecLike}
import users.messages.GetUserById
import users.model.User

class UserActorTests extends TestKit(ActorSystem("ProductActorTests")) with AsyncFunSpecLike {
  implicit val timeout: Timeout = 10 seconds

  describe("A UserActor sent a GetUserById request") {
    it("responds with the correct user") {
      val userActor = system.actorOf(Props(new UserActor()))
      val request = GetUserById(1)

      val response = (userActor ? request).mapTo[User]

      response.map(r => assert(r.email == "gary.oldman@example.com"))
    }
  }
}
