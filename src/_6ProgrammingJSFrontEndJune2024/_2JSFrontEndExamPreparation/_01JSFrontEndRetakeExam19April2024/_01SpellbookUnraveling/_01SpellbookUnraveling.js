function solve(inputs) {
    let word = inputs[0];
    for (let i = 1; i < inputs.length; i++) {
        if (inputs[i] === 'RemoveEven') {
            let oldWord = word;
            word = '';
            for (let j = 0; j < oldWord.length; j++) {
                if (j % 2 === 0) {
                    word += oldWord[j];
                }
            }
        } else if (inputs[i].includes('TakePart')) {
            const index = inputs[i].split('!');
            let oldWord = word;
            word = '';
            for (let j = index[1]; j < index[2]; j++) {
                word += oldWord[j];
            }
        } else if (inputs[i].includes('Reverse')) {
            const index = inputs[i].split('!');
            const wordToReplace = index[1];
            if (word.includes(wordToReplace)) {
                let replacer = '';
                for (let j = wordToReplace.length - 1; j >= 0; j--) {
                    replacer += wordToReplace[j];
                }
                word = word.replace(wordToReplace, '');
                word += replacer;
            } else {
                console.log('Error');
                continue;
            }
        } else if (inputs[i].includes('End')) {
            console.log(`The concealed spell is: ${word}`);
            continue;
        }
            console.log(word);
    }
}