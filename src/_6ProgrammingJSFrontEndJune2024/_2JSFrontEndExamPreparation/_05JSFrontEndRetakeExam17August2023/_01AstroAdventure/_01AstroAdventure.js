function solve(input) {
    const numberOfAstronaut = Number(input[0]);
    const astronauts = [];
    for (let i = 1; i <= numberOfAstronaut; i++) {
        const astronautInfo = input[i].split(' ');
        const astronaut = {
            name: astronautInfo[0],
            oxygen: Number(astronautInfo[1]),
            energy: Number(astronautInfo[2]),
        }
        astronauts.push(astronaut);
    }
    for (let i = 1 + numberOfAstronaut; i < input.length; i++) {
        const commands = input[i].split(' - ');
        const command = commands[0];
        const astronaut = astronauts.find(astronaut => astronaut.name === commands[1]);
        const amount = Number(commands[2]);
        if (command === 'Explore') {
            if (astronaut.energy >= amount) {
                astronaut.energy -= amount;
                console.log(`${astronaut.name} has successfully explored a new area and now has ${astronaut.energy} energy!`)
            } else {
                console.log(`${astronaut.name} does not have enough energy to explore!`)
            }
        } else if (command === 'Refuel') {
            const oldEnergy = astronaut.energy;
            let newEnergy = oldEnergy + amount;
            if (newEnergy > 200) {
                newEnergy = 200;
            }
            const increase = newEnergy - oldEnergy;
            astronaut.energy = newEnergy;
            console.log(`${astronaut.name} refueled their energy by ${increase}!`);
        } else if (command === 'Breathe') {
            const oldOxygen = astronaut.oxygen;
            let newOxygen = oldOxygen + amount;
            if (newOxygen > 100) {
                newOxygen = 100;
            }
            const increase = newOxygen - oldOxygen;
            astronaut.oxygen = newOxygen;
            console.log(`${astronaut.name} took a breath and recovered ${increase} oxygen!`);
        } else if (command === 'End') {
            for (let currentAstronaut of astronauts) {
                console.log(`Astronaut: ${currentAstronaut.name}, Oxygen: ${currentAstronaut.oxygen}, Energy: ${currentAstronaut.energy}`)
            }
        }
    }
}