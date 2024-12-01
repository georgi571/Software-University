function sequence2kPlus1(number) {
    let k = 1;

    while (k <= number) {
        console.log(`${k}`);

        k = (k * 2) + 1;
    }
}