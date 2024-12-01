function maxNumber(input) {
    let command = input[0];
    let highestNumber = Number.MIN_SAFE_INTEGER;

    let counter = 1;
    while (command !== "Stop") {
        const number = Number(command);

        if (number > highestNumber) {
            highestNumber = number;
        }

        command = input[counter++];
    }

    console.log(`${highestNumber}`);
}