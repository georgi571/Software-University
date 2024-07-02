function solve(input) {
    let bitcoins = 0;
    let money = 0;
    let counter = 0;
    let firstDay = 0;
    for (let i = 0; i < input.length; i++) {
        let goldForTheDay = input[i];
        counter++;
        if (counter % 3 === 0) {
            goldForTheDay *= 0.70;
        }
        money += goldForTheDay * 67.51;
        while (money >= 11949.16) {
            bitcoins++;
            money -= 11949.16;
            if (bitcoins === 1) {
                firstDay += counter;
            }
        }
    }
    console.log(`Bought bitcoins: ${bitcoins}`);
    if (bitcoins > 0) {
        console.log(`Day of the first purchased bitcoin: ${firstDay}`);
    }
    console.log(`Left money: ${money.toFixed(2)} lv.`);
}