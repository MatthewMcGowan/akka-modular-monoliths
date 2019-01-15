package products.db

import products.model.Product

object FakeDb {
  val Products: Seq[Product] = Seq(
    Product(1, "HDMI Cable"),
    Product(2, "Pen")
  )
}
