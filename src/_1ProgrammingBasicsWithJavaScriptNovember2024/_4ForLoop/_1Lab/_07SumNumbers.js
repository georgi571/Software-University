function sumNumbers(num) {
    let sum = 0;

    for (let i = 0; i < num.length; i++) {
        const number = Number(num[i]);

        sum += number;
    }

    console.log(`The sum of the digits is:${sum}`);
}