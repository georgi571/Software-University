function signCheck(firstNumber, secondNumber, thirdNumber) {
    const isNegative = num => num < 0;
    const negatives = [isNegative(firstNumber), isNegative(secondNumber), isNegative(thirdNumber)];
    const negativeCount = negatives.filter(Boolean).length;
    if (negativeCount % 2 === 0) {
        console.log('Positive');
    } else {
        console.log('Negative');
    }
}
