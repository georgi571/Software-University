function multiplyTable(number) {
    const lastDigit = number / 100;
    const secondDigit = (number % 100) / 10;
    const firstDigit = number % 10;
    for (let i = 1; i <= firstDigit ; i++) {
        for (let j = 1; j <= secondDigit ; j++) {
            for (let k = 1; k <= lastDigit; k++) {
                const sum = i * j * k;
                console.log(`${i} * ${j} * ${k} = ${sum};`);
            }
        }
    }
}

multiplyTable(324)
multiplyTable(222)