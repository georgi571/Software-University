function oddOccurrences(input) {
    const words = input.toLowerCase().split(' ');
    let wordsToCheck = input.toLowerCase().split(' ');
    let output = '';
    for (const word of words) {
        const counter = wordsToCheck.filter(currentWord => currentWord === word).length;
        if (counter % 2 === 1) {
            output += word + ' ';
        }
        wordsToCheck = wordsToCheck.filter(currentWord => currentWord !== word);
    }
    console.log(output);
}