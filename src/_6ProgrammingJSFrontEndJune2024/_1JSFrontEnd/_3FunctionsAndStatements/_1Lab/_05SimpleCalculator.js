function simpleCalculator(firstNumber, secondNumber, operator) {
    const operators = ['multiply', 'divide', 'add', 'subtract'];
    const functions = [(a, b) => a * b, (a, b) => a / b, (a, b) => a + b, (a, b) => a - b];
    const index = operators.indexOf(operator);
    console.log(functions[index](firstNumber, secondNumber));
}