function vowelsSum(word) {
    const VALUE_OF_A = 1;
    const VALUE_OF_E = 2;
    const VALUE_OF_I = 3;
    const VALUE_OF_O = 4;
    const VALUE_OF_U = 5;

    let sum = 0;

    for (let i = 0; i < word.length; i++) {
        const symbol = word[i];
        if (symbol === 'a' ) {
            sum += VALUE_OF_A;
        } else if(symbol === 'e') {
            sum += VALUE_OF_E;
        } else if(symbol === 'i') {
            sum += VALUE_OF_I;
        } else if(symbol === 'o') {
            sum += VALUE_OF_O;
        } else if(symbol === 'u') {
            sum += VALUE_OF_U;
        }
    }

    console.log(`${sum}`);

}