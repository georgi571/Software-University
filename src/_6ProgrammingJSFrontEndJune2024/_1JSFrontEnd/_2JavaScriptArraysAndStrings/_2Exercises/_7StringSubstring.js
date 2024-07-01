function solve(word, textInput) {
    let text = textInput.toLowerCase().split(' ');
    if (text.includes(word.toLowerCase())) {
        console.log(word);
    } else {
        console.log(word + ' not found!');
    }
}