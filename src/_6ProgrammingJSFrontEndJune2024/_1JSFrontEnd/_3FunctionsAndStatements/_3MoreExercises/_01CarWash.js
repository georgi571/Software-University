function carWash(commands) {
    let cleanPercent = 0;
    for (let command of commands) {
        if (command === 'soap') {
            cleanPercent += 10;
        } else if (command === 'water') {
            cleanPercent *= 1.2;
        } else if (command === 'vacuum cleaner') {
            cleanPercent *= 1.25;
        } else if (command === 'mud') {
            cleanPercent *= 0.9;
        }
    }
    console.log(`The car is ${cleanPercent.toFixed(2)}% clean.`)
}