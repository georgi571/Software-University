function oddAndEvenSum (number) {
    const sumEven = sum(number.toString().split('').map(Number).filter(a => a % 2 === 0));
    const sumOdd = sum(number.toString().split('').map(Number).filter(a => a % 2 === 1));

    console.log(`Odd sum = ${sumOdd}, Even sum = ${sumEven}`);

    function sum(numbers) {
        let result = 0;
        for (let number of numbers) {
            result += number;
        }
        return result;
    }
}