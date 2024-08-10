function solve(input) {
    let groceries = input[0].split('!');
    for (let i = 1; i < input.length; i++) {
        const commands = input[i].split(' ');
        const command = commands[0];
        if (command === 'Urgent') {
            if (!groceries.includes(commands[1])) {
                groceries = [commands[1], ...groceries]
            }
        } else if (command === 'Unnecessary') {
            if (groceries.includes(commands[1])) {
                groceries = groceries.filter(g => g !== commands[1])
            }
        } else if (command === 'Correct') {
            if (groceries.includes(commands[1])) {
                const index = groceries.indexOf(commands[1]);
                groceries[index] = commands[2];
            }
        } else if (command === 'Rearrange') {
            if (groceries.includes(commands[1])) {
                groceries = groceries.filter(g => g !== commands[1])
                groceries = [...groceries, commands[1]];
            }
        }
    }
    console.log(groceries.join(', '));
}
