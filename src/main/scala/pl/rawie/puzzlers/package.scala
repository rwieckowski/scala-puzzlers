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
}
