package pl.rawie.puzzlers

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FlatSpec

class DeduplicateSpec extends FlatSpec with ShouldMatchers {
  "deduplicate" should "return Nil for Nil" in {
    deduplicate(Nil) should equal(Nil)
  }

  it should "return List(x) for List(x)" in {
    deduplicate(List(1)) should equal(List(1))
  }

  it should "return List(x) for List(x, x)" in {
    deduplicate(List(1, 1)) should equal(List(1))
  }

  it should "return List(x) for List(x, x, x)" in {
    deduplicate(List(1, 1, 1)) should equal(List(1))
  }

  it should "return List(x, y) for List(x, y)" in {
    deduplicate(List(1, 2)) should equal(List(1, 2))
  }

  it should "return List(x, y) for List(x, y, x)" in {
    deduplicate(List(1, 2, 1)) should equal(List(1, 2))
  }

  it should "remove duplicates for small list" in {
    val rs = (1 to 5).toList
    val xs = for (i <- rs; j <- rs) yield i
    deduplicate(xs) should equal(rs)

    val ys = for (i <- rs; j <- rs) yield j
    deduplicate(ys) should equal(rs)

    deduplicate(List('x, 1, "foo", 'x, 1, "foo")) should equal(List('x, 1, "foo"))
  }

  it should "remove duplicates for large list" in {
    val rs = (1 to 100000).toList
    deduplicate(rs) should equal(rs)
  }
}
