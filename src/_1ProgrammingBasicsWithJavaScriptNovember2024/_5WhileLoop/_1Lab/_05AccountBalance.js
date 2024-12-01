function accountBalance(input) {
    let amount = input[0];
    let total = 0.00;

    let counter = 1;
    while (amount !== "NoMoreMoney") {
        const money = Number(amount);

        if (money < 0) {
            console.log(`Invalid operation!`);
            break;
        }

        total += money;
        console.log(`Increase: ${money.toFixed(2)}`);

        amount = input[counter++];
    }

    console.log(`Total: ${total.toFixed(2)}`);
}