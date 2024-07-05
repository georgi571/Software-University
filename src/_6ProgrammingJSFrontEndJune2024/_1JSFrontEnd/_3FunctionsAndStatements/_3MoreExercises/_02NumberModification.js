function numberModification(number) {
    let numbers = number.toString().split('').map(Number);
    while (true) {
        const average = averageNumbers(numbers);
        if (average > 5) {
            break;
        }
        numbers.push(9);
    }
    console.log(numbers.join(''));

    function averageNumbers(numbers) {
        let sum = 0;
        for (let number of numbers) {
            sum += number;
        }
        return sum / numbers.length;
    }
}