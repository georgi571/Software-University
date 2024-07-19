function solve() {
    document.getElementById('output').textContent = '';
    const textSentences = document.getElementById('input').value.split('.').filter(text => !!text);
    let output = [];
    for (let i = 0; i < textSentences.length; i += 3) {
        const pElement = document.createElement('p');
        let counter = 0;
        for (let k = i;  k < textSentences.length; k++) {
            if (counter === 3 || k === textSentences.length) {
                break;
            }
            pElement.textContent += textSentences[k] + '.';
            counter++;
        }
        output.push(pElement);
    }
    for (let outputElement of output) {
        document.getElementById('output').appendChild(outputElement);
    }
}