function operationsBetweenNumbers(firstNumber, secondNumber, operation) {
    if (operation === '+' || operation === '-' || operation === '*') {
        let result = 0;
        let evenOrOdd = "";
        if (operation === '+') {
            result = firstNumber + secondNumber;
        } else if (operation === '-') {
            result = firstNumber - secondNumber;
        } else if (operation === '*') {
            result = firstNumber * secondNumber;
        }
        if (result % 2 === 0) {
            evenOrOdd = "even";
        } else {
            evenOrOdd = "odd";
        }
        console.log(`${firstNumber} ${operation} ${secondNumber} = ${result} - ${evenOrOdd}`);
    } else if (operation === '/') {
        if (secondNumber === 0) {
            console.log(`Cannot divide ${firstNumber} by zero`);
        } else {
            const result = 1.0 * firstNumber / secondNumber;
            console.log(`${firstNumber} ${operation} ${secondNumber} = ${result.toFixed(2)}`);
        }
    } else if (operation === '%') {
        if (secondNumber === 0) {
            console.log(`Cannot divide ${firstNumber} by zero`);
        } else {
            const result = firstNumber % secondNumber;
            console.log(`${firstNumber} ${operation} ${secondNumber} = ${result}`);
        }
    }
}