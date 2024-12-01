function vacation(input) {
    const neededMoney = Number(input[0]);
    let currentMoney = Number(input[1]);

    let counterSpendDays = 0;
    let daysCounter = 0;

    let counter = 2;
    while (currentMoney < neededMoney) {
        const action = input[counter++];
        const amount = Number(input[counter++]);

        daysCounter++;

        if (action === "save") {
            currentMoney += amount;
            counterSpendDays = 0;
        } else if (action === "spend") {
            currentMoney -= amount;
            if (currentMoney < 0) {
                currentMoney = 0;
            }
            counterSpendDays++;
            if (counterSpendDays === 5) {
                break;
            }
        }
    }

    if (counterSpendDays === 5) {
        console.log(`You can't save the money.`);
        console.log(`${daysCounter}`);
    } else {
        console.log(`You saved the money for ${daysCounter} days.`);
    }
}