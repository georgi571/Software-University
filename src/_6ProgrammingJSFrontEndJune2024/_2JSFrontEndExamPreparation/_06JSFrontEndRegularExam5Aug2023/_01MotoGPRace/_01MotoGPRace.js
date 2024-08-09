function solve(input) {
    const numberOfRiders = Number(input[0]);
    let riders = [];
    for (let i = 1; i <= numberOfRiders; i++) {
        const riderInfo = input[i].split('|');
        const rider = {
            name: riderInfo[0],
            fuel: Number(riderInfo[1]),
            position: Number(riderInfo[2]),
        }
        riders.push(rider);
    }
    for (let i = 1 + numberOfRiders; i < input.length; i++) {
        const commands = input[i].split(' - ');
        const command = commands[0];
        const rider = riders.find(rider => rider.name === commands[1]);
        if (command === 'StopForFuel') {
            const minimumFuel = Number(commands[2]);
            const position = Number(commands[3]);
            if (rider.fuel >= minimumFuel) {
                console.log(`${rider.name} does not need to stop for fuel!`)
            } else {
                rider.position = position;
                console.log(`${rider.name} stopped to refuel but lost his position, now he is ${rider.position}.`)
            }
        } else if (command === 'Overtaking') {
            const rider2 = riders.find(rider => rider.name === commands[2]);
            if (rider.position < rider2.position) {
                const position1 = rider.position;
                rider.position = rider2.position;
                rider2.position = position1;
                console.log(`${rider.name} overtook ${rider2.name}!`)
            }
        } else if (command === 'EngineFail') {
            const lapsLeft = Number(commands[2]);
            riders = riders.filter(currentRider => currentRider.name !== rider.name);
            console.log(`${rider.name} is out of the race because of a technical issue, ${lapsLeft} laps before the finish.`);
        } else if (command === 'Finish') {
            for (let currentRider of riders) {
                console.log(`${currentRider.name}`);
                console.log(`  Final position: ${currentRider.position}`);
            }
        }
    }
}