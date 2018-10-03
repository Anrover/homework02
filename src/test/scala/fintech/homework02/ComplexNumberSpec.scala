package fintech.homework02
import org.scalatest.{FlatSpec, Matchers}

class ComplexNumberSpec extends FlatSpec with Matchers {
  "A ComplexNumber" should "correctly compare" in
  {
    val complexNumber1 = new ComplexNumber(7, 3)
    val complexNumber2 = new ComplexNumber(7.0, 3)
    val complexNumber3 = new ComplexNumber(7, 3.0)
    val complexNumber4 = new ComplexNumber(5, 5)

    complexNumber1 == complexNumber4 should be (false)
    complexNumber1 == complexNumber3 should be (true)
    complexNumber2 == complexNumber3 should be (true)
    complexNumber1 == complexNumber3 should be (true)
    complexNumber2 == complexNumber2 should be (true)
    complexNumber1 == null should be (false)
  }
  it should "correctly multiply" in
  {

    val complexNumber1 = new ComplexNumber(7, 3)
    val complexNumber2 = new ComplexNumber(5, -8)
    val complexNumber3 = new ComplexNumber(-10, -4)
    val complexNumber4 = new ComplexNumber(8, 1)
    val complexNumber5 = new ComplexNumber(0, 0)

    complexNumber1 * complexNumber2 should be (new ComplexNumber(59, -41))
    complexNumber3 * complexNumber4 should be (new ComplexNumber(-76, -42))
    complexNumber1 * complexNumber5 should be (new ComplexNumber(0, 0))
  }
  it should "correctly add" in
  {
    val complexNumber1 = new ComplexNumber(5, -6)
    val complexNumber2 = new ComplexNumber(-3, 2)
    val complexNumber3 = new ComplexNumber(0, 0)

    complexNumber1 + complexNumber2 should be (new ComplexNumber(2, -4))
    complexNumber1 + complexNumber3 should be (complexNumber1)
  }
  it should "correctly raised to a power" in
  {
    val complexNumber = new ComplexNumber(0.5, Math.sqrt(3)/2)
    val power: Int = 20
    val correctResult = new ComplexNumber(-0.5, Math.sqrt(3)/2)
    val calculationError = 0.000000001
    val result = complexNumber~power
    (result.real - correctResult.real).abs should be < calculationError
    (result.imag - correctResult.imag).abs should be < calculationError
  }
  it should "correctly displayed" in
  {
    val complexNumber = new ComplexNumber(7, 3)
    complexNumber.toString should be ("Complex(7.0, 3.0i)")
    complexNumber.toString should not be "Complex(7, 3.0i)"
  }
}
