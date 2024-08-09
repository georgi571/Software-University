function solve(input) {
    const numberOfBarista = Number(input[0]);
    const baristas = [];
    for (let i = 1; i <= numberOfBarista; i++) {
        const baristaInfo = input[i].split(' ');
        const baristaCoffee = baristaInfo[2].split(',');
        const barista = {
            name: baristaInfo[0],
            shift: baristaInfo[1],
            coffee: baristaCoffee,
        }
        baristas.push(barista);
    }
    for (let i = 1 + numberOfBarista; i < input.length; i++) {
        const commands = input[i].split(' / ');
        const command = commands[0];
        const barista = baristas.find(barista => barista.name === commands[1]);
        if (command === 'Prepare') {
            const shift = commands[2];
            const coffeeType = commands[3];
            if (barista.shift === shift && barista.coffee.includes(coffeeType)) {
                console.log(`${barista.name} has prepared a ${coffeeType} for you!`)
            } else {
                console.log(`${barista.name} is not available to prepare a ${coffeeType}.`)
            }
        } else if (command === 'Change Shift') {
            const shift = commands[2];
            barista.shift = shift;
            console.log(`${barista.name} has updated his shift to: ${shift}`);

        } else if (command === 'Learn') {
            const newCoffeeType = commands[2];
            if (barista.coffee.includes(newCoffeeType)) {
                console.log(`${barista.name} knows how to make ${newCoffeeType}.`)
            } else {
                console.log(`${barista.name} has learned a new coffee type: ${newCoffeeType}.`)
                barista.coffee.push(newCoffeeType);
            }
        } else if (command === 'Closed') {
            for (let currentBarista of baristas) {
                console.log(`Barista: ${currentBarista.name}, Shift: ${currentBarista.shift}, Drinks: ${currentBarista.coffee.join(', ')}`)
            }
        }
    }
}