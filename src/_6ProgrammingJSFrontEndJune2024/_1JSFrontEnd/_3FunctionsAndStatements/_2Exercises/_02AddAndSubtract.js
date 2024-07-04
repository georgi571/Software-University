function addAndSubtract(firstNumber, secondNumber, thirdNumber) {

    console.log(subtract(add, thirdNumber));

    function add(firstNumber, secondNumber) {
        return firstNumber + secondNumber;
    }

    function subtract(add, thirdNumber) {
        return add(firstNumber, secondNumber) - thirdNumber;
    }
}