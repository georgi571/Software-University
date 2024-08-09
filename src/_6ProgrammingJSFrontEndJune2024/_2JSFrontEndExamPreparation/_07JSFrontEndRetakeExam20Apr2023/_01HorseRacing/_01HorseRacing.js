function solve(input) {
    const horses = input[0].split('|');
    for (let i = 1; i < input.length; i++) {
        const commands = input[i].split(' ');
        const command = commands[0];
        if (command === 'Retake') {
            const overtakingHorse = commands[1];
            const overtakenHorse = commands[2];
            const indexOvertaking = horses.indexOf(overtakingHorse);
            const indexOvertaken = horses.indexOf(overtakenHorse);
            if (indexOvertaking < indexOvertaken) {
                horses[indexOvertaken] = overtakingHorse;
                horses[indexOvertaking] = overtakenHorse;
                console.log(`${overtakingHorse} retakes ${overtakenHorse}.`);
            }
        } else if (command === 'Trouble') {
            const horseToDrop = commands[1];
            const indexOfDropping = horses.indexOf(horseToDrop);
            if (indexOfDropping > 0) {
                const horse = horses[indexOfDropping - 1];
                horses[indexOfDropping - 1] = horseToDrop;
                horses[indexOfDropping] = horse;
                console.log(`Trouble for ${horseToDrop} - drops one position.`)
            }
        } else if (command === 'Rage') {
            const horseToRage = commands[1];
            for (let j = 0; j < 2; j++) {
                const indexOfRage = horses.indexOf(horseToRage);
                if (indexOfRage < horses.length - 1) {
                    horses[indexOfRage] = horses[indexOfRage + 1];
                    horses[indexOfRage + 1] = horseToRage;
                }
            }
            console.log(`${horseToRage} rages 2 positions ahead.`)
        } else if (command === 'Miracle') {
            const horseToMiracle = horses[0];
            horses.shift();
            horses.push(horseToMiracle);
            console.log(`What a miracle - ${horseToMiracle} becomes first.`)
        } else {
            console.log(`${horses.join('->')}`);
            console.log(`The winner is: ${horses.pop()}`)
            return;
        }
    }
}


