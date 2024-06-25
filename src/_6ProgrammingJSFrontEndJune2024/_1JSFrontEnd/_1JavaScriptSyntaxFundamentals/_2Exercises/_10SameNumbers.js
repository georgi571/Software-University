function solve(number) {
    let isAllSame = true;
    let sum = 0;
    let firstNumber;
    while (number > 0) {
        let lastDigit = number % 10;
        if (firstNumber === undefined) {
            firstNumber = lastDigit;
        }
        number -= lastDigit;
        number /= 10;
        sum += lastDigit;
        if (lastDigit !== firstNumber && isAllSame) {
            isAllSame = false;
        }
    }
    console.log(isAllSame);
    console.log(sum);
}