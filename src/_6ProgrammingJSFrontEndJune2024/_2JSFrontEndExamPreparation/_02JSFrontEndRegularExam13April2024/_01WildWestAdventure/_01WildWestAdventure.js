function solve(input) {
    const numberOfCharacters = Number(input[0]);
    let characters = [];
    for (let i = 1; i <= numberOfCharacters; i++) {
        const characterInfo = input[i].split(' ');
        const character = {
            name: characterInfo[0],
            healthPoint: Number(characterInfo[1]),
            bullets: Number(characterInfo[2]),
        }
        characters.push(character);
    }
    for (let i = (Number(numberOfCharacters) + 1); i < input.length; i++) {
        const command = input[i].split(' - ');
        if (command[0] === 'FireShot') {
            let character = characters.find(char => char.name === command[1]);
            let target = characters.find(char => char.name === command[2]);
            if (target === undefined) {
                target = {
                    name: 'Bandit'
                }
            }
            if (character.bullets > 0) {
                character.bullets--;
                console.log(`${character.name} has successfully hit ${target.name} and now has ${character.bullets} bullets!`)
            } else {
                console.log(`${character.name} doesn't have enough bullets to shoot at ${target.name}!`)
            }
        } else if (command[0] === 'TakeHit') {
            let character = characters.find(char => char.name === command[1]);
            let attacker = characters.find(char => char.name === command[3]);
            if (attacker === undefined) {
                attacker = {
                    name: 'Bandit'
                }
            }
            character.healthPoint -= Number(command[2]);
            if (character.healthPoint > 0) {
                console.log(`${character.name} took a hit for ${command[2]} HP from ${attacker.name} and now has ${character.healthPoint} HP!`)
            } else {
                console.log(`${character.name} was gunned down by ${attacker.name}!`)
                characters = characters.filter(current => current.name !== command[1]);
            }
        } else if (command[0] === 'Reload') {
            let character = characters.find(char => char.name === command[1]);
            const previousBullets = character.bullets;
            const reloadedBullets = 6 - previousBullets;
            if (previousBullets < 6) {
                console.log(`${character.name} reloaded ${reloadedBullets} bullets!`)
                character.bullets = 6;
            } else {
                console.log(`${character.name}'s pistol is fully loaded!`)
            }
        } else if (command[0] === 'PatchUp') {
            let character = characters.find(char => char.name === command[1]);
            const previousHealth = character.healthPoint;
            let newHealth = previousHealth + Number(command[2]);
            if (newHealth > 100) {
                newHealth = 100;
            }
            const healedPoints = newHealth - previousHealth;
            character.healthPoint = newHealth;
            if (previousHealth < 100) {
                console.log(`${character.name} patched up and recovered ${healedPoints} HP!`)
            } else {
                console.log(`${character.name} is in full health!`)
            }
        } else if (command[0] === 'Ride Off Into Sunset') {
            for (let i = 0; i < characters.length; i++) {
                const character = characters[i];
                console.log(`${character.name}`);
                console.log(` HP: ${character.healthPoint}`);
                console.log(` Bullets: ${character.bullets}`);
            }
            break;
        }
    }
}


