package pl.rawie

package object puzzlers {
  def deduplicate(xs: List[Any]): List[Any] = {
    def deduplicate(xs: List[Any], ys: List[Any]): List[Any] = xs match {
      case x :: rest if ys contains x => deduplicate(rest, ys)
      case x :: rest => deduplicate(rest, x :: ys)
      case Nil => ys
    }
    deduplicate(xs, Nil).reverse
  }

  def change(coins: List[Int], amount: Int): List[List[Int]] = {
    if (amount == 0) List(List.fill(coins.size)(0))
    else coins match {
      case c :: rest => {
        for (i <- 0 to amount / c;
          ch <- change(rest, amount - i * c)
        ) yield i :: ch
      }.toList
      case Nil => Nil
    }
  }
}
