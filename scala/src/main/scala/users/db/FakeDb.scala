package users.db

import users.model.User

object FakeDb {
  val Users: Seq[User] = Seq(
    User(1, "gary.oldman@example.com", "Gary", "Oldman"),
    User(2, "jack.nicholson@example.com", "Jack", "Nicholson")
  )
}
