function solve(input) {
    let word = input[0];
    let newWord = '';
    for (let i = 1; i < input.length; i++) {
        if (input[i] === 'TakeEven') {
            for (let i = 0; i < word.length; i+= 2) {
                newWord += word[i];
            }
            word = newWord;
            newWord = '';
            console.log(word);
        } else if (input[i].includes('ChangeAll')) {
            const old = input[i].split('?')[1];
            const replacer = input[i].split('?')[2];
            word = word.replace(new RegExp(old, 'g'), replacer);
            console.log(word);
        } else if (input[i].includes('Reverse')) {
            const old = input[i].split('?')[1];
            const replacer = old.split('').reverse().join('');
            if (word.includes(old)) {
                word = word.replace(old, '');
                word += replacer;
                console.log(word);
            } else {
                console.log('error')
            }
        } else if (input[i] === 'Buy') {
            console.log(`The cryptocurrency is: ${word}`);
        }
    }
}
