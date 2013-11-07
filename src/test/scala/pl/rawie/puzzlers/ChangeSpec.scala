package pl.rawie.puzzlers

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FlatSpec

class ChangeSpec extends FlatSpec with ShouldMatchers {
  "change" should "return Nil when no coins" in {
    change(Nil, 10) should equal(Nil)
  }

  it should "return List(Vector(0)) for coins List(x) and amount 0" in {
    change(List(1), 0) should equal(List(List(0)))
  }

  it should "return List(Vector(1)) for coins List(x) and amount x" in {
    change(List(1), 1) should equal(List(List(1)))
  }

  it should "return List(Vector(n)) for coins List(x) and amount x * n" in {
    change(List(1), 10) should equal(List(List(10)))
  }

  it should "return List() for coins List(2*x) and amount x" in {
    change(List(2), 1) should equal(List())
  }

  it should "return changes for coins List(1, 2) and amount 4" in {
    change(List(1, 2), 4) should equal(List(List(0, 2), List(2, 1), List(4, 0)))
  }

  it should "return changes for coins List(1, 5, 10, 15) and small amount" in {
    change(List(1, 5, 10, 15), 100).size should equal(358)
  }

  it should "return changes for coins List(1) and large amount" in {
    change(List(1, 2), 100).size should equal(51)
  }
}
