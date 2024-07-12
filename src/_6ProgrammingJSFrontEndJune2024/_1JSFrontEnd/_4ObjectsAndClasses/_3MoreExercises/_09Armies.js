function armies(input) {
    let army = {};
    for (let inputElement of input) {
        if (inputElement.includes('arrives')) {
            army[inputElement.split(' arrives')[0]] = [];
        } else if (inputElement.includes(':')) {
            let currentArmy = [];
            currentArmy.push(inputElement.split(': ')[1].split(', ')[0]);
            currentArmy.push(Number(inputElement.split(': ')[1].split(', ')[1]));
            if (army[inputElement.split(': ')[0]]) {
                army[inputElement.split(': ')[0]].push(currentArmy);
            }
        } else if (inputElement.includes('+')) {
            for (let armyKey in army) {
                for (let i = 0; i < army[armyKey].length; i++) {
                    for (let j = 0; j < army[armyKey][i].length; j += 2) {
                        if (army[armyKey][i][j] === inputElement.split(' + ')[0]) {
                            army[armyKey][i][j + 1] += Number(inputElement.split(' + ')[1]);
                        }
                    }
                }
            }
        } else if (inputElement.includes('defeated')) {
            delete army[inputElement.split(' defeated')[0]];
        }
    }
    let finalArmies = {};
    for (let armyKey in army) {
        let counter = 0;
        for (let i = 0; i < army[armyKey].length; i++) {
            for (let j = 1; j < army[armyKey][i].length; j += 2) {
                counter += Number(army[armyKey][i][j]);
            }
        }
        finalArmies[armyKey] = counter;
    }
    let sortedArmies = Object.entries(finalArmies).sort((a, b) => b[1] - a[1]);
    for (let armyKey in army) {
        army[armyKey].sort((a, b) => b[1] - a[1]);
    }
    for (let sortedArmy of sortedArmies) {
        console.log(`${sortedArmy[0]}: ${sortedArmy[1]}`);
        for (let i = 0; i < army[sortedArmy[0]].length; i++) {
            for (let j = 1; j < army[sortedArmy[0]][i].length; j += 2) {
                console.log(`>>> ${army[sortedArmy[0]][i][0]} - ${army[sortedArmy[0]][i][1]}`)
            }
        }
    }
}