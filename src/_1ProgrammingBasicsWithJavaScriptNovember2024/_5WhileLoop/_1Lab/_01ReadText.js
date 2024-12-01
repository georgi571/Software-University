function readText(input) {
    let word = input[0];
    let counter = 1;
    while (word !== "Stop") {
        console.log(`${word}`);

        word = input[counter++];
    }
}