function equalSumsEvenOddPosition(firstNumber, secondNumber) {
    let output = "";
    for (let i = firstNumber; i <= secondNumber; i++) {
        let number = Number(i);
        let oddNumber = 0;
        let evenNumber = 0;

        let counter = 0;
        while (number > 0) {
            const remainder = number % 10;
            if (counter % 2 === 0) {
                evenNumber += remainder;
            } else {
                oddNumber += remainder;
            }
            counter++;

            number = Math.floor(number / 10);
        }

        if (oddNumber === evenNumber) {
            output += i + " ";
        }
    }
    console.log(`${output}`);
}