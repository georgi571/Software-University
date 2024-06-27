function solve(array) {
    array.sort((a, b) => a -b);
    let output = [];
    let index = 0;
    for (let i = 0; i < array.length; i++) {
        output[index++] = array[i]
        if (index === array.length) {
            break;
        }
        output[index++] = array[array.length - i - 1]
        if (index === array.length) {
            break;
        }
    }
    return output;
}