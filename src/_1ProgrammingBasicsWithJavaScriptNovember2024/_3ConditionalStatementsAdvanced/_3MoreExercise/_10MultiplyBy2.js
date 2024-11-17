function multiplyBy2(numbers) {
    let index = 0;
    let number = Number(numbers[index]);
    while (number >= 0) {
        const result = number * 2;
        console.log(`Result: ${result.toFixed(2)}`);
        index++;
        number = Number(numbers[index]);
    }
    console.log(`Negative number!`);
}