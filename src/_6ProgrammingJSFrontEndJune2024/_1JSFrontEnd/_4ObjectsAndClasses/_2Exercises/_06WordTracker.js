function wordTracker(input) {
    let wordsCounter = [];
    const words = input[0].toString().split(' ');
    for (const currentWord of words) {
        const word = {
            wordName: currentWord,
            wordCounter: Number(0),
        }
        wordsCounter.push(word);
    }
    for (let wordsCounterElement of wordsCounter) {
        for (let i = 1; i < input.length; i++) {
            if (wordsCounterElement.wordName === input[i]) {
                wordsCounterElement.wordCounter += 1;
            }
        }
    }
    wordsCounter.sort((a, b) => b.wordCounter - a.wordCounter);
    for (let wordsCounterElement of wordsCounter) {
        console.log(`${wordsCounterElement.wordName} - ${wordsCounterElement.wordCounter}`);
    }
}