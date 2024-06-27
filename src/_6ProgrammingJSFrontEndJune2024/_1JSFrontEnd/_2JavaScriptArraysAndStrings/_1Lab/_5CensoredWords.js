function solve(text, censoredWord) {
    let censored = text.replaceAll(censoredWord, '*'.repeat(censoredWord.length));
    console.log(censored)
}