function sumOfOddNumbers(number) {
    let currentNumber = 1;
    let sum = 0;
    for (let i = 0; i < number; i++) {
        console.log(currentNumber);
        sum += currentNumber;
        currentNumber += 2;
    }
    console.log(`Sum: ${sum}`);
}