package users

import akka.actor.{Actor, Props}
import users.db.FakeDb
import users.messages.GetUserById

class UserActor extends Actor {

  override def receive: Receive = {
    case msg: GetUserById => sender() ! getUserById(msg.id)
  }

  private def getUserById(id: Int) = {
    FakeDb.Users.filter(u => u.id == id).head
  }
}
