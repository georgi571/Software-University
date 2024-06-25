function solve(number, operator1, operator2, operator3, operator4, operator5) {
    let finalNumber = number;
    for (let i = 0; i < 5; i++) {
        let operator;
        if (i === 0) {
            operator = operator1;
        } else if (i === 1) {
            operator = operator2;
        } else if (i === 2) {
            operator = operator3;
        } else if (i === 3) {
            operator = operator4;
        } else if (i === 4) {
            operator = operator5;
        }
        if (operator === 'chop') {
            finalNumber /= 2;
        } else if (operator === 'dice') {
            finalNumber = Math.sqrt(finalNumber);
        } else if (operator === 'spice') {
            finalNumber++;
        } else if (operator === 'bake') {
            finalNumber *= 3;
        } else if (operator === 'fillet') {
            finalNumber -= finalNumber * 0.20;
        }
        console.log(finalNumber);
    }
}
