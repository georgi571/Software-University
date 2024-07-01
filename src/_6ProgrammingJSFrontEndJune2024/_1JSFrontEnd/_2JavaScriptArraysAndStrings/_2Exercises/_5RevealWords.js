function solve(wordsInput, templateInput) {
    const words = wordsInput.split(', ');
    const template = templateInput.split(' ');
    for (let i = 0; i < template.length; i++) {
        let firstChar = template[i];
        if (firstChar[0] === '*') {
            for (let word of words) {
                if (template[i].length === word.length) {
                    template[i] = word;
                }
            }
        }
    }
    let output = '';
    for (let templateElement of template) {
        output += templateElement + ' ';
    }
    console.log(output);
}