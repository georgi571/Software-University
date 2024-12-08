function traveling(input) {
    let command = input[0];

    let index = 1;
    while (command !== "End") {
        const name = command;
        const neededSum = Number(input[index++]);

        let currentSum = 0.0;

        while (currentSum < neededSum) {
            const money = Number(input[index++]);
            currentSum += money;
        }

        console.log(`Going to ${name}!`);

        command = input[index++];
    }
}