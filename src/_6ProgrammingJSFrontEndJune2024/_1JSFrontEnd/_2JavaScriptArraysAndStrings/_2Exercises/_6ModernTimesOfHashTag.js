function solve(textInput) {
    const textArray = textInput.split(' ');
    for (let textArrayElement of textArray) {
        if (textArrayElement[0] === '#' && textArrayElement.length > 1) {
            const output = textArrayElement.replace('#', '');
            let regex = /^[A-Za-z]+$/;
            if (regex.test(output)) {
                console.log(output);
            }
        }
    }
}