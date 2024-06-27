function solve(array, number) {
    let output = [];
    let index = 0;
    for (let i = 0; i < array.length; i += number) {
        output[index] = array[i];
        index++;
    }
    return output;
}