function uniquePinCodes(first, second, third) {
    for (let i = 2; i <= first; i+=2) {
        for (let j = 1; j <= second; j++) {
            if (j === 2 || j === 3 || j === 5 || j === 7) {
                for (let k = 2; k <= third; k+=2) {
                    console.log(`${i} ${j} ${k}`);
                }
            }
        }
    }
}