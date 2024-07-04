function smallestOfThreeNumbers(firstNumber, secondNumber, thirdNumber) {
    const numbers = [firstNumber, secondNumber, thirdNumber].sort((a,b) => a - b);
    console.log(numbers[0]);
}