function solve(input) {
    let output = '';
    for (let i = 0; i < input.length; i++) {
        if (input[i] === input[i].toUpperCase()) {
            if (i === 0) {
                output += input[i];
            } else {
                output += ', ' + input[i];
            }
        } else {
            output += input[i];
        }
    }
    console.log(output);
}