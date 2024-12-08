function sumOfTwoNumbers(firstNumber, secondNumber, magicNumber) {
    let counter = 0;
    for (let i = firstNumber; i <= secondNumber; i++) {
        for (let j = firstNumber; j <= secondNumber; j++) {
            const sum = i + j;
            counter++;
            if (sum === magicNumber) {
                console.log(`Combination N:${counter} (${i} + ${j} = ${sum})`);
                return;
            }
        }
    }

    console.log(`${counter} combinations - neither equals ${magicNumber}`);
}