function cake(input) {
    const length = Number(input[0]);
    const width = Number(input[1]);
    let totalPieceOfCakes= length * width;

    let command = input[2];

    let counter = 3;
    while (command !== "STOP") {
        const numberOfPieces = Number(command);
        totalPieceOfCakes -= numberOfPieces;

        if (totalPieceOfCakes < 0) {
            break;
        }

        command = input[counter++];
    }

    if (totalPieceOfCakes >= 0) {
        console.log(`${totalPieceOfCakes} pieces are left.`);
    } else {
        console.log(`No more cake left! You need ${Math.abs(totalPieceOfCakes)} pieces more.`);
    }
}