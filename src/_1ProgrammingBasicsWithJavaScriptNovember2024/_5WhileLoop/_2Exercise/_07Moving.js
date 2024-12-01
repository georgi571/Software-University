function moving(input) {
    const length = Number(input[0]);
    const width = Number(input[1]);
    const height = Number(input[2]);
    let totalCubicCm= length * width * height;

    let command = input[3];

    let counter = 4;
    while (command !== "Done") {
        const sizeOfBox = Number(command);
        totalCubicCm -= sizeOfBox;

        if (totalCubicCm < 0) {
            break;
        }

        command = input[counter++];
    }

    if (totalCubicCm >= 0) {
        console.log(`${totalCubicCm} Cubic meters left.`);
    } else {
        console.log(`No more free space! You need ${Math.abs(totalCubicCm)} Cubic meters more.`);
    }
}