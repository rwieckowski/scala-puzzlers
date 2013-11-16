package pl.rawie.puzzlers

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FlatSpec

class OverlapSpec extends FlatSpec with ShouldMatchers {
  "overlap" should "return true for Nil" in {
    overlap(Nil) should equal(true)
  }

  it should "return true for one rect" in {
    overlap(List(Rect(0, 0, 1, 1))) should equal(true)
  }

  it should "return true when R0 contains top-left corner of R1" in {
    overlap(List(Rect(0, 0, 2, 2), Rect(1, 1, 2, 2))) should equal(true)
  }

  it should "return true when R0 contains top-right corner of R1" in {
    overlap(List(Rect(0, 0, 2, 2), Rect(-1, 1, 2, 2))) should equal(true)
  }

  it should "return true when R0 contains bottom-left corner of R1" in {
    overlap(List(Rect(0, 0, 2, 2), Rect(1, -1, 2, 2))) should equal(true)
  }

  it should "return true when R0 contains bottom-right corner of R1" in {
    overlap(List(Rect(0, 0, 2, 2), Rect(-1, -1, 2, 2))) should equal(true)
  }

  it should "return false when R0 does not overlap R1" in {
    overlap(List(Rect(0, 0, 2, 2), Rect(3, 3, 2, 2))) should equal(false)
  }

  it should "return false when R1 does not overlap R2" in {
    overlap(List(Rect(0, 0, 2, 2), Rect(0, 2, 1, 1), Rect(2, 0, 1, 1))) should equal(false)
  }
}
