function solve(array, numberOfRotation) {
    let oldRotation = array;
    let newRotation = [];
    for (let i = 0; i < numberOfRotation; i++) {
        for (let j = 1; j < oldRotation.length; j++) {
            newRotation[j - 1] = oldRotation[j];
        }
        newRotation[oldRotation.length - 1] = oldRotation[0];
        oldRotation = newRotation;
        newRotation = [];
    }
    let output = '';
    for (let i = 0; i < oldRotation.length; i++) {
        output += oldRotation[i] + ' ';
    }
    console.log(output);
}