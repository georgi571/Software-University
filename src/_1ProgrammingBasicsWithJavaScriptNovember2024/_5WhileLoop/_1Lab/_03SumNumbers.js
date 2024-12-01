function sumNumbers(input) {
    const number = input[0];
    let sum = 0;

    let counter = 1;
    while (sum < number) {
        const current = Number(input[counter++]);

        sum += current;
    }
    console.log(`${sum}`);
}