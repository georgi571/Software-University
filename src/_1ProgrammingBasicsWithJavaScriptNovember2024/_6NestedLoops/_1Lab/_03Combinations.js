function combination(number) {
    let count = 0;
    for (let i = 0; i <= number; i++) {
        for (let j = 0; j <= number; j++) {
            for (let k = 0; k <= number; k++) {
                if (i + j + k === number) {
                    count++;
                    break;
                }
            }
        }
    }

    console.log(`${count}`);
}