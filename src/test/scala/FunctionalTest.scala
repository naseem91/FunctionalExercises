object FunctionalTest {

  import FunctionalExamples._

  def main(args: Array[String]): Unit = {
    //Call function before update somevar variable when somVar =0
    println(deterministicButSideeffects(8))
    someVar = 2
    //Call function before update somevar variable when somVar =2
    println(deterministicButSideeffects(8))

    //First call
    println(nonDeterministicNoeffects(8))
    //Second call
    println(nonDeterministicNoeffects(8))

    //Total Divide function
    val result = divideTotal(3,-1,1) match {
      case None => println("divide by zero")
      case Some(result)=> println(result)
    }

    //drop the 2nd index element
    println(dropNthElementOnList(2,List(1,2,5)))

    //find 5 randoms in range 40-100
    println(drawNrandomNumbers(5,40,100))

    //Checks if 5 is prime
    println(isPrime(5))

    //Gets all prime numbers from (1,2)
    println(findListOfprime(1,10))
  }
}
