import scala.util.Try

object FunctionalExamples {

  //Pure:Output depends on input,no side effect{mutating variables, or performing some sort of I/O}
  //deterministic:
  //Total:
  def add(a:Int ,b:Int) = a+b

  var someVar = 0
  //Total,Deterministic and impure
  def deterministicButSideeffects(parm:Int):Int ={
    println("Sideeffect") // side effect here
    someVar = parm  //another side effect
    parm // it depends only on the parm (input)
  }

  //Total ,Non Deterministic and pure
  def nonDeterministicNoeffects(parm :Int): Int ={
    parm + scala.util.Random.nextInt()
  }

  //Deterministic and pure but not total {because divide by zero}
  def divide(a:Int , b:Int , c:Int):Int ={
    a / (b+c)
  }

  //Total ,Deterministic and Pure
  def divideTotal(a:Int ,b:Int ,c:Int):Option[Int]={
    Try(a/(b+c)).toOption
  }

  //Total ,Deterministic and impure {mutate list}
  def dropNthElementOnList(nth:Int , list :List[Int]):List[Int] ={
    var newList:List[Int]=Nil
    for(x <- 1 to list.length)
        if(x == nth)
           newList=list.filterNot(list.drop(nth).contains(_))
    newList
  }

  //Total , Non Deterministic and impure
  def drawNrandomNumbers(num:Int,start:Int,end:Int):List[Int]={
    var randoms:List[Int]=Nil
    for(i <- 1 to  num) {
      val rnd = start + scala.util.Random.nextInt((end - start) + 1)
      randoms=rnd ::randoms
    }
   randoms
  }

  //Total ,Deterministic and pure
  def isPrime(num:Int):Boolean ={
    Range(2, num-1).filter(i => num % i == 0).length == 0
  }

  //Total,Deterministic and pure
  def findListOfprime(start:Int ,end:Int):List[Int]={
    Range(start,end).filter(isPrime(_)).toList
  }
}
