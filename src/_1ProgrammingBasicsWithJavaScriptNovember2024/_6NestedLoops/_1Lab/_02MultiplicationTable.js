function multiplicationTable() {
    for (let i = 1; i <= 10; i++) {
        for (let j = 1; j <= 10; j++) {
            const sum = i * j;
            console.log(`${i} * ${j} = ${sum}`);
        }
    }
}