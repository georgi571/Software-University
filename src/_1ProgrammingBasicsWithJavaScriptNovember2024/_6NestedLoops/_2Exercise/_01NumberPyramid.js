function numberPyramid(number) {
    let currentNumber = 1;

    for (let row = 1; row <= number; row++) {
        let output = "";
        for (let col = 1; col <= row; col++) {
            output += currentNumber++ + " ";
            if (currentNumber > number) {
                console.log(`${output}`);
                return;
            }
        }
        console.log(`${output}`);
    }
}