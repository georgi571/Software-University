function numberDivisibleBy9(start, end) {
    let sum = 0;

    for (let i = start; i <= end; i++) {
        if (i % 9 === 0) {
            sum += i;
        }
    }

    console.log(`The sum: ${sum}`);

    for (let i = start; i <= end; i++) {
        if (i % 9 === 0) {
            console.log(`${i}`);
        }
    }
}