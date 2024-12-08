function specialNumbers(number) {
    let output = "";
    for (let i = 1111; i <= 9999; i++) {
        let divider = i;

        let isSpecial = true;

        while (divider > 0) {
            const digit = divider % 10;

            if (digit === 0  || number % digit !== 0) {
                isSpecial = false;
                break;
            }

            divider = Math.floor(divider / 10);
        }

        if (isSpecial) {
            output += i + " ";
        }
    }
    console.log(`${output}`);
}