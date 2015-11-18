package cats
package tests

import cats.laws.discipline.{TraverseTests, FlatMapTests, SerializableTests, MonoidalTests}
import cats.laws.discipline.eq._

class MapTests extends CatsSuite {
  implicit val iso = MonoidalTests.Isomorphisms.covariant[Map[Int, ?]]
  checkAll("Map[Int, Int]", MonoidalTests[Map[Int, ?]].monoidal[Int, Int, Int])
  checkAll("Monoidal[Map[Int, ?]]", SerializableTests.serializable(Monoidal[Map[Int, ?]]))

  checkAll("Map[Int, Int]", FlatMapTests[Map[Int, ?]].flatMap[Int, Int, Int])
  checkAll("FlatMap[Map[Int, ?]]", SerializableTests.serializable(FlatMap[Map[Int, ?]]))

  checkAll("Map[Int, Int] with Option", TraverseTests[Map[Int, ?]].traverse[Int, Int, Int, Int, Option, Option])
  checkAll("Traverse[Map[Int, ?]]", SerializableTests.serializable(Traverse[Map[Int, ?]]))
}
