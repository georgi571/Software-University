function printAndSum(first, second) {
    let output = '';
    let sum = 0;
    for (let i = first; i <= second; i++) {
        output += i + ' ';
        sum += i;
    }
    console.log(`${output}`);
    console.log(`Sum: ${sum}`);
}