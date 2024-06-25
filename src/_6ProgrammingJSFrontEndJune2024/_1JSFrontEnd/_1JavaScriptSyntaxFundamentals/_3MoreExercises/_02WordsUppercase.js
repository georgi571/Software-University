function solve(input) {
    const pattern = /\b\w+\b/g;
    let match;
    let result = '';
    while ((match = pattern.exec(input)) !== null) {
        let upperWord = match[0].toUpperCase();
        if (result === '') {
            result += upperWord;
        } else {
            result += ', ' + upperWord;
        }
    }
    console.log(result);
}