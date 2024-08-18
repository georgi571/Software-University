function solve(input) {
    const numberOfCharacters = Number(input[0]);
    let superHeroes = [];
    for (let i = 1; i <= numberOfCharacters; i++) {
        const characterInfo = input[i].split('-');
        const powers = characterInfo[1].split(',');
        const character = {
            name: characterInfo[0],
            power: [],
            energy: Number(characterInfo[2]),
        }
        for (let power of powers) {
            character.power.push(power);
        }
        superHeroes.push(character);
    }
    for (let i = (Number(numberOfCharacters) + 1); i < input.length; i++) {
        const command = input[i].split(' * ');
        if (command[0] === 'Use Power') {
            let character = superHeroes.find(char => char.name === command[1]);
            if (character.power.includes(command[2]) && character.energy >= Number(command[3])) {
                character.energy -= Number(command[3]);
                console.log(`${character.name} has used ${command[2]} and now has ${character.energy} energy!`);
            } else {
                console.log(`${character.name} is unable to use ${command[2]} or lacks energy!`);
            }
        } else if (command[0] === 'Train') {
            let character = superHeroes.find(char => char.name === command[1]);
            const previousEnergy = character.energy;
            let newEnergy = previousEnergy + Number(command[2]);
            if (newEnergy > 100) {
                newEnergy = 100;
            }
            const increasedEnergy = newEnergy - previousEnergy;
            character.energy = newEnergy;
            if (previousEnergy < 100) {
                console.log(`${character.name} has trained and gained ${increasedEnergy} energy!`)
            } else {
                console.log(`${character.name} is already at full energy!`)
            }
        } else if (command[0] === 'Learn') {
            let character = superHeroes.find(char => char.name === command[1]);
            if (character.power.includes(command[2])) {
                console.log(`${character.name} already knows ${command[2]}.`)
            } else {
                character.power.push(command[2]);
                console.log(`${character.name} has learned ${command[2]}!`)
            }
        } else if (command[0] === 'Evil Defeated!') {
            for (let superHero of superHeroes) {
                console.log(`Superhero: ${superHero.name}`);
                console.log(`- Superpowers: ${superHero.power.join(', ')}`);
                console.log(`- Energy: ${superHero.energy}`);
            }
            break;
        }
    }
}