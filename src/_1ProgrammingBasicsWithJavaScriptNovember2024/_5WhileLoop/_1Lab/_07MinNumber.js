function minNumber(input) {
    let command = input[0];
    let smallestNumber = Number.MAX_SAFE_INTEGER;

    let counter = 1;
    while (command !== "Stop") {
        const number = Number(command);

        if (number < smallestNumber) {
            smallestNumber = number;
        }

        command = input[counter++];
    }

    console.log(`${smallestNumber}`);
}