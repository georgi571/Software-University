function cleverLily(years, washingMachinePrice, sellingPricePerToy) {
    const LILI_BROTHER_STEAL_MONEY = 1;

    let numberOfToys = 0;
    let money = 0;

    for (let i = 1; i <= years; i++) {
        if (i % 2 === 0) {
            money += (i / 2) * 10;
            money -= LILI_BROTHER_STEAL_MONEY;
        } else {
            numberOfToys++;
        }
    }

    const moneyFromToys = numberOfToys * sellingPricePerToy;
    const totalMoney = money + moneyFromToys;

    const diff = Math.abs(totalMoney - washingMachinePrice);

    if (totalMoney >= washingMachinePrice) {
        console.log(`Yes! ${diff.toFixed(2)}`);
    } else {
        console.log(`No! ${diff.toFixed(2)}`);
    }
}