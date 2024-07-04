function charactersInRange(firstChar, secondChar) {
    const first = firstChar.charCodeAt(0);
    const second = secondChar.charCodeAt(0);
    let output = '';
    if (first < second) {
        for (let i = first + 1; i < second; i++) {
            output += String.fromCharCode(i) + ' ';
        }
    } else {
        for (let i = second + 1; i < first; i++) {
            output += String.fromCharCode(i) + ' ';
        }
    }
    console.log(output)
}