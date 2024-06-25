function solve(number1, operator, number2) {
    let result;
    if (operator === '+') {
        result = number1 + number2;
    } else if (operator === '-') {
        result = number1 - number2;
    } else if (operator === '/') {
        result = number1 / number2;
    } else if (operator === '*') {
        result = number1 * number2;
    }
    console.log(result.toFixed(2))
}