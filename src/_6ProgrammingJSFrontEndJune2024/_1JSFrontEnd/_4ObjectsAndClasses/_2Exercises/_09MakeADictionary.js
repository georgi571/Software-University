function makeADictionary(input) {
    const dictionary = input.map(JSON.parse);
    let newDictionary = {};
    for (let dictionaryElement of dictionary) {
        const word = Object.keys(dictionaryElement)[0];
        newDictionary[word] = dictionaryElement[word];
    }
    Object.entries(newDictionary)
        .sort((a,b) => a[0].localeCompare(b[0]))
        .forEach(([key, value]) => console.log(`Term: ${key} => Definition: ${value}`));
}