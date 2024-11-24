function multiplicationTable(number) {
    for (let i = 1; i <= 10 ; i++) {
        const result = i * number;
        console.log(`${i} * ${number} = ${result}`);
    }
}